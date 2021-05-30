package pl.project.user;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class UserController {

    private UserService userService;
    private User user;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user-update")
    public String update(ModelMap modelMap, @Validated User user, BindingResult bindingResult) {
        modelMap.addAttribute("user", user);
        if (bindingResult.hasErrors()) {
            return "user-update";
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
