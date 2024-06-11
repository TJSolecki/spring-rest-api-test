package reminders;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
@EnableAsync
public class ReminderService {

    private static final Logger log =
        LoggerFactory.getLogger(ReminderService.class);

    @Autowired private ReminderRepository reminderRepository;
    @Autowired private JavaMailSender mailSender;

    @Value("${spring.mail.username}") private String sender;

    @Scheduled(fixedRate = 5 * 60000) // CRON job that runs every 5 minutes
    @Async
    public void sendReminders() {
        List<Reminder> reminders = reminderRepository.get_reminders_to_send();
        for (Reminder reminder : reminders) {
            sendEmail(reminder.email(), reminder.message());
            reminderRepository.delete(reminder.id());
        }
    }

    public void sendEmail(String to, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(to);
        message.setSubject(text);
        message.setText(text);
        mailSender.send(message);
    }
}
