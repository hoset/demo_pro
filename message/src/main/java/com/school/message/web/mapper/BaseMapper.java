package com.school.message.web.mapper;

import java.util.List;

public interface BaseMapper<T> {
    int insert(T t);

    int update(T t);

    int delete(long id);

    List<T> query();
}
