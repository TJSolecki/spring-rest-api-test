CREATE TABLE IF NOT EXISTS reminders (
    id SERIAL NOT NULL,
    remind_date TIMESTAMP NOT NULL,
    message VARCHAR(256) NOT NULL,
    email VARCHAR(256) NOT NULL,
    PRIMARY KEY (id)
);
