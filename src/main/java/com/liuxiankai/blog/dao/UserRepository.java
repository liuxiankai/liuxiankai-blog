package com.liuxiankai.blog.dao;

import com.liuxiankai.blog.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liuxiankai
 */
public interface UserRepository extends JpaRepository<User,Long> {
    /**
     * 查询数据库中符合用户名密码的数据
     * @param userName
     * @param password
     * @return
     */
    User findByUserNameAndPassword(String userName,String password);
}
