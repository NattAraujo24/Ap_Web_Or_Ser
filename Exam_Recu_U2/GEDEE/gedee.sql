SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


CREATE TABLE `docente` (
  `numemp` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `docente` (`numemp`) VALUES
(123),
(234),
(345),
(456),
(567),
(678),
(789),
(890);


CREATE TABLE `persona` (
  `name` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `curp` varchar(50) NOT NULL,
  `birthday` date NOT NULL,

  `docente_numemp` int(12) DEFAULT NULL,
  `estudiante_matri` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `persona` (`name`, `lastname`,`curp`, `birthday`, `docente_numemp`, `estudiante_matri`) VALUES
('natalia', 'araujo','ARGN030824', '2003-08-24',NULL,'20213TN015'),
('ximena', 'garcia','GAGX950814', '1995-08-14',123,NULL),
('jesus', 'celis','GACJ001206', '2003-12-06',NULL,'20213TN018'),
('maria', 'bahena','BAAM031207', '2003-12-07',NULL,'20213TN016'),
('daniel', 'reyes','RERD031208', '2003-12-08',NULL,'20213TN017'),
('maya', 'gomez','GORM031106', '2003-11-06',NULL,'20213TN019'),
('nicolas', 'jimenez','JIGN031006', '2003-10-06',NULL,'20213TN001'),
('rose', 'rocha','ROGR031206', '2003-12-06',NULL,'20213TN002'),
('felix', 'benitez','BEHF031209', '2003-12-09',NULL,'20213TN003'),
('Juan', 'solis','SOGJ031205', '2003-12-05',NULL,'20213TN004'),
('pablo', 'solaz','SOTP031204', '2003-12-04',NULL,'20213TN005'),
('said', 'rojas','RORS031203', '2003-12-03',NULL,'20213TN006'),
('cesar', 'martinez','MAAC031202', '2003-12-02',NULL,'20213TN007'),
('miguel', 'moreno','MOVM031201', '2003-12-01',NULL,'20213TN008'),
('samuel', 'lopez','LODS030906', '2003-09-06',NULL,'20213TN009'),
('liliana', 'soberanes','SOBL030606', '2003-06-06',NULL,'20213TN010');


CREATE TABLE `estudiante` (
  `matri` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `tipo_lucha` (`matri`) VALUES
('20213TN001'),
('20213TN002'),
('20213TN003'),
('20213TN004'),
('20213TN005'),
('20213TN006'),
('20213TN007'),
('20213TN008'),
('20213TN009'),
('20213TN010'),
('20213TN015'),
('20213TN016'),
('20213TN017'),
('20213TN018'),
('20213TN019');

CREATE TABLE `evaluacion` (
  `calificacion` int(12) NOT NULL,
  `materia` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `tipo_lucha` (`calificacion`,`materia`) VALUES
(8,'servicios'),
(9,'servicios'),
(10,'servicios');

ALTER TABLE `docente`
  ADD PRIMARY KEY (`numemp`);

ALTER TABLE `persona`
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `fk_docente` (`docente_numemp`),
  ADD KEY `fk_estudiante` (`estudiante_matri`);

ALTER TABLE `estudiante`
  ADD PRIMARY KEY (`matri`);

ALTER TABLE `evaluacion`
  ADD PRIMARY KEY (`calificacion`);

ALTER TABLE `docente`
  MODIFY `numemp` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=890;


ALTER TABLE `persona`
  MODIFY `name` varchar(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

ALTER TABLE `estudiante`
  MODIFY `matri` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

ALTER TABLE `evaluacion`
  MODIFY `calificacion` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;


ALTER TABLE `persona`
  ADD CONSTRAINT `fk_docente` FOREIGN KEY (`docente_numemp`) REFERENCES `docente` (`numemp`),
  ADD CONSTRAINT `fk_estudiante` FOREIGN KEY (`estudiante_matri`) REFERENCES `estudiante` (`matri`);
COMMIT;

