package com.example.listener;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */
@Data
public class Worker {

  @Getter
  private List<WorkListener> listener = new ArrayList<>();
  private String name;

  public void lookBoosComing() {
    System.out.println(name + "look boos!");
    doListener();
  }

  private void doListener() {
    WorkerEvent event = new WorkerEvent();
    event.setWorker(this);
    listener.forEach(x -> x.isWork(event));
  }


  public void addListener(WorkListener l) {
    listener.add(l);
  }
}
