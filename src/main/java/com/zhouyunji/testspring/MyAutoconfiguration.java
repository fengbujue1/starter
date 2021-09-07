package com.zhouyunji.testspring;

import com.zhouyunji.bean.BoyService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(value = MyProperties.class)

//可自定义添加一些条件
//@ConditionalOnClass()
//@ConditionalOnSingleCandidate()
public class MyAutoconfiguration implements InitializingBean {

    @Bean
    public BoyService getBoyService(@Autowired MyProperties myProperties) {
        BoyService boyService = new BoyService();
        boyService.setAge(myProperties.getAge());
        boyService.setLength(myProperties.getLength());
        boyService.setName(myProperties.getName());
        return boyService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
