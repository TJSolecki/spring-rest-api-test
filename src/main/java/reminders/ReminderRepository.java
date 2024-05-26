package reminders;

import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ReminderRepository {
    List<Reminder> reminders = new ArrayList<>();

    public List<Reminder> find_all() { return reminders; }

    @PostConstruct
    private void init() {
        reminders.add(new Reminder(LocalDateTime.now(),
                                   "thomasjsoleck@gmail.com",
                                   "learn spring boot"));
    }
}
