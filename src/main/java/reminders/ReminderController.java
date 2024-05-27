package reminders;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("reminders")
public class ReminderController {

    private final ReminderRepository reminder_repository;

    public ReminderController(ReminderRepository reminder_repository) {
        this.reminder_repository = reminder_repository;
    }

    @GetMapping("/")
    List<Reminder> get_reminders() {
        return reminder_repository.find_all();
    }

    @GetMapping("/{i}")
    Reminder get_reminder_by_index(@PathVariable int i) {
        Optional<Reminder> reminder = reminder_repository.find_by_index(i);
        if (reminder.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return reminder.get();
    }
}
