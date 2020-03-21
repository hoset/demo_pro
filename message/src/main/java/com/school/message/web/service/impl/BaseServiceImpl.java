package com.school.message.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.school.message.web.mapper.BaseMapper;
import com.school.message.web.param.BaseParam;
import com.school.message.web.pojo.Result;
import com.school.message.web.service.IBaseService;

import java.util.List;

public abstract class BaseServiceImpl<T> implements IBaseService<T> {

    private BaseMapper<T> baseMapper;

    public BaseServiceImpl(BaseMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public Result insert(T t) {

        int code = baseMapper.insert(t);
        Result result;
        if (code == 1) {
            result = new Result();
        } else {
            result = new Result(500, "失败");
        }

        return result;
    }

    @Override
    public Result update(T t) {
        int code = baseMapper.update(t);
        Result result;
        if (code == 1) {
            result = new Result();
        } else {
            result = new Result(500, "失败");
        }

        return result;
    }

    @Override
    public Result delete(long id) {
        int code = baseMapper.delete(id);
        Result result;
        if (code == 1) {
            result = new Result();
        } else {
            result = new Result(500, "失败");
        }

        return result;
    }

    @Override
    public PageInfo<T> query(BaseParam param) {

        PageHelper.startPage(param.getCurrent(), param.getSize());

        List<T> data = baseMapper.query();
        PageInfo<T> result = new PageInfo<>(data);


        return result;
    }
}
