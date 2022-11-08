package com.example.springbootapp.controller;

import com.example.springbootapp.model.User;
import com.example.springbootapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getUsers(ModelMap model) {
        model.addAttribute("user", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/new")
    public String newUserPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "new_user";
    }
    @PostMapping(value = "/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editUserPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit");
        User user = userService.findById((long) id);
        mav.addObject("user", user);

        return mav;
    }

    @PostMapping(value = "/update")
    public String saveChangeUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);

        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
