DROP DATABASE IF EXISTS summarizer;
CREATE DATABASE summarizer;
USE summarizer;

CREATE TABLE questions(
    question_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    question VARCHAR(255) NOT NULL,
    PRIMARY KEY(question_id)
);

CREATE TABLE answers(
    answer_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    question_id INT,
    answer VARCHAR(255) NOT NULL,
    PRIMARY KEY(answer_id),
    FOREIGN KEY(question_id) REFERENCES questions(question_id)
);

CREATE TABLE solutions(
    solution_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    question_id INT,
    solution VARCHAR(255) NOT NULL,
    explanation VARCHAR(255) NOT NULL,
    PRIMARY KEY(solution_id),
    FOREIGN KEY(question_id) REFERENCES questions(question_id)
);

INSERT INTO questions(question)
VALUES("Which of the following it is not a JDBC challenge?"),
("Which of these options is not correct about Object Relational Mapping?"),
("Which is the most awesome, fantastic ORM framework for the next foreseeable years?"),
("What is the Java Persistence API?"),
("Which is not a main characteristic of Hibernate?"),
("How is data persisted through in JPA?"),
("Which of the following is incorrect about an Entity class?"),
("Which of the following it is not part of the JPA architecture?"),
("Is the persistence context the place where the persistent entities are created and retrieved?"),
("What are the possible states of an entitiy class instance regarding the persistence context?");

INSERT INTO answers(question_id,answer)
VALUES(1,"Caching is not available"),
(1,"Unnecessary complexity"),
(1,"Endless try-catch-finally-try-catch blocks"),
(1,"Only supports native SQL"),
(2,"One row of the database is copied into a map"),
(2,"One row is inserted in the database table if an object is saved"),
(2,"ORM is responsible with the communication with the database"),
(2,"The principle is to map database tables to a class"),
(3,"Good Plain Old JDBC"),
(3,"YOYOYO"),
(3,"Hibernar"),
(3,"Hibernate"),
(4,"Specification"),
(4,"Implementation"),
(4,"Convention"),
(4,"Another word that end with -tion"),
(5,"One database dialect"),
(5,"Transactions"),
(5,"Sophisticated caching"),
(5,"POJOs"),
(6,"Interface class"),
(6,"Normal class instance"),
(6,"Entity class instance"),
(6,"None of the above"),
(7,"Needs to implement the interface Entity"),
(7,"Should have an id"),
(7,"Should have setters and getters"),
(7,"No private constructor"),
(8,"Persistence Context"),
(8,"Persistence Manager"),
(8,"Persistence"),
(8,"Entity Manager"),
(9,"True"),
(9,"False"),
(10,"New, Persistent, Attached, Deleted"),
(10,"Created, Managed, Attached, Detached"),
(10,"Created, Loaded, Updated, Destroyed"),
(10,"Transient, Managed, Removed, Detached");

INSERT INTO solutions(question_id, solution, explanation)
VALUES(1, "Unnecessary complexity", "This is a challenge using ORM."),
(2, "One row of the database is copied into a map", "One row of the database data is copied to a class instance"),
(3, "Hibernate", "Because..."),
(4, "Specification", "JPA is a specification, aka a set of rules. This provides portability accross different implementations. It uses a standardized API and query language (JPQL)"),
(5, "One database dialect", "Hibernate supports multiple database dialects"),
(6, "Entity class", "Data is persisted through Entity classes instances and each entity class represents a row on a database table"),
(7, "Needs to implement the interface Entity", "An entity class should be a Plain Old Java Object(POJO), with no base class or interface requirements"),
(8, "Persistence Manager", "There is an entity manager that is created by the entity manager factory and it manages the persitence context, which is created by the persistence unit"),
(9, "False", "It is also where persistent entities are modified. Acts as a first level cache for persisted entities and it is only accessible by the entity manager"),
(10, "Transient, Managed, Removed, Detached", "Too long...");

SELECT * from questions;
SELECT * from answers;
SELECT * from solutions;

-- Transient - not associated with persistence, no id value, no db representation, eligible for garbage collection; Persistent - associated with persistence, has id, db representation, sync with db; Removed - associated with persistence, has id, marked for removal; Detached - no longer in sync with db, not associated with persistence, eligible for garbage collection