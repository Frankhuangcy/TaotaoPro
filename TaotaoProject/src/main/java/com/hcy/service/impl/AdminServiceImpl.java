package com.hcy.service.impl;

import com.hcy.bean.Admin;
import com.hcy.mapper.AdminMapper;
import com.hcy.service.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 好好学习 不做咸鱼
 * Created by Hcy on 18/8/7.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public List<Admin> findByLoginnameAndPassword(@Param("loginname") String loginname, @Param("password") String password) {

        return adminMapper.findByLoginnameAndPassword(loginname, password);
    }
}
