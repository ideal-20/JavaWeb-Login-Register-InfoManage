package cn.ideal.message.web.servlet;

import cn.ideal.message.domain.ResultInfo;
import cn.ideal.message.domain.User;
import cn.ideal.message.service.UserService;
import cn.ideal.message.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/user/*") // * 代表的是后面的方法
public class UserServlet extends BaseServlet {

    //声明一个 UserService 业务对象
    private UserService service = new UserServiceImpl();

    /**
     * 注册功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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


        //获取数据
        Map<String, String[]> map = request.getParameterMap();
        //封装对象

        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //调用Service完成注册
        //UserService service = new UserServiceImpl();
        boolean flag = service.register(user);

        //实例化封装返回的提示信息类
        ResultInfo info = new ResultInfo();

        //响应结果
        if (flag) {
            info.setFlag(true);
        } else {
            info.setFlag(false);
            info.setErrorMsg("注册失败");
        }

        //将info对象序列化为json对象
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);

        //将json数据写回客户端
        //设置content-type
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    /**
     * 登录功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
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

        //获取用户和密码
        Map<String, String[]> map = request.getParameterMap();

        //封装用户信息
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //UserService service = new UserServiceImpl();
        User u = service.login(user);
        ResultInfo info = new ResultInfo();

        //判断用户对象是否为null
        if (u == null) {
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        }

        //判断用户是否激活
        if (u != null && !"Y".equals(u.getStatus())) {
            //用户未激活
            info.setFlag(false);
            info.setErrorMsg("您尚未激活，请前往邮箱查看邮件激活 ");
        }
        //判断登录成功
        if (u != null && "Y".equals(u.getStatus())) {
            session.setAttribute("user",u);
            info.setFlag(true);
        }

        //响应数据
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), info);
    }

    /**
     * 激活功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取激活码
        String code = request.getParameter("code");
        if (code != null) {
            //2.调用service完成激活
            //UserService service = new UserServiceImpl();
            boolean flag = service.active(code);

            //3.判断标记
            String msg = null;
            if (flag) {
                //激活成功
                msg = "激活成功，请<a href='../user_login.html'>登录</a>";
            } else {
                //激活失败
                msg = "激活失败，请联系管理员!";
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }
    }

    /**
     * 展示用户信息功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void userList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用Service完成查询
        UserService service = new UserServiceImpl();
        List<User> users = service.findAll();

        ResultInfo info = new ResultInfo();


        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");

        //判断查询结果是否为null
        if (users == null) {
            info.setFlag(false);
            info.setErrorMsg("数据库中还没有数据");
            mapper.writeValue(response.getOutputStream(), info);
        } else {
            info.setFlag(true);
            mapper.writeValue(response.getOutputStream(), users);
        }
    }

    /**
     * 删除用户功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uid_Str = request.getParameter("uid");

        int uid = Integer.parseInt(uid_Str);
        UserService service = new UserServiceImpl();

        service.deleteUser(uid);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        mapper.writeValue(response.getOutputStream(), info);
    }

    /**
     * 删除选中用户功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteSelectedUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uids_Str = request.getParameter("uids");
        String[] uids_Array = uids_Str.split(",");
        service.deleteSelectedUser(uids_Array);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        mapper.writeValue(response.getOutputStream(), info);
    }

    /**
     * 查询用户功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String uid_Str = request.getParameter("uid");
        int uid = Integer.parseInt(uid_Str);

        System.out.println("查询用户进来");

        UserService service = new UserServiceImpl();
        User user = service.findUserById(uid);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        mapper.writeValue(response.getOutputStream(),user);
    }

    /**
     * 修改用户信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Map<String, String[]> map = request.getParameterMap();

        User user = new User();

        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        boolean flag = service.updateUser(user);
        //实例化封装返回的提示信息类
        ResultInfo info = new ResultInfo();

        //响应结果
        if (flag) {
            info.setFlag(true);
        } else {
            info.setFlag(false);
            info.setErrorMsg("修改失败");
        }

        //将info对象序列化为json对象
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);

        //将json数据写回客户端
        //设置content-type
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);

    }
}

