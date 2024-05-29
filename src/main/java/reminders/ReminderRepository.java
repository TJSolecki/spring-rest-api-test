package reminders;

import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public class ReminderRepository {
    List<Reminder> reminders = new ArrayList<>();

    List<Reminder> find_all() { return reminders; }

    Optional<Reminder> find_by_index(int i) {
        try {
            Reminder reminder = reminders.get(i);
            return Optional.of(reminder);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    void create_reminder(Reminder reminder) { reminders.add(reminder); }

    void update_reminder(Reminder updated_reminder, int index) {
        Optional<Reminder> reminder = find_by_index(index);
        if (reminder.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                                              "Reminder with index " + index +
                                                  " does not exist");
        }
        reminders.set(index, updated_reminder);
    }

    @PostConstruct
    private void init() {
        reminders.add(new Reminder(LocalDateTime.now(),
                                   "thomasjsoleck@gmail.com",
                                   "learn spring boot"));
    }
}
