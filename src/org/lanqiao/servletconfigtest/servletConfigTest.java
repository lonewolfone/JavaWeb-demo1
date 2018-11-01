package org.lanqiao.servletconfigtest;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

//@WebServlet( "/servletConfigTest")
//使用注解的方式
public class servletConfigTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* ServletConfig servletConfig = this.getServletConfig();
        //通过参数名称获取参数值
        String userVal = servletConfig.getInitParameter("username");
        String passwordVal = servletConfig.getInitParameter("password");
        System.out.println("userVal=" + userVal);
        System.out.println("passwordVal=" + passwordVal);
        System.out.println(".............................................");
        //................................................................
        //获取参数名
        Enumeration<String> parameNames = servletConfig.getInitParameterNames();
        while (parameNames.hasMoreElements()){//是否有下一个元素
            String names = parameNames.nextElement();
            String namesVal = servletConfig.getInitParameter(names);
            System.out.println("names = " + names + "------" + "namesVal = " + namesVal);
        }*/
        //Color.RED;
        //后去ServletContext对象




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
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("<h1>当前web应用的访问次数为：" + count +"</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
