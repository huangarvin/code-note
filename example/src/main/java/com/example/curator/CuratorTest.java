package com.example.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.GetDataBuilder;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */
public class CuratorTest {

  private static String address = "172.16.248.32:2181,172.16.248.132:2181,172.16.248.133:2181";
  private static CuratorFramework zk =
    CuratorFrameworkFactory.builder()
      .connectString(resolveAddress(address))
      .retryPolicy(new ExponentialBackoffRetry(1000, 3))
      .build();
  private static String rootPath = "/maxwell-endpoint";

  public static void main(String[] args) throws Exception {
    zk.start();
    getDate();
    zk.close();
  }

  private static void getDate() throws Exception {
    Stat stat = zk.checkExists().forPath(rootPath);
    System.out.println(stat);
    List<String> strings = zk.getChildren().forPath(rootPath);
    System.out.println(strings);
    for (String string : strings) {
      byte[] bytes = zk.getData().forPath(rootPath + "/" + string);
      System.out.println(new String(bytes));
    }
  }


  private static String resolveAddress(String address) {
    return Arrays.stream(address.split(","))
      .map(addr -> {
        final int idx = addr.indexOf("://");
        if (idx > 0) {
          return addr.substring(idx + 3);
        } else {
          return addr;
        }
      })
      .collect(Collectors.joining(","));
  }
}
