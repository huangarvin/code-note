package com.example.listener;

import java.util.EventListener;
import java.util.EventObject;

/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */
public interface WorkListener extends EventListener {

  void isWork(WorkerEvent event);
}
