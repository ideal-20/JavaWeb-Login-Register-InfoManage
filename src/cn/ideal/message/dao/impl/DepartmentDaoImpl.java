package cn.ideal.message.dao.impl;

import cn.ideal.message.dao.DepartmentDao;
import cn.ideal.message.domain.Department;
import cn.ideal.message.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @ClassName: DepartmentDaoImpl
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/6/27 21:16
 * @Version: 1.0
 */
public class DepartmentDaoImpl implements DepartmentDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Department> findAll() {
        String sql = "SELECT * FROM department_info";
        List<Department> departments = template.query(sql, new BeanPropertyRowMapper<Department>(Department.class));
        return departments;
    }

    @Override
    public void deleteDepartmentById(int did) {
        String sql = "DELETE FROM department_info WHERE did = ?";
        template.update(sql, did);
    }


    @Override
    public void addDeaprtment(String department) {
        String sql = "INSERT INTO department_info() VALUES (NULL, ?)";
        template.update(sql, department);
    }
}
