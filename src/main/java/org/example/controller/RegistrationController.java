package org.example.controller;


import jakarta.validation.Valid;
import org.example.dao.UserDAO;
import org.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class RegistrationController {
    private final UserDAO userDAO;

    @Autowired
    public RegistrationController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @GetMapping("/registration")
    public String newPerson(Model model){
        model.addAttribute("user", new User());
        return "user/registration";
    }
    @PostMapping()
    public String create(@ModelAttribute("user")  @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return  "user/registration";
        userDAO.save(user);
        return "redirect:/user";
    }

}
