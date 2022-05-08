-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 08-Maio-2022 às 20:57
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
('d687fd82-d13f-45f9-ab92-475f4d704b96', 'Gustavo', 'pepinellas', 'testesenha123', '2022-05-03', 'M');

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

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_training`
--

CREATE TABLE `tb_training` (
  `id` varchar(40) NOT NULL,
  `exercise_1` varchar(40) NOT NULL,
  `exercise_2` varchar(40) NOT NULL,
  `exercise_3` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
