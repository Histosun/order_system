-- -----------------------------------------------------
-- Schema DiabetesRecord
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Restaurant`;

-- -----------------------------------------------------
-- Schema DiabetesRecord
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Restaurant` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `Restaurant`;

-- -----------------------------------------------------
-- Create/Update user for `DiabetesRecord`
-- if you are using any other version than MySQL 8+ you might have to remove this creation and do it manually
-- -----------------------------------------------------
-- DROP USER IF EXISTS cst8288@localhost;
CREATE USER IF NOT EXISTS 'restaurant'@'localhost' IDENTIFIED BY 'restaurant';
GRANT ALL ON `DiabetesRecord`.* TO 'restaurant'@'localhost';

CREATE TABLE user_table(
	id INT PRIMARY KEY auto_increment,
    accountNum VARCHAR(50) UNIQUE NOT NULL,
    pwd CHAR(32) NOT NULL,
    name VARCHAR(50) NOT NULL
);

INSERT INTO user_table VALUES(NULL, '8880619', MD5('123456'), 'John');
INSERT INTO user_table VALUES(NULL, '8880522', MD5('123456'), 'Shawn');
INSERT INTO user_table VALUES(NULL, '8880833', MD5('123456'), 'Jonathan');
INSERT INTO user_table VALUES(NULL, '8880461', MD5('123456'), 'Sarh');

CREATE TABLE dinning_table(
	id INT PRIMARY KEY auto_increment,
    state INT not null default 0,
    userId INT,
    CONSTRAINT fk_dinningTable FOREIGN KEY (userId) references user_table(id)
);

INSERT INTO dinning_table VALUES(null, 0, null);
INSERT INTO dinning_table VALUES(null, 0, null);
INSERT INTO dinning_table VALUES(null, 0, null);
INSERT INTO dinning_table VALUES(null, 0, null);