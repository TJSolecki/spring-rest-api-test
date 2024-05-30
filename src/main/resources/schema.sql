CREATE TABLE IF NOT EXISTS reminders (
    id INT NOT NULL,
    remind_date TIMESTAMP NOT NULL,
    message VARCHAR(256),
    email VARCHAR(256) NOT NULL,
    PRIMARY KEY (id)
);
