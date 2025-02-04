CREATE SCHEMA IF NOT EXISTS finalexamtest
DEFAULT CHARACTER SET utf8
COLLATE utf8_hungarian_ci;
CREATE USER trainsUser@localhost
IDENTIFIED BY 'training';
GRANT ALL ON finalexamtest.* TO trainsUser@localhost;
USE finalexamtest;