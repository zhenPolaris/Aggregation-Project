package com.zhen.zhenapiinterface.controller;

import com.zhen.zhenapiclientsdk.model.User;
import com.zhen.zhenapiclientsdk.utils.SignUtils;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;


/**
 * @Description: 名称api
 * @Author: zhen
 * @CreateTime: 2023/9/2 11:40
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/{name}")
    public String getNameByGet(@PathVariable(value = "name") String name){
        return "GET 你的名字是" + name;
    }


    @PostMapping
    public String getNameByPost(@RequestParam String name){
        return "POST 你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUernameByJson(@RequestBody User user, HttpServletRequest request) throws UnsupportedEncodingException {
        String accessKey = request.getHeader("accessKey");
        String body = URLDecoder.decode(request.getHeader("body"), StandardCharsets.UTF_8.name());
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        if (!accessKey.equals("zhen")){
            throw new RuntimeException("无api访问权限");
        }
        if(Long.parseLong(nonce) > 10000){

        }
        String serverSign = SignUtils.getSign(body, "zhen");
        if (!sign.equals(serverSign)) {
            throw new RuntimeException("无api访问权限");
        }
        return "POST 用户名是" + user.getUsername();

    }


}
