package cn.ideal.message.dao;

import cn.ideal.message.domain.Admin;

public interface AdminDao {
    /**
     * 根据用户名和密码查询的方法
     * @param username
     * @param password
     * @return
     */
    Admin findByUsernameAndPassword(String username, String password);
}
