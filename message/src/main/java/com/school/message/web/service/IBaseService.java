package com.school.message.web.service;

import com.github.pagehelper.PageInfo;
import com.school.message.web.param.BaseParam;
import com.school.message.web.pojo.Result;

public interface IBaseService<T> {


    Result insert(T t);
    Result update(T t);
    Result delete(long id);
    PageInfo<T> query(BaseParam param);


}
