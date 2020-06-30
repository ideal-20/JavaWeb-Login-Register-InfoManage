package cn.ideal.message.service;

import cn.ideal.message.domain.Department;

import java.util.List;

/**
 * @ClassName: DepartmentService
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/6/27 21:12
 * @Version: 1.0
 */
public interface DepartmentService {
    /**
     * 查询所有部门
     * @return
     */
    List<Department> findAll();

    void deleteDepartmentById (int did);

    void addDepartment(String department);
}
