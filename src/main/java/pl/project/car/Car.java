package pl.project.car;

import pl.project.user.User;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;
    private CarBrand carBrand;
    private String registrationNumber;

    @ManyToOne
    private User user;

    public Car() {
    }

    public Car(CarBrand carBrand, String registrationNumber, User user) {
        this.carBrand = carBrand;
        this.registrationNumber = registrationNumber;
        this.user = user;
    }

}
