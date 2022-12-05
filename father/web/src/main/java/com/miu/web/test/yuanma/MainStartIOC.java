package com.miu.web.test.yuanma;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author keying
 * @date 2022-11-01 07:29:32
 */
public class MainStartIOC {

    private static Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public static void loadBeanDefinitions() {
        RootBeanDefinition rootBeanDefinitionA = new RootBeanDefinition(InstanceA.class);
        RootBeanDefinition rootBeanDefinitionB = new RootBeanDefinition(InstanceB.class);
        beanDefinitionMap.put("instanceA", rootBeanDefinitionA);
        beanDefinitionMap.put("instanceB", rootBeanDefinitionB);
    }

    public static void main(String[] args) throws Exception {
        // 加载到beanDefinition
        loadBeanDefinitions();
        // 注册bean的后置处理器

        for (String key : beanDefinitionMap.keySet()) {
            // 先创建A
            getBean(key);
        }
        InstanceA instanceA = (InstanceA) getBean("instanceA");
        System.out.println(instanceA);
    }

    private static Map<String, Object> singletonObjects = new ConcurrentHashMap<>();
    private static Map<String, Object> earlySingletonObjects = new ConcurrentHashMap<>();
    // 存放函数接口
    private static Map<String, ObjectFactory> singletonFactories = new ConcurrentHashMap<>();

    private static Set<String> singletonCurrennlyInCreation = new HashSet<>();

    public static Object getBean(String beanName) throws Exception {
        Object singleton = getSingleton(beanName);
        if (singleton != null) {
            return singleton;
        }

        // 正在创建
        if (!singletonCurrennlyInCreation.contains(beanName)) {
            singletonCurrennlyInCreation.add(beanName);
        }

        // 实例化
        RootBeanDefinition rootBeanDefinition = (RootBeanDefinition) beanDefinitionMap.get(beanName);
        Class<?> beanClass = rootBeanDefinition.getBeanClass();
        // 通过class 无参构造函数 实例化
        Object instanceBean = beanClass.newInstance();

        // 创建动态代理
        // 只在循环依赖的情况下在实例化之后创建动态代理
        //Object o = new JDKProxyBeanPostProcessor().getEarlyBeanReference(instanceBean,beanName);
        /*singletonFactories.put(beanName, new ObjectFactory() {
            @Override
            public Object getObject() throws BeansException {
                return  new JDKProxyBeanPostProcessor().getEarlyBeanReference(instanceBean,beanName);
            }
        });*/
        singletonFactories.put(beanName, () -> new JDKProxyBeanPostProcessor().getEarlyBeanReference(instanceBean, beanName));

        // 二级缓存
        //earlySingletonObjects.put(beanName, instanceBean);
        // 属性赋值
        Field[] declaredFields = beanClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Autowired annotation = declaredField.getAnnotation(Autowired.class);
            // 说明bean有autowired
            if (annotation != null) {
                // 打开访问权限
                declaredField.setAccessible(true);
                // byName  byType   拿到了 instanceB名字
                String name = declaredField.getName();
                // 拿到B的bean
                Object fileObject = getBean(name);
                declaredField.set(instanceBean, fileObject);
            }
        }
        // 初始化


        /*if(earlySingletonObjects.containsKey(beanName)){
            instanceBean = earlySingletonObjects.get(beanName);
        }*/
        // 放入缓存
        singletonObjects.put(beanName, instanceBean);
        return instanceBean;
    }

    private static Object getSingleton(String beanName) {
      /*  Object singleton = singletonObjects.get(beanName);
        if (singleton != null) {
            return singleton;
        }
        Object earlySingleton = earlySingletonObjects.get(beanName);
        if (earlySingleton != null) {

            return earlySingleton;
        }
        return null;*/
        Object bean = singletonObjects.get(beanName);
        if (bean == null && singletonCurrennlyInCreation.contains(beanName)) {
            // 是循环依赖
            bean  = earlySingletonObjects.get(beanName);
            synchronized (singletonObjects){
                if(bean == null){
                    ObjectFactory objectFactory = singletonFactories.get(beanName);
                    if (objectFactory != null) {
                        // 钩子函数 去创建 aop代理
                        bean = objectFactory.getObject();
                        earlySingletonObjects.put(beanName, bean);
                        singletonFactories.remove(beanName);
                    }
                    return bean;
                }
            }
        }
        return bean;
    }
}