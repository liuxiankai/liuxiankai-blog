package com.liuxiankai.blog.service;

import com.liuxiankai.blog.po.User;

/**
 * @author liuxiankai
 */
public interface UserService {

    /**
     * 检查用户名密码
     * @param userName
     * @param password
     * @return
     */
    User checkUser(String userName, String password);

    User checkConsumerUser(String userName, String password);

    User registerCheck(String userName);
}
