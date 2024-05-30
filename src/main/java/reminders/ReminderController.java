package reminders;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reminders")
public class ReminderController {

    private final ReminderRepository reminder_repository;

    public ReminderController(ReminderRepository reminder_repository) {
        this.reminder_repository = reminder_repository;
    }

    @GetMapping("/")
    List<Reminder> get_reminders() {
        return reminder_repository.find_all();
    }

    @GetMapping("/{id}")
    Reminder get_reminder_by_id(@PathVariable int id) {
        Optional<Reminder> reminder = reminder_repository.find_by_id(id);
        if (reminder.isEmpty()) {
            throw new ReminderNotFoundException(id);
        }
        return reminder.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    void create(@Valid @ModelAttribute Reminder reminder) {
        reminder_repository.create(reminder);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @ModelAttribute Reminder updated_reminder,
                @PathVariable int id) {
        reminder_repository.update(updated_reminder, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        reminder_repository.delete(id);
    }
}
