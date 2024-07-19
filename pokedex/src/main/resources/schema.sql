CREATE TABLE if not exists pokemon (
                         id SERIAL PRIMARY KEY,
                         name TEXT NOT NULL,
                         category TEXT NOT NULL,
                         skill TEXT NOT NULL,
                         weight FLOAT NOT NULL
);