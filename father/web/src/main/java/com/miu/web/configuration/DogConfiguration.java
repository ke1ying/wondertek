package com.miu.web.configuration;

import com.miu.entity.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DogConfiguration {

    @Bean(name = "dog",initMethod = "init",destroyMethod = "destroy")
    @Scope("prototype")
    public Dog getDog(){
        return new Dog();
    }

}
