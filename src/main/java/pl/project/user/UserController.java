package pl.project.user;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.project.calendar.Calendar;
import pl.project.calendar.CalendarService;
import pl.project.car.Car;
import pl.project.car.CarService;

@Controller
public class UserController {



}
//    private CalendarService calendarService;
//
//    @GetMapping
//    public String getAppointmentForm(ModelMap modelMap) {
//        modelMap.addAttribute("calendar", new Calendar());
//        return "calendar";
//    }
//

//    @PostMapping
//    public String makeAnAppointment(ModelMap modelMap, @Validated Calendar calendar, @Validated User user, BindingResult bindingResult) {
//        modelMap.addAttribute("calendar", calendar);
//        if (bindingResult.hasErrors()) {
//            return "calendar";
//        }
//        try {
//            calendarService.makeAnAppointment(calendar);
//        } catch (DataIntegrityViolationException e) {
//            modelMap.addAttribute("appointmentAlreadyExists", true);
//            return "calendar";
//        }
//        return "calendar-result";
//    }
//
//    @PostMapping("/delete-appointment")
//    public void deleteAppointment(Calendar calendar) {
//
//    }

