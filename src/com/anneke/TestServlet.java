package com.anneke;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


public class TestServlet extends HttpServlet {

    public static final String head = "<html>\n" +
            "<body>\n" +
            "<table border=\"1\">\n";

    public static final String tail = "</table>\n" +
            "</body>\n" +
            "</html>";

    public static String tableColTemplate = "<cell>%s</cell>";
    public static String tableRowTemplate = "<tr>%s</tr>";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("Cp1251");

        // Устанавливаем MIME
        response.setContentType("text/xml;charset=UTF-8");

//        request.getRequestDispatcher("testXML.xml").forward(request, response);
        PrintWriter out = response.getWriter();
//
//        out.println(head);
////        out.println("<tr><td>Test</td></tr>");
        TestSQLLiteConnection dbData = new TestSQLLiteConnection();
        String data = dbData.getXML();
        out.println(data);
//
//        out.println(tail);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
