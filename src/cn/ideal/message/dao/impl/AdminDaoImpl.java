package cn.ideal.message.dao.impl;

import cn.ideal.message.dao.AdminDao;
import cn.ideal.message.domain.Admin;
import cn.ideal.message.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AdminDaoImpl implements AdminDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据用户名和密码查询的方法
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public Admin findByUsernameAndPassword(String username, String password) {
        try {
            //1.定义sql
            String sql = "SELECT * FROM admin_info WHERE username = ? AND password = ?";
            //2.执行sql
            Admin admin = template.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class), username, password);
            return admin;
        } catch (Exception e) {
            return null;
        }
    }
}
