package ru.job4j.dream.servlet;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.job4j.dream.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        JSONObject cities = new JSONObject();
        JSONArray jsArr = new JSONArray(PsqlStore.instOf().findAllCities());
        cities.put("cities", jsArr);
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(cities.toString());
    }
}
