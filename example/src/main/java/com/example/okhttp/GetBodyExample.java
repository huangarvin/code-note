package com.example.okhttp;

import okhttp3.*;

/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */
public class GetBodyExample {
  public static void main(String[] args) {
    String url = "http://localhost:8080/getbody?";
    MediaType JSON = MediaType.get("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();
    String json = "{\"name\":\"test\",\"age\":20}";
    RequestBody body = RequestBody.create(json, JSON);
    Request request = new Request.Builder()
      .url(url)
      //.get(body)
      .build();

    try (Response response = client.newCall(request).execute()) {
      String res = response.body().string();
      System.out.println(res);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
