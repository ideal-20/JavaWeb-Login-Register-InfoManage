package cn.ideal.message.service.impl;

import cn.ideal.message.dao.UserDao;
import cn.ideal.message.dao.impl.UserDaoImpl;
import cn.ideal.message.domain.User;
import cn.ideal.message.service.UserService;
import cn.ideal.message.util.MailUtils;
import cn.ideal.message.util.UuidUtil;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean register(User user) {
        //根据用户名查询用户对象
        User u = userDao.findByUsername(user.getUsername());
        //判断u是否为null
        if (u != null) {
            //用户名存在，注册失败
            return false;
        }

        //设置激活码，唯一字符串
        user.setCode(UuidUtil.getUuid());
        //设置激活状态
        user.setStatus("N");
        //保存用户信息
        userDao.save(user);

        //激活邮件发送，邮件正文？
        String content = "<a href='http://localhost:8080/user/active?code=" + user.getCode() + "'>点击激活您的账号</a>";
        MailUtils.sendMail(user.getEmail(), content, "激活邮件");

        return true;
    }

    /**
     * 激活用户
     *
     * @param code
     * @return
     */
    @Override
    public boolean active(String code) {
        //1.根据激活码查询用户对象
        User user = userDao.findByCode(code);
        if (user != null) {
            //2.调用dao的修改激活状态的方法
            userDao.updateStatus(user);
            return true;
        } else {
            return false;
        }

    }


    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    /**
     * 删除用户方法
     *
     * @param uid
     */
    @Override
    public void deleteUser(int uid) {
        userDao.deleteById(uid);
    }

    /**
     * 删除选中用户方法
     * @param uids
     */
    @Override
    public void deleteSelectedUser(String[] uids) {
        for (String id : uids) {
            userDao.deleteById(Integer.parseInt(id));
        }
    }

    /**
     * 根据id查询用户
     *
     * @param uid
     */
    @Override
    public User findUserById(int uid) {
        return userDao.findById(uid);
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @Override
    public boolean updateUser(User user) {
        userDao.update(user);
        return true;
    }
}

