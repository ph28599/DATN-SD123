package controller;

import dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import service.UserService;

@Controller
class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("user") UserDTO userDto, BindingResult result) {
        try {
            userService.registerNewUser(userDto);
        } catch (Exception e) {
            result.rejectValue("username", null, e.getMessage());
            return "register";
        }

        return "redirect:/register?success";
    }
}
