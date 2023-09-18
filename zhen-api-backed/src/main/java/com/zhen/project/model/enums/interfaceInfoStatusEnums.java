package com.zhen.project.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 接口状态枚举类
 * @Author: zhen
 * @CreateTime: 2023/9/16 0:37
 */
public enum interfaceInfoStatusEnums {

    OFFLINE("下线", 0),
    ONLINE("上线", 1);


    private final String text;
    private final int value;

    interfaceInfoStatusEnums(String text, int value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public int getValue() {
        return value;
    }

    /**
     *
     * @return 获取值列表
     */
    public static List<Integer> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }
}
