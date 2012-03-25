DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS ( 
	userId          varchar(12)		NOT NULL, 
	password		varchar(12)		NOT NULL,
	name			varchar(20)		NOT NULL,
	email			varchar(50),
	isAdmin         bit,
  	
	PRIMARY KEY               (userId)
);

INSERT INTO USERS VALUES('javajigi', 'password', '자바지기', 'admin@javajigi.net', true);