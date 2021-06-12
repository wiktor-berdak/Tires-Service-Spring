package pl.project.car;

import pl.project.calendar.Calendar;
import pl.project.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;
    private CarBrand carBrand;
    @Column(unique = true)
    private String registrationNumber;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy ="user" )
    private List<Calendar> calendarList = new ArrayList<>();

    public Car() {
    }

    public Car(CarBrand carBrand, String registrationNumber, User user) {
        this.carBrand = carBrand;
        this.registrationNumber = registrationNumber;
        this.user = user;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
