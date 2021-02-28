package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.RegisterService;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * @Author : wang feng
 * @create 2021/2/28 11:28
 */
@Path("/register")
public class RegisterSuccessdController implements PageController {

    private UserService registerService = new RegisterService();

    //@GET
    @POST
    @Path("/registerSuccessd")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setPhoneNumber(request.getParameter("phoneNumber"));
        registerService.register(user);
        return "login-form.jsp";
    }
}
