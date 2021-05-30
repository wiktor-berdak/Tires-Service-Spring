package pl.project.calendar;

import pl.project.car.Car;
import pl.project.pack.Pack;
import pl.project.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity

public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;

    @ManyToOne(fetch = FetchType.LAZY)

    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)

    private Pack pack;

    private Date datetime;

    @ManyToOne(fetch = FetchType.LAZY)

    private User user;
    public Calendar() {
    }

    public Calendar(Car car, Pack pack, Date datetime, User user) {
        this.car = car;
        this.pack = pack;
        this.datetime = datetime;
        this.user = user;
    }


}
