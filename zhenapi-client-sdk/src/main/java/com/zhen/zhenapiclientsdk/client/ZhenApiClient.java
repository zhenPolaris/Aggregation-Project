package com.zhen.zhenapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.zhen.zhenapiclientsdk.model.User;
import com.zhen.zhenapiclientsdk.utils.SignUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 调用API使用
 * @Author: zhen
 * @CreateTime: 2023/9/4 23:36
 */
public class ZhenApiClient {

    public static final String BASE_URL = "http://localhost:8123/api/";
    private final String accessKey;
    private final String secretKey;

    public ZhenApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(String name){
        return HttpUtil.get(BASE_URL + "name/" + name);
    }

    public String getNameByPost(String name){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        return HttpUtil.post(BASE_URL + "name",paramMap);
    }

    private Map<String, String> getHeaders(String body) throws UnsupportedEncodingException {
        Map<String, String> header = new HashMap<>();
        header.put("accessKey", accessKey);
//        header.put("secretKey", secretKey);
        // 防止中文乱码
        header.put("body", URLEncoder.encode(body, StandardCharsets.UTF_8.name()));
        header.put("nonce", RandomUtil.randomNumbers(4));
        header.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        header.put("sign", SignUtils.getSign(body,secretKey));
        System.out.println(secretKey);
        return header;
    }


    public String getNameByPostWithJson(User user) throws UnsupportedEncodingException {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse response = HttpRequest.post(BASE_URL + "name/user")
                .addHeaders(getHeaders(json))
                .body(json)
                .execute();
        System.out.println("response = " + response);
        System.out.println("status = " + response.getStatus());
        if (response.isOk()) {
            return response.body();
        }
        return "fail";
    }
}
