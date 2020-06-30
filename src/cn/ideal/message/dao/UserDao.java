package cn.ideal.message.dao;

import cn.ideal.message.domain.User;

import java.util.List;

public interface UserDao {

    /**
     *  根据用户名查询用户信息
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 用户保存
     * @param user
     */
    void save(User user);

    /**
     * 通过激活码寻找用户
     * @param code
     * @return
     */
    User findByCode(String code);

    /**
     * 修改激活状态
     * @param user
     */
    void updateStatus(User user);

    /**
     * 根据用户名和密码查询的方法
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(String username, String password);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findAll();

    /**
     * 删除用户
     * @param o
     */
    void deleteById(int uid);

    /**
     * 根据id查询
     * @param uid
     * @return
     */
    User findById(int uid);

    /**
     * 修改用户信息
     * @param user
     */
    void update(User user);
}
