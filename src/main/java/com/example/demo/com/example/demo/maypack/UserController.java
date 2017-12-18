package com.example.demo.com.example.demo.maypack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/adduser")
    public String addnewuser(@RequestParam(value = "name", required = false, defaultValue = "") String name, Model model) {
        return "UserDetails";
    }

    @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("user") User user,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        } else {
            userService.addUser(user);
        }

        return "UserDetails";
    }

    @RequestMapping("/allusers")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("users", userService.listUsers());

        return "UserDisplay";
    }

    @RequestMapping("/removeuser")
    public String removeuser(@RequestParam(value = "name", required = false, defaultValue = "") String name, Model model) {
        return "DeleteUser";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public String deleteUser(@RequestParam(value = "id", required = false, defaultValue = "") String id, ModelMap model) {
        userService.deleteUser(id);
        return "DeleteUser";
    }

    @RequestMapping("/updateuser")
    public String updateuser(@RequestParam(value = "id", required = false, defaultValue = "") String id, Model model) {
        User currentUser = userService.findById(id);
        model.addAttribute("currentuser",currentUser);
        return "UpdateUser";
    }

    @RequestMapping(value = "/modifyuser", method = RequestMethod.POST)
    public String submituser(@Valid @ModelAttribute("user") User user,
                             BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        } else {
            userService.updateUser(user);
        }
        return "UserDetails";
    }
}