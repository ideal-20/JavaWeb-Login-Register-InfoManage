package cn.ideal.message.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName: AdminFilter
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/6/30 10:45
 * @Version: 1.0
 */
@WebFilter("/admin/*")
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        //强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        //获取资源请求路径
        String uri = request.getRequestURI();

        System.out.println("管理员filter：" + uri);

        if (uri.contains("/admin/login")) {
            chain.doFilter(req, resp);

        } else {
            Object admin = request.getSession().getAttribute("admin");
            if (admin != null) {
                chain.doFilter(req, resp);
            } else {
                request.getRequestDispatcher("/admin_login.html").forward(request, resp);
            }
        }


    }

    @Override
    public void destroy() {

    }
}
