package ru.job4j.crudservlet.presentation;

import ru.job4j.crudservlet.logic.ValidateService;
import ru.job4j.crudservlet.model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class UserServlet extends HttpServlet {

    private final ValidateService validateService = ValidateService.getInstance();

    private final Map<String, Function<User, Boolean>> mapActions = new HashMap<>();

    @Override
    public void init(ServletConfig config) {
        this.mapActions.put("add", validateService::add);
        this.mapActions.put("update", validateService::update);
        this.mapActions.put("delete", validateService::delete);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        List<User> userList = this.validateService.findAll();
        if (userList.size() == 0) {
            writer.println("<h4>No users in the system</h4>");
        } else {
            userList.forEach(x -> writer.println("<h4>" + x + "</h4>"));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        boolean result = this.mapActions.get(action) != null && this.mapActions.get(action).apply(this.getUser(request));
        if (!result) {
            response.getWriter().println("<h2>The operation is not performed</h2>");
        }
    }

    private User getUser(HttpServletRequest request) {
        String id = request.getParameter("id");
        String validId = id != null ? id : this.generateID();
        return new User(validId, request.getParameter("name"), request.getParameter("login"), request.getParameter("email"));
    }

    private String generateID() {
        return String.valueOf(System.currentTimeMillis() % 10000 + new Random().nextInt(10000));
    }
}
