package com.dianshang.beetle.controller;

import org.beetl.ext.servlet.ServletGroupTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prettyRain
 */
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
           req.setAttribute("title","这是测试title");
           req.setAttribute("name","这是测试名称mainServlet");
           String[] arrstr = {"1","2","3","4"};
           req.setAttribute("arrstr",arrstr);

        ServletGroupTemplate.instance().render("/view/beetlPage.html",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
