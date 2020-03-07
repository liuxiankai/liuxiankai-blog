package com.liuxiankai.blog.utils;

import com.liuxiankai.blog.po.User;

import javax.servlet.http.HttpSession;

/**
 * @author liuxiankai
 */
public class Utils {

    public static boolean check(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user.getType() != 1) {
            return false;
        }
        return true;
    }
}
