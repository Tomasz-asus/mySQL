DROP DATABASE IF EXISTS motorcycledb;
DROP USER IF EXISTS `motorcycleadmin`@`%`;
DROP USER IF EXISTS `motorcycleuser`@`%`;
CREATE DATABASE IF NOT EXISTS motorcycledb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `motorcycleadmin`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,
CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `motorcycledb`.* TO `motorcycleadmin`@`%`;
CREATE USER IF NOT EXISTS `motorcycleuser`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, SHOW VIEW ON `motorcycledb`.* TO `motorcycleuser`@`%`;
FLUSH PRIVILEGES;
