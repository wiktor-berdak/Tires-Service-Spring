package pl.project.car;

import org.springframework.stereotype.Service;
import pl.project.user.UserService;

@Service
public class CarService {
    private CarRepository carRepository;
    private UserService userService;

    public CarService(CarRepository carRepository, UserService userService) {
        this.carRepository = carRepository;
        this.userService = userService;
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

}
