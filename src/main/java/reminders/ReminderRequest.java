package reminders;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public record ReminderRequest(LocalDateTime remind_date,
                              @NotEmpty @Email String email, String message) {}
