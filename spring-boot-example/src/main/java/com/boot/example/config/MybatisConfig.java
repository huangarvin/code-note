package com.boot.example.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */
@Component
@MapperScan(basePackages = "com.boot.example.mapper")
public class MybatisConfig {

  //@Bean
  MapperScannerConfigurer mapperScannerConfigurer() {
    MapperScannerConfigurer configurer = new MapperScannerConfigurer();
    configurer.setBasePackage("com.boot.example.mapper");
    return configurer;
  }
}
