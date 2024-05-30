package reminders;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

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

    Optional<Reminder> find_by_id(int id) {
        return jdbcClient.sql("SELECT * FROM reminders WHERE id = :id")
            .param("id", id)
            .query(Reminder.class)
            .optional();
    }

    void create(Reminder reminder) {
        int updated = jdbcClient
                          .sql("INSERT INTO reminders (remind_date, message, "
                               + "email) VALUES(?, ?, ?)")
                          .params(List.of(reminder.remind_date(),
                                          reminder.message(), reminder.email()))
                          .update();
        Assert.state(updated == 1, "Failed to create reminder");
    }

    void update(Reminder updated_reminder, int id) {
        int updated = jdbcClient
                          .sql("UPDATE reminders SET remind_date = ?, "
                               + "message = ?, email = ? WHERE id = ?")
                          .params(List.of(updated_reminder.remind_date(),
                                          updated_reminder.message(),
                                          updated_reminder.email(), id))
                          .update();
        Assert.state(updated == 1, "Failed to update reminder with id " + id);
    }

    void delete(int id) {
        int updated = jdbcClient.sql("DELETE FROM reminders WHERE id = :id")
                          .param("id", id)
                          .update();

        Assert.state(updated == 1, "Failed to delete reminder with id " + id);
    }
}
