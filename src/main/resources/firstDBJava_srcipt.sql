DROP DATABASE IF EXISTS firstDBJava;

CREATE DATABASE IF NOT EXISTS firstDBJava;

USE firstDBJava;

CREATE TABLE IF NOT EXISTS Members (
	ID INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    state ENUM ('student', 'teacher', 'staff', 'unknown') DEFAULT 'unknown',
    email VARCHAR(50) NOT NULL ,
    profile_picture LONGBLOB,
    reg_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(ID)
);

CREATE TABLE IF NOT EXISTS Courses (
	ID INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    course_name VARCHAR(50),
	is_daytime BOOLEAN,
    length_week INT UNSIGNED,
    PRIMARY KEY(ID)
);

CREATE TABLE IF NOT EXISTS Subjects (
	ID INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    subject_name VARCHAR(50) NOT NULL,
    credit INT UNSIGNED NOT NULL,
    length_hour INT UNSIGNED NOT NULL,
    -- not perfect, need to specify teacher to subject
    PRIMARY KEY(ID)
);

CREATE TABLE IF NOT EXISTS MembersToCourses ( 
	ID INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    member_ID INT UNSIGNED NOT NULL,
    course_ID INT UNSIGNED NOT NULL,
	PRIMARY KEY(ID),
    FOREIGN KEY(member_ID) REFERENCES Members(ID),  -- test failed --> teszt the other version!!! Members.ID
    FOREIGN KEY(course_ID) REFERENCES Courses(ID)
);

CREATE TABLE IF NOT EXISTS SubjectsToCourses (
-- schedule (which day! --> do not forget!)
	ID INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    subject_ID INT UNSIGNED NOT NULL,
    course_ID INT UNSIGNED NOT NULL,
    -- not the best solution, can be only at one of the days! new table with schedule!!!
    schedule_day ENUM ('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'),
    schedule_hour INT UNSIGNED NOT NULL,
	PRIMARY KEY(ID),
    FOREIGN KEY (subject_ID) REFERENCES Subjects(ID),
    FOREIGN KEY(course_ID) REFERENCES Courses(ID)
);

INSERT INTO Members (name, state, email)
	VALUES 
		('Csaba', 'student', 'csaba@progmatic.hu'),
		('Kata', 'student', 'kata@progmatic.hu'),
		('Ria', 'teacher', 'ria@progmatic.hu'),
		('Szabina', 'staff', 'szabina@progmatic.hu');
        
INSERT INTO Courses (course_name, is_daytime, length_week)
	VALUES 
		('Backend', FALSE, 40), -- ('OOP', 'FALSE', 8)
        ('Backend', TRUE, 40),
        ('Frontend', FALSE, 20),
        ('Frontend', TRUE, 20),
        ('Fullstack', FALSE, 60), -- test failed: ('Fullstack', 'FALSE', 60),
        ('Fullstack', TRUE, 60);
        
INSERT INTO Subjects (subject_name, credit, length_hour)
	VALUES
		('OOP', 10, 40),
        ('Basics', 4, 15),
        ('SQL', 2, 10),
        ('JS', 5, 15),
        ('Bootstrap', 8, 20);    