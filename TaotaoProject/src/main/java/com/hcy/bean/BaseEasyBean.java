package com.hcy.bean;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * 好好学习 不做咸鱼
 * Created by Hcy on 18/8/8.
 */
public class BaseEasyBean<T>  {

    int total;
    List<T> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
