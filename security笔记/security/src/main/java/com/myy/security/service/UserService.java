package com.myy.security.service;

import com.myy.security.entity.Users;
import com.myy.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userMapper.selectByUsername(username);
        if (users == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        return new User(username,
                users.getPassword(),
                AuthorityUtils.createAuthorityList("admin"));
    }
}
