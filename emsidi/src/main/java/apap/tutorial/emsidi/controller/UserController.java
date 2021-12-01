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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    String hurufBesar = ".*[A-Z].*";
    String hurufKecil = ".*[a-z].*";
    String angka = ".*[0-9].*";
    String special = ".*[^A-Za-z0-9].*";

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
        return "redirect:/error";
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

    @GetMapping(value = "/update-pass")
    private String updateUserPassword() {
        return "form-update-user-pass";
    }

    @PostMapping("/update-pass")
    @PreAuthorize("isAuthenticated()")
    public String changePasswordSubmit(Authentication auth, @RequestParam("passwordLama") String passwordLama,
            @RequestParam("passwordBaru") String passwordBaru,
            @RequestParam("konfirmasiPassword") String konfirmasiPassword, RedirectAttributes red) {
        UserModel user = userService.getUserByUsername(auth.getName());
        if (!userService.validasiPassword(user, passwordLama)) {
            red.addFlashAttribute("pesanError", "Password Lama Salah, Harap Memasukkan Password yang Benar");
            return "redirect:/user/update-pass";
        }

        if (passwordBaru.length() < 8) {
            red.addFlashAttribute("pesanError", "Password Harus Minimal 8 Karakter");
            return "redirect:/user/ubahPassword";
        }

        if (!passwordBaru.matches(hurufBesar) || !passwordBaru.matches(hurufKecil) || !passwordBaru.matches(angka)
                || !passwordBaru.matches(special)) {
            red.addFlashAttribute("pesanError", "Password harus mengandung angka, huruf, dan simbol");
            return "redirect:/user/update-pass";
        }

        if (!passwordBaru.equals(konfirmasiPassword)) {
            red.addFlashAttribute("pesanError", "Password Baru Tidak Sama dengan Konfirmasi Password");
            return "redirect:/user/update-pass";
        }

        userService.updatePassword(user, konfirmasiPassword);
        red.addFlashAttribute("pesan", "Password Berhasil Diubah");
        return "redirect:/";
    }

}