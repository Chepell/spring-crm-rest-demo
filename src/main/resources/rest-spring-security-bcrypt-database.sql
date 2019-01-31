USE `web_customer_tracker`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://www.browserling.com/tools/bcrypt
--
-- Login and pass:
-- Ivan !cds562
-- Olga 12fdLc1#
-- Artem 54flM~L;n

INSERT INTO `users` 
VALUES 
('Ivan','{bcrypt}$2a$10$Bk0tG7ykpVkyucuflcO9x.zCGAwXNBFR2BCk75kyIrSrh4jbO3KmS',1),
('Olga','{bcrypt}$2a$10$rsPQlmougiBaAEWVKDjn0O2ccNFJE.pXpfWLjENHKct.GMhvkEXTK',1),
('Artem','{bcrypt}$2a$10$D.FE3zSJ7gUMfnllAf83cOp8QGpGRieeHh7A60rD5F3yqeh6fj0ue',1);


--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('Ivan','ROLE_EMPLOYEE'),
('Olga','ROLE_EMPLOYEE'),
('Olga','ROLE_MANAGER'),
('Artem','ROLE_EMPLOYEE'),
('Artem','ROLE_ADMIN');


