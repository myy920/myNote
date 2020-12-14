package com.myy.security.mapper;

import com.myy.security.entity.Users;

public interface UserMapper {

    Users selectByUsername(String username);
}
