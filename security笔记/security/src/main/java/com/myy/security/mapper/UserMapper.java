package com.myy.security.mapper;

import com.myy.security.entity.User;

public interface UserMapper {

    User selectByUsername(String username);
}
