package com.hcy.service;

import com.hcy.bean.TbItem;

import java.util.List;

/**
 * 好好学习 不做咸鱼
 * Created by Hcy on 18/8/8.
 */

public interface TbItemService {

    // item 表所有的数据条数
    int countItem();

    // 查询 item表的所有数据
    List<TbItem> showAll(String page, String rows);
}
