-- Inserting a User with name "Jon", password "password123", and role "Vendor"
INSERT INTO SEC_ROLE (ROLE_NAME) VALUES ('ROLE_VENDER');
INSERT INTO SEC_USER (USER_NAME, ENCRYPTED_PASSWORD, ROLE_ID) VALUES ('Jon', '$2a$10$tK8/Yy01Kswmf6fX4OkcpeizfSfYF2y2qPeN2eh2YTLuMyNAGOjse', 1);

-- Inserting 5 Users with role "Guest"
INSERT INTO SEC_ROLE (ROLE_NAME) VALUES ('ROLE_GUEST');
INSERT INTO SEC_USER (USER_NAME, ENCRYPTED_PASSWORD, ROLE_ID) VALUES ('Alice', '$2a$10$tK8/Yy01Kswmf6fX4OkcpeizfSfYF2y2qPeN2eh2YTLuMyNAGOjse', 2);
INSERT INTO SEC_USER (USER_NAME, ENCRYPTED_PASSWORD, ROLE_ID) VALUES ('Bob', '$2a$10$tK8/Yy01Kswmf6fX4OkcpeizfSfYF2y2qPeN2eh2YTLuMyNAGOjse', 2);
INSERT INTO SEC_USER (USER_NAME, ENCRYPTED_PASSWORD, ROLE_ID) VALUES ('Charlie', '$2a$10$tK8/Yy01Kswmf6fX4OkcpeizfSfYF2y2qPeN2eh2YTLuMyNAGOjse', 2);
INSERT INTO SEC_USER (USER_NAME, ENCRYPTED_PASSWORD, ROLE_ID) VALUES ('Diana', '$2a$10$tK8/Yy01Kswmf6fX4OkcpeizfSfYF2y2qPeN2eh2YTLuMyNAGOjse', 2);
INSERT INTO SEC_USER (USER_NAME, ENCRYPTED_PASSWORD, ROLE_ID) VALUES ('Edward', '$2a$10$tK8/Yy01Kswmf6fX4OkcpeizfSfYF2y2qPeN2eh2YTLuMyNAGOjse', 2);

-- Inserting 10 Tickets assigned to various Guests
-- 1
INSERT INTO TICKETS (FULL_NAME, CAMPUS, PRICE, PHONE, EMAIL, CITY, USER_ID)
VALUES ('John Cena', 'Davis', 5.99, '4165551234', 'john.doe@example.com', 'New York',1),
('Alice Smith', 'HMC', 9.99, '4165555678', 'alice.smith@example.com', 'Los Angeles',4),
('Randy Orton', 'Davis', 5.99, '4165558765', 'bob.johnson@example.com', 'Chicago',3),
('Emily Davis', 'Trafalgar', 9.99, '4165554321', 'emily.davis@example.com', 'San Francisco',4),
('Michael Lee', 'Davis', 5.99, '4165559876', 'michael.lee@example.com', 'Seattle',5),
('Sarah Wilson', 'Davis', 9.99, '4165556543', 'sarah.wilson@example.com', 'Miami',4),
('Chris Taylor', 'Trafalgar', 9.99, '4165552345', 'chris.taylor@example.com', 'Dallas',2),
('Jessica White', 'Davis', 9.99, '4165557890', 'jessica.white@example.com', 'Atlanta',3),
('Kevin Brown', 'Davis', 5.99, '4165553456', 'kevin.brown@example.com', 'Denver',4),
('Megan Miller', 'HMC', 5.99, '4165556789', 'megan.miller@example.com', 'Phoenix',5);

