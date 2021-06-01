package pl.project.calendar;

import org.springframework.stereotype.Service;
import pl.project.car.Car;
import pl.project.pack.Pack;
import pl.project.user.User;

@Service
public class CalendarService {
    private CalendarRepository calendarRepository;
    private Car car;
    private User user;
    private Pack pack;

    public CalendarService() {
    }

    public CalendarService(Car car, User user) {
        this.car = car;
        this.user = user;
    }

    public CalendarService(Car car, User user, Pack pack) {
        this.car = car;
        this.user = user;
        this.pack = pack;
    }

    public Calendar makeAnAppointment(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

}
