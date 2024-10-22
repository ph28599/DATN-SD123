package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ADMIN")) {
            return "redirect:/admin/home";
        } else if (request.isUserInRole("CUSTOMER")) {
            return "redirect:/customer/home";
        } else if (request.isUserInRole("STAFF")) {
            return "redirect:/staff/home";
        }
        return "redirect:/";
    }
}

