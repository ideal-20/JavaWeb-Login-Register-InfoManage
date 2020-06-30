package cn.ideal.message.domain;

/**
 * @ClassName: DepartmentService
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/6/27 21:14
 * @Version: 1.0
 */
public class Department {
    private int did;
    private String department;

    public Department() {
    }

    public Department(int did, String department) {
        this.did = did;
        this.department = department;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Department{" +
                "did=" + did +
                ", department='" + department + '\'' +
                '}';
    }
}
