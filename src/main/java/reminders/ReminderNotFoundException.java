package reminders;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReminderNotFoundException extends RuntimeException {
    public ReminderNotFoundException() { super("Reminder not found"); }

    public ReminderNotFoundException(int index) {
        super(String.format("Reminder with index %d not found", index));
    }
}
