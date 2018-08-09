package com.hcy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hcy.bean.TbItem;
import com.hcy.mapper.TbItemMapper;
import com.hcy.service.TbItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 好好学习 不做咸鱼
 * Created by Hcy on 18/8/8.
 */
@Service
public class TbItemServiceImpl implements TbItemService{

    @Resource
    private TbItemMapper tbItemMapper;

    @Override
    public int countItem() {
        return tbItemMapper.showAll().size();
    }

    @Override
    public List<TbItem> showAll(String page, String rows) {
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(rows));
        List<TbItem> list = tbItemMapper.showAll();

        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        List<TbItem> resultList = pageInfo.getList();
        return resultList;
    }
}
