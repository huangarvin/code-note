package com.dubbo.example

import org.apache.dubbo.config.ApplicationConfig
import org.apache.dubbo.config.ConfigCenterConfig
import org.apache.dubbo.config.ReferenceConfig
import org.apache.dubbo.config.bootstrap.DubboBootstrap
import org.apache.dubbo.config.context.ConfigManager
import org.apache.dubbo.rpc.service.GenericService

/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */

object DubboExample {

  fun dubboDirectConnection() {
    System.setProperty("com.tuya.shendeng.application.device.IDeviceElectricityReportAppService", "dubbo://127.0.0.1:21913")

    val bootstrap: DubboBootstrap = DubboBootstrap.getInstance()
    bootstrap.application("Feng")
    val reference: ReferenceConfig<GenericService> = ReferenceConfig()
    reference.url = "dubbo://127.0.0.1:21913/com.tuya.shendeng.application.device.IDeviceElectricityReportAppService"
    reference.setInterface(GenericService::class.java)
    reference.generic = "true"

    val get = reference.get()
    val string = arrayOf(String::class.java.name, String::class.java.name)
    val any = get.`$invoke`("reportGet", string, arrayOf("q", "20201010"))
    println(any)
  }

}


fun main() {
  DubboExample.dubboDirectConnection()
}
