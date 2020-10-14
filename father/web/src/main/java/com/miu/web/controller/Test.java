package com.miu.web.controller;

import com.miu.entity.User;
import com.miu.web.configuration.DogConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    /*
   * 测试创建对象
   *
   *         Class<User> userClass = User.class;
  User uz = userClass.newInstance();

  User u = new User("张三",1);

  User uClone = (User) u.clone();
   * */

    public static void main(String[] args) throws Exception {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DogConfiguration.class);
        applicationContext.getBean("dog");
        applicationContext.close();
    }
}
