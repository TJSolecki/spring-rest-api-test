package reminders;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReminderController {

    private final ReminderRepository reminder_repository;

    public ReminderController(ReminderRepository reminder_repository) {
        this.reminder_repository = reminder_repository;
    }

    @GetMapping("/reminders")
    String get_reminders() {
        return reminder_repository.find_all().toString();
    }
}
