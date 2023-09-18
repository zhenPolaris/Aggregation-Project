package com.zhen.zhenapiclientsdk;

import com.zhen.zhenapiclientsdk.client.ZhenApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: zhen
 * @CreateTime: 2023/9/7 11:36
 */
@Configuration
@ConfigurationProperties("zhenapi.client")
@Data
@ComponentScan
public class ZhenApiClientConfig {

    private  String accessKey;
    private  String secretKey;

    @Bean
    public ZhenApiClient zhenApiClientConfig(){
        return new ZhenApiClient(accessKey, secretKey);
    }

}
