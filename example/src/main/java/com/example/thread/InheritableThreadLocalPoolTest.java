package com.example.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */
public class InheritableThreadLocalPoolTest {
  static ThreadLocal<String> local = new InheritableThreadLocal();
  static ThreadPoolExecutor executor = new ThreadPoolExecutor(8,
    20,
    10,
    TimeUnit.MICROSECONDS,
    new LinkedBlockingQueue<>());

  public static void main(String[] args) throws InterruptedException {
    int i = 0;
    int j = 0;
    while (true) {
      local.set("abc-ccc" + i);
      executor.execute(() -> {
        System.out.println(local.get());
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      });
      i++;
      if (i > 20) {
        i = 0;
        Thread.sleep(1000);
        System.out.println("-----------------");
      }
    }
  }
}
