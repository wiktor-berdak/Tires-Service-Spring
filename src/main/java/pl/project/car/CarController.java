package pl.project.car;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.project.user.UserService;

import java.util.List;

@Controller
public class CarController {
    private CarService carService;
    private CarRepository carRepository;
    private UserService userService;

    public CarController(CarService carService, CarRepository carRepository, UserService userService) {
        this.carService = carService;
        this.carRepository = carRepository;
        this.userService = userService;
    }

    @GetMapping("/car")
    public String getCarForm(ModelMap modelMap) {
        modelMap.addAttribute("car", new Car());
        modelMap.addAttribute("userId", userService.getCustomUserId());
        List<Car> carList = carRepository.findAllCarsByUserid(userService.getCustomUserId());
        modelMap.addAttribute("cars", carList);
        return "car";
    }

    @PostMapping("/car")
    public String addCar(ModelMap modelMap, Car car, BindingResult bindingResult) {
        modelMap.addAttribute("car", car);

        if (bindingResult.hasErrors()) {
            return "car";
        }
        try {
            car.setUser(userService.getCustomUser());
            carService.save(car);
        } catch (DataIntegrityViolationException e) {
            modelMap.addAttribute("registrationNumberAlreadyExists", true);
            return "car";
        }
        return "car-added";
    }

}
