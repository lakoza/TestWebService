package com.anneke;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServletDHX extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("Cp1251");

        // Устанавливаем MIME
        response.setContentType("text/html;charset=UTF-8");

        request.getRequestDispatcher("/WEB-INF/paging.html").forward(request, response);

//        PrintWriter out = response.getWriter();
//        PageFactory factory = new PageFactory();
//        out.println(factory.getPage());
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

}
