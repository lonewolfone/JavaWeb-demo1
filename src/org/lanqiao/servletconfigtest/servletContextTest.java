package org.lanqiao.servletconfigtest;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

//@WebServlet(name = "servletContextTest")
public class servletContextTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* //获取ServletConfig对象
        ServletConfig servletConfig = this.getServletConfig();
        //获取ServletContext对象
        ServletContext servletContext = servletConfig.getServletContext();
        //获取Web应用的值
        String applicationVal = servletContext.getInitParameter("applicationname");
        System.out.println( "applicationname = " +applicationVal);
        //。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
        //通过该方法返回相对路径的资源的真实物理路径
        String realPath = servletContext.getRealPath("红楼梦.txt");
        System.out.println(realPath);
        //将资源文件作为流对象返回
        InputStream inputStream = servletContext.getResourceAsStream("红楼梦.txt");
        System.out.println(inputStream);*/

        //HttpServlet含一个方法，可直接获取ServletContext对象
        ServletContext servletContext = this.getServletContext();
        Integer count = (Integer)servletContext.getAttribute("count");
        if (count == null ){
            count = 0;
            servletContext.setAttribute("count",count);
        }else {
            count++;
            //将count保存在ServletContext中
            servletContext.setAttribute("count",count);
        }
        count = (Integer) servletContext.getAttribute("count");
        //设置响应的内容类型及其字符编码
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("<h1>当前web应用的访问次数为：" + count +"</h1>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
