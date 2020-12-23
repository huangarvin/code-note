package com.boot.example.controller;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */
@RestController
@RequestMapping
public class GetBodyController {


  @RequestMapping("/getbody")
  public Object getBody(@RequestBody Map<Object, Object> param) {
    System.out.println(param);
    return param;
  }
}
