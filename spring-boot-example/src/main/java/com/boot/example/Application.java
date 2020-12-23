package com.boot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */
@SpringBootApplication
//@ImportResource(locations = "classpath:dubbo-config.xml")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
