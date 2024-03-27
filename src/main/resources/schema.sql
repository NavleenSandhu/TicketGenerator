CREATE TABLE SEC_ROLE(ROLE_ID INT PRIMARY KEY AUTO_INCREMENT, ROLE_NAME VARCHAR(20) NOT NULL);
CREATE TABLE SEC_USER(USER_ID INT PRIMARY KEY AUTO_INCREMENT, USER_NAME VARCHAR(250) NOT NULL, ENCRYPTED_PASSWORD VARCHAR(255) NOT NULL, ROLE_ID INT, FOREIGN KEY (ROLE_ID) REFERENCES SEC_ROLE(ROLE_ID));
CREATE TABLE TICKETS(ID INT PRIMARY KEY AUTO_INCREMENT, FULL_NAME VARCHAR(255) NOT NULL, CAMPUS VARCHAR(50) NOT NULL, PRICE DECIMAL(7,2) NOT NULL, PHONE VARCHAR(15), EMAIL VARCHAR(250), CITY VARCHAR(100),USER_ID INT, FOREIGN KEY (USER_ID) REFERENCES SEC_USER(USER_ID));
