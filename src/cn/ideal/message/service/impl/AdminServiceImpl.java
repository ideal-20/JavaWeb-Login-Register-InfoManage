package cn.ideal.message.service.impl;

import cn.ideal.message.dao.AdminDao;
import cn.ideal.message.dao.impl.AdminDaoImpl;
import cn.ideal.message.domain.Admin;
import cn.ideal.message.service.AdminService;

public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao = new AdminDaoImpl();

    /**
     * 管理员登录
     * @param admin
     * @return
     */
    @Override
    public Admin login(Admin admin) {
        return adminDao.findByUsernameAndPassword(admin.getUsername(),admin.getPassword());
    }
}
