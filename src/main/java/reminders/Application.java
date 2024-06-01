package reminders;

import java.time.LocalDateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner(ReminderRepository reminderRepository) {
        return args -> {
            ReminderRequest reminder = new ReminderRequest(
                LocalDateTime.now(), "thomasjsoleck@gmail.com",
                "learn spring boot");
            reminderRepository.create(reminder);
            ReminderRequest reminder2 = new ReminderRequest(
                LocalDateTime.now(), "thomasjsoleck@gmail.com", "learn svelte");
            reminderRepository.create(reminder2);
        };
    }
}
