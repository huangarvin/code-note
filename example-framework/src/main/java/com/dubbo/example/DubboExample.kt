package com.dubbo.example

import org.apache.dubbo.config.ApplicationConfig
import org.apache.dubbo.config.ReferenceConfig
import org.apache.dubbo.config.RegistryConfig
import org.apache.dubbo.rpc.RpcContext
import org.apache.dubbo.rpc.service.GenericService

/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */

fun main() {
  DubboExample.dubboDirectConnection()
}

object DubboExample {

  fun dubboDirectConnection() {
    //System.setProperty("com.tuya.shendeng.application.device.IDeviceElectricityReportAppService", "dubbo://127.0.0.1:21913")
    val interfaceClass = "com.tuya.shendeng.application.device.IDubboValidation"
    val method = "check"
    val argClass: Array<String> = arrayOf(String::class.java.name, Int::class.java.name, "com.tuya.shendeng.application.device.dto.Person")
    println(String::class.java.name)
    val person = Person()
    person.age = 200
    person.name = "huang"
    val args: Array<Any?> = arrayOf("aaaa", 10, null)


    val registryConfig = RegistryConfig()
    registryConfig.address = ""
    val applicationConfig: ApplicationConfig = ApplicationConfig()
    applicationConfig.name = "Feng"
    applicationConfig.registries = arrayListOf(registryConfig)

    val reference: ReferenceConfig<GenericService> = ReferenceConfig()
    reference.application = applicationConfig
    reference.url = "dubbo://127.0.0.1:21913/$interfaceClass"
    reference.setInterface(GenericService::class.java)
    reference.generic = "true"
    //reference.validation = "true"

    val get = reference.get()
    RpcContext.getContext().attachments["proto-vendor"] = "highway"

    val any = get.`$invoke`(method, argClass, args)
    println(any)
  }
}

//class Person : Serializable {
//  var age: Int? = null
//  var name: String? = null
//}
