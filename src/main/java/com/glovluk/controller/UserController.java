package com.glovluk.controller;

import com.glovluk.model.User;
import com.glovluk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")  // GET-запрос для отображения всех пользователей
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.findAll();
        model.addAttribute("allUsers", allUsers);

        return "all-users";
    }

    @GetMapping("/addNewUser")  // GET-запрос для отображения формы добавления нового пользователя
    public String addNewUser(Model model) {
        User employee = new User();
        model.addAttribute("user", employee);

        return "users-info";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);

        return "redirect:/";
    }

    @GetMapping("/updateinfo")
    public String updateUser(@RequestParam("userId") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));

        return "users-info";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") Long id) {
        userService.delete(id);

        return "redirect:/";
    }
}

