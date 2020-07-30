package ru.job4j.dream.servlet;

import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GreetingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("text", "nice to meet you " + name);
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.println(jsonObject);
        writer.flush();
    }
}
