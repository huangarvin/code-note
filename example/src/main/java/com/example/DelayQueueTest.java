package com.example;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */
public class DelayQueueTest {

  public static void main(String[] args) throws InterruptedException {
/*    DelayQueue queue = new DelayQueue<>();//延迟队列
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,10, 1000L, TimeUnit.MILLISECONDS,queue);
    threadPoolExecutor.prestartAllCoreThreads();*/

    DelayQueue<DelayObject> queue = new DelayQueue<>();
    queue.take();
    queue.add(new DelayObject(100));
    queue.add(new DelayObject(100));
    queue.add(new DelayObject(300));
    queue.add(new DelayObject(10));
    queue.add(new DelayObject(300));
    queue.add(new DelayObject(100));
    while (queue.size() != 0) {
      System.out.println("size: " + queue.size());
      DelayObject take = queue.take();
      System.out.println("time is: " + take.getTime());
      System.out.println("Now is: " + System.currentTimeMillis());
      System.out.println();
    }
  }
}

class DelayObject implements Delayed {

  private long time = System.currentTimeMillis();

  DelayObject(long time) {
    this.time += time;
  }

  public long getTime() {
    return time;
  }

  @Override
  public long getDelay(TimeUnit unit) {

    return unit.convert(time - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
  }

  @Override
  public int compareTo(Delayed o) {
    DelayObject object = (DelayObject) o;
    return Long.compare(time, object.time);
  }
}
