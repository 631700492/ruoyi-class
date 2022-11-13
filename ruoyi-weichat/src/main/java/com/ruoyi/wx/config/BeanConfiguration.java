package com.ruoyi.wx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author TwoKe
 * @desc Bean注入
 * @date 2020/6/30
 */
@Configuration
public class BeanConfiguration {


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
