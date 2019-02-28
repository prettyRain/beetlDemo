package com.dianshang.beetle.controller;


import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.core.resource.StringTemplateResourceLoader;
import org.beetl.core.resource.WebAppResourceLoader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by prettyRain
 */
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //new 一个字符串模板资源加载器
        StringTemplateResourceLoader stringTemplateResourceLoader = new StringTemplateResourceLoader();
        /* 使用Beetl默认的配置。
         * Beetl可以使用配置文件的方式去配置，但由于此处是直接上手的例子，
         * 我们不去管配置的问题，只需要基本的默认配置就可以了。
        */
        Configuration configuration = Configuration.defaultConfiguration();
        //Beetl的核心GroupTemplate
        GroupTemplate groupTemplate = new GroupTemplate(stringTemplateResourceLoader,configuration);
        String testTemplate="<html>\n" +
                "<head>\n" +
                "\t<title>${title}</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<h1>${name}</h1>\n" +
                "</body>\n" +
                "</html>";
        Template template = groupTemplate.getTemplate(testTemplate);
        template.binding("title","这是测试标题");
        template.binding("name","这是测试名称indexServlet");
        String render = template.render();
         //也可以使用map绑定
        /*Map<String,String> map=new HashMap<String,String>()
        map.put("name", "beetl");
        map.put("title","This is a test template Email.");
        template.binding(map);*/

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println(render);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
