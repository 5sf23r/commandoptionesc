package cn.tedu.demo;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/context02")
public class ServletContext02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取web资源：指的是web应用中所有的文件都是web资源
        //方式一：设置一个相对路径
        File file = new File("c3p0-config.xml");
        //对于web应用来说, web应用是在容器中运行的, 这时候就会到tomcat/bin目录下去找
        System.out.println("该文件绝对路径："+file.getAbsolutePath());
        //方式二：file设置一个绝对路径
        File file1 = new File("D:\\c3p0-config.xml");
        System.out.println("磁盘目录如下："+file1.getAbsolutePath());
        //方式三：类加载加载web资源
        //获取类加载器
        ClassLoader classLoader = ServletContext02.class.getClassLoader();
        //通过类加载器 获得 c3p0-config.xml这个配置文件
        //如果当前的应用程序是一个web应用，那么会去WEB-INF/classes中去找
        String path = classLoader.getResource("c3p0-config.xml").getPath();
        System.out.println("web应用中的资源路径："+path);
        //方式四：servletContext对象获取资源路径
        ServletContext servletContext = this.getServletContext();
        //getRealPath 需要写入的路径是 从/WEN-INF开始写
        String realPath = servletContext.getRealPath("/WEB-INF/classes/c3p0-config.xml");
        System.out.println(realPath);
        //方式五： 获取web应用的路径 ： Application Context ： url资源路径
        String contextPath = servletContext.getContextPath();
        String contextPath1 = request.getContextPath();
        //如果资源路径配置了缺省的路径 / ，那么 输出的内容是空
        System.out.println(contextPath);
        System.out.println(contextPath1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}