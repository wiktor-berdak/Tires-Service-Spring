package pl.project.calendar;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import pl.project.car.Car;
import pl.project.pack.Pack;
import pl.project.user.User;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.Date;

@Entity

public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @ManyToOne(fetch = FetchType.LAZY)

    private Car car;

    @Nullable
    @ManyToOne(fetch = FetchType.LAZY)
    private Pack pack;

    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDateTime datetime;


    @ManyToOne(fetch = FetchType.LAZY)

    private User user;

    public Calendar() {
    }

    public Calendar(Car car, Pack pack, LocalDateTime datetime, User user) {
        this.car = car;
        this.pack = pack;
        this.datetime = datetime;
        this.user = user;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Nullable
    public Pack getPack() {
        return pack;
    }

    public void setPack(@Nullable Pack pack) {
        this.pack = pack;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}



