package org.lanqiao.servletconfigtest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet( "/demo8")
public class servletRequestTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的方式
       String method =  request.getMethod();
        System.out.println("methon = " + method);
       Enumeration<String> names =  request.getHeaderNames();
       String namesVal = request.getHeader("names");
       while (names.hasMoreElements()){
           String name = names.nextElement();
           System.out.println("name = " + name +"------"+"namesVal = " + namesVal);
       }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
