DROP TABLE IF EXISTS users;
CREATE TABLE users
(
   id MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT,
   first_name VARCHAR(20) NOT NULL,
   last_name  VARCHAR(20) NOT NULL,
   email      VARCHAR(60) NOT NULL,
   pass       VARCHAR(40) NOT NULL,
   registration_date DATETIME NOT NULL,
   PRIMARY KEY (id)    
);

INSERT INTO users (first_name, last_name, email, pass, registration_date) VALUES
('John','Lennon','john@beatles.com', SHA1('happin3ss'), NOW()),
('Paul','McCartney','paul@beatles.com', SHA1('letITBe'), NOW()),
('George','Harrison','george@beatles.com', SHA1('something'), NOW()),
('Ringo','Starr','ringo@beatles.com', SHA1('thisboy'), NOW()),
('Harri','M‰enp‰‰','harri.maenpaa@gmail.com', SHA1('harri'), NOW()),
('Tuomo','M‰enp‰‰','tuomo.maenpaa@gmail.com', SHA1('tuomo'), NOW()),
('Ritva','Haanp‰‰','ritva.haanpaa@gmail.com', SHA1('ritva'), NOW()),
('Tuula','Rinne','ritva.rinne@gmail.com', SHA1('tuula'), NOW()),
('Eemil','Vaahteram‰ki','eemil.vaahteramaki@gmail.com', SHA1('eemil'), NOW());

DROP TABLE IF EXISTS forums;
CREATE TABLE forums (
   id TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
   name VARCHAR(60) NOT NULL,
   PRIMARY KEY (id)
);

DROP TABLE IF EXISTS messages;
CREATE TABLE messages (
   id INT UNSIGNED NOT NULL AUTO_INCREMENT,
   forum_id TINYINT UNSIGNED NOT NULL,
   parent_id INT UNSIGNED NOT NULL,
   user_id MEDIUMINT UNSIGNED NOT NULL,
   subject VARCHAR(100) NOT NULL,
   body LONGTEXT NOT NULL,
   date_entered TIMESTAMP NOT NULL,
   PRIMARY KEY (id)
);
   