package pl.project.calendar;

import org.springframework.stereotype.Service;

@Service
public class CalendarService {
    private CalendarRepository calendarRepository;

    public CalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    public Calendar save(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

}
