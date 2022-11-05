package com.example.springbootapp.controller;

import com.example.springbootapp.model.User;
import com.example.springbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String getUsers(ModelMap model) {
        model.addAttribute("user", userService.getAllUsers());
        return "index";
    }

    @RequestMapping("/new")
    public String newUserPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "new_user";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editUserPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit");
        User user = userService.findById((long) id);
        mav.addObject("user", user);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String saveChangeUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);

        return "redirect:/";
    }
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        userService.removeUser(id);
        return "redirect:/";
    }
}
