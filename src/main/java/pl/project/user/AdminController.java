package pl.project.user;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.project.calendar.Calendar;
import pl.project.calendar.CalendarRepository;

import java.util.List;

@Controller
public class AdminController {
    private AdminService adminService;
    private UserRepository userRepository;
    private CalendarRepository calendarRepository;

    public AdminController(AdminService adminService, UserRepository userRepository, CalendarRepository calendarRepository) {
        this.adminService = adminService;
        this.userRepository = userRepository;
        this.calendarRepository = calendarRepository;
    }
    @GetMapping("/appointments")
    public String getListOfAAppointments(ModelMap modelMap) {
        List<Calendar> appointments = calendarRepository.findAll();
        modelMap.addAttribute("appointments", appointments);
        return "appointments";
    }

    @GetMapping("/users")
    public String getListOfUsers(ModelMap modelMap) {
        List<User> users = userRepository.findAll();
        modelMap.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "/delete-user",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String deleteUserByEmail(@RequestBody MultiValueMap<String, String> formData) {
        adminService.delete(formData.getFirst("email"));
        return "redirect:/admin";
    }
}
