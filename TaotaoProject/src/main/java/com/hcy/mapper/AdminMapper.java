package com.hcy.mapper;

import com.hcy.bean.Admin;
import com.hcy.bean.AdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    int countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    // 自定义的sql
    // 查找登录名和密码
    List<Admin> findByLoginnameAndPassword(@Param("loginname") String loginname,
                                         @Param("password") String password);


}