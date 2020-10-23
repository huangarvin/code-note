package com.example.listener;

/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */
public class ListenerMain {
  public static void main(String[] args) {
    listener();
  }

  private static void listener() {
    Worker worker = new Worker();
    worker.addListener(new BossComingListener());
    worker.setName("huang arvin ");
    worker.lookBoosComing();
  }
}
