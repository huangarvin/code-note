package com.example.listener;

/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */
public class BossComingListener implements WorkListener {

  @Override
  public void isWork(WorkerEvent event) {
    System.out.println(event.getWorker().getName() + "is working!");
  }

}
