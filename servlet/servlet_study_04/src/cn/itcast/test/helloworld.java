package cn.itcast.test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * urlPartten
 * @WebServlet("/d4", "/dd4", "ddd4");  // 多地址匹配一个资源
 * @WebServlet("/user/demo");           // 长地址定位资源
 * @WebServlet("/user/*");              // 模糊匹配资源
 * @WebServlet("/*");                   // 所有地址都匹配资源
 * @WebServlet("*.do");                 // 后缀匹配资源
 */
public class helloworld extends HttpServlet {
    private String message;

    public void init() throws ServletException {
        // 初始化变量
        message = "Hello World";
    }

    /**
     * get访问接口
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html");

        // 获得参数
        String name = new String(request.getParameter("name").getBytes("ISO8859-1"), "UTF-8");
        Integer height = new Integer(request.getParameter("height"));

        // 实际的逻辑是这里
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1><br /><p>name: " + name + " height: " + height + "</p>");
    }

    /**
     * post请求
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void destroy() {
        // 什么也不做
    }
}
