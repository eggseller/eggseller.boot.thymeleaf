package com.spring.thymeleaf.repository;

import java.util.Map;

import com.spring.thymeleaf.domain.User;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    @Select("SELECT id, name, age ,address FROM users WHERE id=#{id}")
    public User getUser(@Param(value = "id") String id) throws Exception;

    public Map<String, Object> getUserMap(String id);

    public Map<String, Object> getBoardMap(String id);
}
