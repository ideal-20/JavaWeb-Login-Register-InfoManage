package cn.ideal.message.service;

import cn.ideal.message.domain.User;

import java.util.List;

public interface UserService {

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    boolean register(User user);

    /**
     * 用户账号激活验证
     *
     * @param code
     * @return
     */
    boolean active(String code);

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> findAll();

    /**
     * 删除用户
     *
     * @param id
     */
    void deleteUser(int id);

    /**
     * 删除选中
     * @param uids
     */
    void deleteSelectedUser(String[] uids);

    /**
     * 根据id查询
     * @param uid
     */
    User findUserById(int uid);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    boolean updateUser(User user);



}
