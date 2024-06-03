package reminders;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("reminders")
public record ReminderConfigProperties(String email_username,
                                       String email_password) {}
