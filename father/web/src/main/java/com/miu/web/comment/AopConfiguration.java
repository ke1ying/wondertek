package com.miu.web.comment;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author keying
 * @date 2023-06-23 12:55:54
 */
@Configuration
// 强制cglib
@EnableAspectJAutoProxy(proxyTargetClass = true)
//@ComponentScan("com.miu.web")
public class AopConfiguration {

}