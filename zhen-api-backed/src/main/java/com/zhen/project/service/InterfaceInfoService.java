package com.zhen.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhen.project.model.entity.InterfaceInfo;

/**
* @author zhen
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-08-22 00:31:15
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

}
