package com.dubbo.example

import java.io.Serializable


/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */
class Person : Serializable {
  var age: Int? = null
  var name: String? = null
}


fun main(){
  println(String::class.java.name)
  println(Person::class.java.name)
}
