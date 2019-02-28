package com.dianshang.beetle.controller;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by prettyRain
 */
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Classpath资源模板加载器
        //还有种常情况下，模板资源是打包到jar文件或者同Class放在一起，因此，可以使用ClasspathResourceLoader来加载模板实例
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("com/dianshang");
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template template = gt.getTemplate("/hello.txt");
        template.binding("titlea","这是测试标题");
        template.binding("name","这是测试名称adminServlet");
        String render = template.render();

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println(render);
    }

}
