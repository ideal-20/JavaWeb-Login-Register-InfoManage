package cn.ideal.message.service.impl;

import cn.ideal.message.dao.DepartmentDao;
import cn.ideal.message.dao.impl.DepartmentDaoImpl;
import cn.ideal.message.domain.Department;
import cn.ideal.message.service.DepartmentService;

import java.util.List;

/**
 * @ClassName: DepartmentServiceImpl
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/6/27 21:15
 * @Version: 1.0
 */
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao deaprtmentDao = new DepartmentDaoImpl();

    @Override
    public List<Department> findAll() {
        List<Department> departments = deaprtmentDao.findAll();
        return departments;
    }

    @Override
    public void deleteDepartmentById(int did) {
        deaprtmentDao.deleteDepartmentById(did);
    }

    @Override
    public void addDepartment(String department) {
        deaprtmentDao.addDeaprtment(department);
    }
}
