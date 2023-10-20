package com.zhen.zhenapigateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: 全局过滤器
 * @Author: zhen
 * @CreateTime: 2023/10/20 16:34
 */
@Slf4j
@Component
public class CustomGlobalFilter implements GlobalFilter, Ordered {

    //ip白名单
    private static final List<String> IP_WHITE_LIST = Arrays.asList("127.0.0.9", "127.0.0.8");

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String remoteAddress = request.getRemoteAddress().getHostString();

        log.info("请求id: {}", request.getId());
        log.info("请求路径: {}", request.getPath());
        log.info("请求方法: {}", request.getMethod());
        log.info("请求参数: {}", request.getQueryParams());
        log.info("请求头: {}", request.getHeaders());
        log.info("请求地址: {}", request.getRemoteAddress());

        //访问控制黑白名单
        if(!IP_WHITE_LIST.contains(remoteAddress)){
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.FORBIDDEN);
            return response.setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
