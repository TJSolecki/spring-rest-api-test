package reminders;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class ReminderRepository {
    private static final Logger log =
        LoggerFactory.getLogger((ReminderRepository.class));
    private final JdbcClient jdbcClient;

    public ReminderRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Reminder> find_all() {
        return jdbcClient.sql("SELECT * FROM reminders;")
            .query(Reminder.class)
            .list();
    }
}
