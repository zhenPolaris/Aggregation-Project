package com.zhen.project.service.impl;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhen.project.common.ErrorCode;
import com.zhen.project.exception.BusinessException;

import com.zhen.project.mapper.UserInterfaceInfoMapper;
import com.zhen.project.model.entity.UserInterfaceInfo;
import com.zhen.project.service.UserInterfaceInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author youcheng
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
* @createDate 2023-10-18 16:25:27
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean b) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
//        String name = userInterfaceInfo.getName();
//        // 创建时，所有参数必须非空
//        if (b) {
//            if (StringUtils.isAnyBlank(name)) {
//                throw new BusinessException(ErrorCode.PARAMS_ERROR);
//            }
//        }

    }

    @Override
    @Transactional
    public boolean invokeInterfaceCount(long userId, long interfaceInfoId) {
        if (userId <= 0 || interfaceInfoId <= 0){
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }

        LambdaUpdateWrapper<UserInterfaceInfo> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(UserInterfaceInfo::getUserId, userId).eq(UserInterfaceInfo::getInterfaceInfoId, interfaceInfoId).gt(UserInterfaceInfo::getLeftNum, 0).setSql("left_num = left_num -1, total_num = total_num + 1");

        return update(wrapper);
    }
}




