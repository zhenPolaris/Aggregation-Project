package com.zhen.zhenapiclientsdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * @Description: 签名工具类
 * @Author: zhen
 * @CreateTime: 2023/9/6 23:18
 */
public class SignUtils {

    /**
     * 生成签名
     * @author zhenzihan
     * @date 23:19 2023/9/6
     * @param body
     * @param secretKey
     * @return java.lang.String
     **/
    public static String getSign(String body, String secretKey){
        Digester digester = new Digester(DigestAlgorithm.SHA256);
        String content = body.toString()+"."+secretKey;
        return digester.digestHex(content);

    }
}
