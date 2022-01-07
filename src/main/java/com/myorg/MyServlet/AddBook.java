package com.myorg.MyServlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.myorg.DAO.bookDao;
import com.myorg.Model.Book;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class AddBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String jsonStr = req.getParameter("Book");
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        Book book = gson.fromJson(jsonStr, Book.class);
        bookDao.insert(book);
        PrintWriter out = resp.getWriter();
        out.println("Success");
    }
}
