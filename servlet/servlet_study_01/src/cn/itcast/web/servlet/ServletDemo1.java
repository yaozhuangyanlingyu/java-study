package cn.itcast.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Servlet快速入门
 */
public class ServletDemo1 implements Servlet {
    /**
     * 初始化方法
     * 在Servlet被创建时，才会执行一次
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("servlet init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务的方法
     * 每次servlet被访问时，执行
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello servlet!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法，在servlet被杀死时执行
     * 在服务器正常关闭时执行
     */
    @Override
    public void destroy() {
        System.out.println("servlet destroy");
    }
}
