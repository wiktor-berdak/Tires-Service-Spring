package pl.project;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.project.user.User;
import pl.project.user.UserService;


@Controller
@RequestMapping("/register")
public class RegisterController {
    private UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterForm(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "register";
    }

    @PostMapping
    public String register(ModelMap modelMap, @Validated User user, BindingResult bindingResult) {
        modelMap.addAttribute("user", user);
        if (bindingResult.hasErrors()) {
            return "register";
        }
        try {
            userService.save(user);
        } catch (DataIntegrityViolationException e) {
            modelMap.addAttribute("usernameAlreadyExists", true);
            return "register";
        }
        return "register-result";
    }

}
