package com.atguigu.spring6.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 配置类
//@ComponentScan("com.atguigu.spring6.autowired") // 对autowired包开启组件扫描
@ComponentScan("com.atguigu.spring6.resource") // 对resource包开启组件扫描
public class SpringConfig {
}
