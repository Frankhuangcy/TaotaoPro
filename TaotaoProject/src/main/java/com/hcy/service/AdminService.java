package com.hcy.service;

import com.hcy.bean.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 好好学习 不做咸鱼
 * Created by Hcy on 18/8/7.
 */
public interface AdminService {

    // 查找登录名和密码
    List<Admin> findByLoginnameAndPassword(@Param("loginname") String loginname,
                                           @Param("password") String password);
}
