package reminders;

import java.time.LocalDateTime;

public record Reminder(LocalDateTime remind_date, String email,
                       String message) {}
