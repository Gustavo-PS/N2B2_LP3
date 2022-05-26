-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 26-Maio-2022 às 20:48
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `movehealth`
--

DELIMITER $$
--
-- Procedimentos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `spDeleteExercise` (IN `id` VARCHAR(40))   delete from tb_exercise where id =id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spDeleteInstructor` (IN `id` VARCHAR(40))   delete from tb_instructor where id = id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spDeleteStudent` (IN `id` VARCHAR(40))   delete from tb_student where id = id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spDeleteTraining` (IN `id` VARCHAR(40))   delete from tb_training where id = id$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_exercise`
--

CREATE TABLE `tb_exercise` (
  `id` varchar(40) NOT NULL,
  `name` varchar(250) NOT NULL,
  `description` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_exercise`
--

INSERT INTO `tb_exercise` (`id`, `name`, `description`) VALUES
('35323c1d-0c8b-4081-8aba-4048b0291210', 'Treino - Michael Oliveira', 'Correr 20km');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_instructor`
--

CREATE TABLE `tb_instructor` (
  `id` varchar(40) NOT NULL,
  `name` varchar(50) NOT NULL,
  `login` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `birthday` date NOT NULL,
  `genre` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_instructor`
--

INSERT INTO `tb_instructor` (`id`, `name`, `login`, `password`, `birthday`, `genre`) VALUES
('6d6fd735-7567-43be-a4e5-5dd168bc3e7f', 'Gustavo Pepinelli Salgado', 'pepinelli_professor', '123', '2001-02-04', 'M'),
('9c2d5b44-3461-40e9-9d4d-f9ec7389f28b', 'Rodrigo Montemor', 'rodrigo_professor', '123', '2001-09-30', 'M');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_student`
--

CREATE TABLE `tb_student` (
  `id` varchar(40) NOT NULL,
  `name` varchar(50) NOT NULL,
  `birthday` date NOT NULL,
  `password` varchar(50) NOT NULL,
  `genre` char(1) NOT NULL,
  `height` double NOT NULL,
  `width` double NOT NULL,
  `training` varchar(40) DEFAULT NULL,
  `instructor` varchar(40) DEFAULT NULL,
  `login` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_student`
--

INSERT INTO `tb_student` (`id`, `name`, `birthday`, `password`, `genre`, `height`, `width`, `training`, `instructor`, `login`) VALUES
('cb4ad64d-e9c4-416b-ba04-78055538941b', 'Michael Oliveira', '1929-12-30', '123', 'M', 183, 85, '35323c1d-0c8b-4081-8aba-4048b0291210', '6d6fd735-7567-43be-a4e5-5dd168bc3e7f', 'michael_aluno');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_training`
--

CREATE TABLE `tb_training` (
  `id` varchar(40) NOT NULL,
  `name` varchar(40) NOT NULL,
  `exercise_1` varchar(40) NOT NULL,
  `exercise_2` varchar(40) DEFAULT NULL,
  `exercise_3` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_training`
--

INSERT INTO `tb_training` (`id`, `name`, `exercise_1`, `exercise_2`, `exercise_3`) VALUES
('d687fd82-d13f-45f9-ab92-475f4d704b32', 'Treino A', 'd687fd82-d13f-45f9-ab92-475f4d704b45', NULL, NULL);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tb_exercise`
--
ALTER TABLE `tb_exercise`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Índices para tabela `tb_instructor`
--
ALTER TABLE `tb_instructor`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `login` (`login`);

--
-- Índices para tabela `tb_student`
--
ALTER TABLE `tb_student`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `login` (`login`);

--
-- Índices para tabela `tb_training`
--
ALTER TABLE `tb_training`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
