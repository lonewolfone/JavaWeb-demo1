package org.lanqiao.servletconfigtest;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet( "/demo9")
public class servletRequestTest1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求的字符编码
        request.setCharacterEncoding("utf-8");
        /*//获取ServletContext对象??????????????????????????????????:报错，报错
        ServletContext servletContext = this.getServletContext();
        String usernameVal0 = servletContext.getAttribute("username").toString();
        String passwordVal1 = servletContext.getAttribute("password").toString();
        System.out.println(" username:" + usernameVal0);
        System.out.println(" password:" + passwordVal1);*/
        //
        String usernameVal1 = request.getParameter("username");
        String passwordVal1 = request.getParameter("password");
        System.out.println(" username:" + usernameVal1);
        System.out.println(" password:" + passwordVal1);
        //请求内容长度
        int length = request.getContentLength();
        System.out.println("length = " + length);
        //请求方式
        String type = request.getContentType();
        System.out.println("type = " + type);
        //本地地址(ipv6的)
        String addr = request.getLocalAddr();
        System.out.println("addr = " + addr);
        //获取请求编码
        String encoding = request.getCharacterEncoding();
        System.out.println("encoding = " + encoding);
        //获取上下文路径
        String path = request.getContextPath();
        System.out.println("path = " + path);
        //
        String uri = request.getRequestURI();
        System.out.println("uri = " + uri);
        String url = request.getRequestURL().toString();
        System.out.println(" url = " +url);
        //获取用户的IP地址，记录日志
       String remoteAdd = request.getRemoteAddr();
       System.out.println("remoteAdd = " + remoteAdd);
      //..................................................................
      //获取页面的请求数据
      //设置响应的内容类型及字符编码
       response.setContentType("text/html;charset=utf-8");
      //将获取到的数据响应到前端页面
      PrintWriter out = response.getWriter();
      //根据属性名获取属性值
      //用户名及密码
      String usernameVal = request.getParameter("username");
      String passwordVal = request.getParameter("password");
      out.write("username : " + usernameVal +"<br><br>");
      out.write("password : " + passwordVal +"<br><br>");
      //单选
       String sex = request.getParameter("sex");
       out.write("sex : " + sex +"<br><br>");
      //多选：获取到的是一个数组
       String[] loves =  request.getParameterValues("love");
       for (String str:loves){
          out.write("love : " + str +"<br><br>");
       }
      //下拉列表
       String city = request.getParameter("city");
       out.write("city : " + city +"<br><br>");
    }
}
