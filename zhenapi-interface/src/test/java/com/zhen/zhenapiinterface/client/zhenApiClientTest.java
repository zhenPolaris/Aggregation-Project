package com.zhen.zhenapiinterface.client;

import com.zhen.zhenapiclientsdk.client.ZhenApiClient;
import com.zhen.zhenapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * @Description:
 * @Author: zhen
 * @CreateTime: 2023/9/4 23:50
 */
@SpringBootTest
public class    zhenApiClientTest {
    @Resource
    private ZhenApiClient zhenApiClient;

//    @Test
//    void test01() throws UnsupportedEncodingException {
//        String accessKey = "zhen";
//        String secretKey = "zhen";
//        zhenApiClient zhenApiClient = new zhenApiClient(accessKey, secretKey);
//        String zhen = zhenApiClient.getNameByGet("zhen");
//        String zhang = zhenApiClient.getNameByPost("zhang");
//        User user = new User();
//        user.setUsername("zhen&zhang");
//        String nameByPostWithJson = zhenApiClient.getNameByPostWithJson(user);
//        System.out.println(zhen);
//        System.out.println(zhang);
//        System.out.println(nameByPostWithJson);
//    }


      @Test
      void test02() throws UnsupportedEncodingException {
          String zhen = zhenApiClient.getNameByGet("zhen");
          String zhang = zhenApiClient.getNameByPost("zhang");
          User user = new User();
          user.setUsername("zhen&zhang");
          String nameByPostWithJson = zhenApiClient.getNameByPostWithJson(user);
          System.out.println(zhen);
          System.out.println(zhang);
          System.out.println(nameByPostWithJson);
     }
}
