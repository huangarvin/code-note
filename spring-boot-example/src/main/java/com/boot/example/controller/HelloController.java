package com.boot.example.controller;

import com.boot.example.dubbo.DubboPlaceHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */
@RestController
@RequestMapping
public class HelloController {

  //@Autowired
  DubboPlaceHolder dubboPlaceHolder;
}
