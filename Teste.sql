CREATE DATABASE IF NOT EXISTS Teste;
USE Teste;

CREATE TABLE `employee` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`)
) ;

CREATE TABLE `salary` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `value` DECIMAL(10,0) NOT NULL,
  `payment_date` DATE NOT NULL,
  `employee_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `salary_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
);

INSERT INTO `employee` (`name`, `email`) VALUES 
('Ana Beatriz', 'Ana_Beatriza@example.com'), 
('Beca cleite', 'BecaCleite@example.com'), 
('Drummond silva', 'Drummond@example.com');

INSERT INTO `salary` (`value`, `payment_date`, `employee_id`) VALUES 
(3200, '2024-07-30', 1), 
(4200, '2024-07-30', 2), 
(3700, '2024-07-30', 3),
(3100, '2024-06-30', 1),
(4300, '2024-06-30', 2),
(3600, '2024-06-30', 3),
(3300, '2024-05-30', 1),
(3800, '2024-05-30', 3),
(3400, '2024-04-30', 1),
(3900, '2024-04-30', 3);


SELECT e.id, e.name, AVG(s.value) AS average_salary 
	FROM  employee e
		JOIN salary s ON e.id = s.employee_id
			WHERE s.payment_date >= DATE_SUB(CURDATE(), INTERVAL 3 MONTH)
				GROUP BY e.name, e.id
					ORDER BY average_salary DESC
						LIMIT 3;
                        
                        
-- DROP DATABASE Teste;