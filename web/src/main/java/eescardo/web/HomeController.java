/* Copyright (C) 2011 Eduardo Escardo-Raffo. All rights reserved. */
package eescardo.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import eescardo.user.UserManager;
import eescardo.user.dao.User;

/**
 * @author Eddy Escardo
 */
@Controller("homeController")
public class HomeController extends AbstractController {

    private final UserManager userManager;

    @Autowired
    public HomeController(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ModelAndView mav = new ModelAndView("home.ftl");
        Map<String, Object> model = mav.getModel();

        List<User> users = userManager.getAllUsers();

        model.put("users", users);

        return mav;
    }

}
