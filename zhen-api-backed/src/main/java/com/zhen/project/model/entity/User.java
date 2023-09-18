package com.zhen.project.model.entity;



import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("user")
@Accessors(chain = true)
@ApiModel(value="", description="")
public class User implements Serializable {
  @TableField(exist = false)
  private static final long serialVersionUID = 1L;

  @TableId(type = IdType.AUTO)
    /**id*/
    private Long id;
    /**用户昵称*/
    private String userName;
    /**账号*/
    private String userAccount;
    /**用户头像*/
    private String userAvatar;
    /**性别*/
    private Integer gender;
    /**用户角色：user / admin*/
    private String userRole;
    /**密码*/
    private String userPassword;
    /**accessKey*/
    private String accessKey;
    /**secretKey*/
    private String secretKey;
    /**创建时间*/
    private Date createTime;
    /**更新时间*/
    private Date updateTime;
    /**是否删除*/
    private Integer isDelete;


    }

