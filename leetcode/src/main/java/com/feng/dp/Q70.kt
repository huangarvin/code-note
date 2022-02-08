package com.feng.dp

/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */

fun main() {
    println(climbStairs(4))
}

fun climbStairs(n: Int): Int {
    if (n <= 2) {
        return n
    }
    var pre2 = 1
    var pre1 = 2
    for (i in 2 until n) {
        val cur = pre1 + pre2
        pre2 = pre1
        pre1 = cur
    }
    return pre1
}
