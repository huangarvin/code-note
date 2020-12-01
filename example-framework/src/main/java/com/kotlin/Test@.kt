package com.kotlin

import java.util.HashSet
import kotlin.text.String

/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */

fun main() {
  println(filterKeys(hashSetOf("112", "213")))
}

private fun filterKeys(keys: HashSet<String>): Set<String> {
  return keys.filter {
    for (prefix in arrayListOf("1")) {
      if (it.startsWith(prefix)) {
        return@filter false
      }
    }
    return@filter true
  }.toSet()
}
