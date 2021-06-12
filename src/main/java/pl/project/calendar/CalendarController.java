package pl.project.calendar;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.project.car.Car;
import pl.project.car.CarRepository;
import pl.project.user.UserService;

import java.util.List;

@Controller
public class CalendarController {
    private CalendarRepository calendarRepository;
    private CarRepository carRepository;
    private UserService userService;


    public CalendarController(CalendarRepository calendarRepository, CarRepository carRepository, UserService userService) {
        this.calendarRepository = calendarRepository;
        this.carRepository = carRepository;
        this.userService = userService;

    }

    @GetMapping("/appointment")
    public String getAppointmentForm(ModelMap modelMap, Car car) {
        List<Car> carList = carRepository.findAllCarsByUserid(userService.getCustomUserId());
        modelMap.addAttribute("calendar", new Calendar());
        modelMap.addAttribute("cars", carList);
        modelMap.addAttribute("carId", car.getCarId());

        List<Calendar> calendarList = calendarRepository.findAll();
        modelMap.addAttribute("calendarList", calendarList);
        return "appointment";
    }

    @PostMapping("/appointment")
    public String addAppointment(ModelMap modelMap, Calendar calendar, BindingResult bindingResult) {
        List<Car> carList = carRepository.findAll();
        modelMap.addAttribute("calendar", calendar);
        modelMap.addAttribute("cars", carList);

        if (bindingResult.hasErrors()) {
            return "appointment";
        }
        try {
            calendar.setUser(userService.getCustomUser());
            calendarRepository.save(calendar);
        } catch (DataIntegrityViolationException e) {
            modelMap.addAttribute("registrationNumberAlreadyExists", true);
            return "appointment";
        }
        return "appointment-confirmed";
    }

    @GetMapping("/appointment-confirmed")
    public String getConfirmation() {
        return "appointment-confirmed";
    }

    @DeleteMapping("/appointment")
    public void deleteAppointment(Calendar calendar) {

    }
}
