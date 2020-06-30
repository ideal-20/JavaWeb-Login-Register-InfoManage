package cn.ideal.message.dao;

import cn.ideal.message.domain.Department;


import java.util.List;

/**
 * @ClassName: DepartmentDao
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/6/27 21:16
 * @Version: 1.0
 */
public interface DepartmentDao {
    /**
     * 查询所有部门
     * @return
     */
    List<Department> findAll();

    void deleteDepartmentById(int did);

    void addDeaprtment(String department);
}
