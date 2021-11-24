package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.UserModel;
import apap.tutorial.emsidi.model.RoleModel;
import apap.tutorial.emsidi.service.UserService;
import apap.tutorial.emsidi.service.RoleService;
import java.time.LocalTime;
import java.util.List;

import java.util.regex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/add")
    private String addUserFormPage(Model model) {
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping(value = "/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model) {
        user = userService.addUser(user);
        if (user != null) {
            model.addAttribute("user", user);
            return "redirect:/";
        }
        model.addAttribute("user", user);
        return "error-add-user";
    }

    @GetMapping(value = "/viewall")
    private String viewAllUser(Model model) {
        List<UserModel> listUser = userService.getListUser();
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable String username, Model model) {
        UserModel user = userService.getUserByUsername(username);
        userService.deleteUser(user);

        return "delete-user";
    }

    @GetMapping(value = "/update-pass/{username}")
    private String updateUserPassword(@PathVariable String username, Model model) {
        UserModel user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        return "form-update-user-pass";
    }

}
