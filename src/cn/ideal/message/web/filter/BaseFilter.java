package cn.ideal.message.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("*.html")
public class BaseFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 强制转换
        HttpServletRequest request = (HttpServletRequest) req;

        // 获取资源请求路径
        String uri = request.getRequestURI();

        System.out.println("基本filter：" + uri);

        // 排除静态资源和主页、登录注册页面
        if (uri.contains("/index.html") || uri.contains("/user_register.html")  ||
                uri.contains("/user_login.html") || uri.contains("/admin_login.html") ||
                uri.contains("/login_success.html") || uri.contains("/register_success.html") ||
                uri.contains("/admin_list_userInfo.html") || uri.contains("/admin_update_userInfo.html") ||
                uri.contains(".css") || uri.contains(".jpg") ||
                uri.contains(".jpeg") || uri.contains(".png") ||
                uri.contains(".js") || uri.contains("/fonts/") ||
                uri.contains("/checkCode")) {
            //包含，用户就是想登录或注册，放行
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
