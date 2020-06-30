package cn.ideal.message.web.servlet;

import cn.ideal.message.domain.Admin;
import cn.ideal.message.domain.ResultInfo;
import cn.ideal.message.service.AdminService;
import cn.ideal.message.service.impl.AdminServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/admin/*")
public class AdminServlet extends BaseServlet {
    private AdminService service = new AdminServiceImpl();

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //验证码校验
        String verifycode = request.getParameter("verifycode");

        //从Session中获取验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");

        session.removeAttribute("CHECKCODE_SERVER"); //保证验证码只能使用一次
        //校验逻辑代码
        if (checkcode_server == null || !checkcode_server.equalsIgnoreCase(verifycode)) {
            ResultInfo info = new ResultInfo();
            //失败
            info.setFlag(false);
            info.setErrorMsg("验证码错误");

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }

        //获取用户名和密码
        Map<String, String[]> map = request.getParameterMap();
        //封装用户信息
        Admin admin = new Admin();
        try {
            BeanUtils.populate(admin, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        Admin a = service.login(admin);

//        System.out.println(a.getUsername() + a.getPassword());

        ResultInfo info = new ResultInfo();

        //判断用户对象是否为null
        if (a == null) {
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        } else {
            session.setAttribute("admin",a);
            info.setFlag(true);
        }


        //响应数据
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), info);



    }
}
