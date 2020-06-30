package cn.ideal.message.web.servlet;

import cn.ideal.message.domain.PageBean;
import cn.ideal.message.domain.User;
import cn.ideal.message.service.RouteService;
import cn.ideal.message.service.impl.RouteServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {

    /**
     * 分页查询方法
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void routeQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String currentPageStr = request.getParameter("currentPage"); //当前页码
        String pageSizeStr = request.getParameter("pageSize"); // 每页显示的条数

        System.out.println("分页进来");
        System.out.println(pageSizeStr);

        //当前页码，如果不传递，默认为第1页
        int currentPage = 0;
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }

        //每页显示条数，如果不传递，默认显示8条记录
        int pageSize = 0;
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 8;
        }

        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();

        //调用service查询PageBean对象
        RouteService service = new RouteServiceImpl();
        PageBean<User> userPageBean = service.pageQuery(currentPage, pageSize, condition);

        //将PageBean对象序列化为json，返回
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), userPageBean);

    }
}
