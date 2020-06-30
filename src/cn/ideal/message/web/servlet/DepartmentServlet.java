package cn.ideal.message.web.servlet;

import cn.ideal.message.domain.Department;
import cn.ideal.message.domain.ResultInfo;
import cn.ideal.message.service.DepartmentService;
import cn.ideal.message.service.impl.DepartmentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/department/*")
public class DepartmentServlet extends BaseServlet {

    private DepartmentService departmentService = new DepartmentServiceImpl();

    /**
     * 显示部门
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void departmentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> departments = departmentService.findAll();

        for (Department department : departments) {
            System.out.println(department);
        }

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        mapper.writeValue(response.getOutputStream(), departments);
    }

    /**
     * 删除部门
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String did_Str = request.getParameter("did");
        int did = Integer.parseInt(did_Str);
        departmentService.deleteDepartmentById(did);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        mapper.writeValue(response.getOutputStream(), info);
    }

    public void addDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String department = request.getParameter("department");

        departmentService.addDepartment(department);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        mapper.writeValue(response.getOutputStream(), info);
    }




}
