package org.geektimes.projects.user.web.controller;

import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @Author : wang feng
 * @create 2021/2/28 11:28
 */
@Path("/register")
public class RegisterController implements PageController {

    @GET
    //@POST
    @Path("/registerForm") // /hello/world -> HelloWorldController
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return "register-form.jsp";
    }
}
