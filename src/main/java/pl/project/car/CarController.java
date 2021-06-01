package pl.project.car;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.project.user.UserService;

import java.util.List;

@Controller
public class CarController {
    private CarService carService;
    private CarRepository carRepository;

    public CarController(CarService carService, CarRepository carRepository) {
        this.carService = carService;
        this.carRepository = carRepository;
    }

    @GetMapping("/car")
    public String getCarForm(ModelMap modelMap, UserService userService) {
        modelMap.addAttribute("car", new Car());
        modelMap.addAttribute("userId", userService.getCustomUserId());
        return "car";
    }

    @PostMapping("/car")
    public String addCar(ModelMap modelMap, @Validated Car car, UserService userService, BindingResult bindingResult) {
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
        return "cars";
    }

    @GetMapping("/cars")
    public String getCars(ModelMap modelMap) {
        List<Car> carList = carRepository.findAll();
        modelMap.addAttribute("cars", carList);
        return "cars";
    }
}
