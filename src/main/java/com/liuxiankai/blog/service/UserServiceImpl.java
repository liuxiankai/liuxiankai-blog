package com.liuxiankai.blog.service;

import com.liuxiankai.blog.dao.UserRepository;
import com.liuxiankai.blog.po.User;
import com.liuxiankai.blog.utils.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liuxiankai
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User checkUser(String userName, String password) {
        User user = userRepository.findByUserNameAndPassword(userName, MD5Utils.MD5Encode(password,"utf-8"));

        return user;
    }

    @Override
    public User checkConsumerUser(String userName, String password) {
        User user = userRepository.findByUserNameAndPasswordAndType(userName, MD5Utils.MD5Encode(password,"utf-8"),3);
        return user;
    }

    @Override
    public User registerCheck(String userName) {
        User user = userRepository.findByUserNameAndType(userName,3);
        return user;
    }
}
