package com.hcy.controller;

import com.github.pagehelper.PageInfo;
import com.hcy.bean.BaseEasyBean;
import com.hcy.bean.TbItem;
import com.hcy.service.TbItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 好好学习 不做咸鱼
 * Created by Hcy on 18/8/8.
 */
@Controller
@RequestMapping("item")
public class ItemController {

    @Resource
    private TbItemService tbItemServiceImpl;

    @RequestMapping(value = "showAll.do",method = RequestMethod.GET)
    @ResponseBody
    public BaseEasyBean findAll(String page, String rows){
        System.out.println(page+"11111"+rows);
        BaseEasyBean baseEasyBean = new BaseEasyBean();
        List<TbItem> tList = tbItemServiceImpl.showAll(page,rows);
        System.out.println(tList);
        int total = tbItemServiceImpl.countItem();
        System.out.println(total+"total");
        baseEasyBean.setRows(tList);
        baseEasyBean.setTotal(total);
        System.out.println(baseEasyBean);
        return baseEasyBean;
    }


}

