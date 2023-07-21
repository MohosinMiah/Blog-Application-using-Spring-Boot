-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 21, 2023 at 07:01 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `blogapplication`
--

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `description`, `name`) VALUES
(1, 'This is sample test . This is test', 'Category'),
(2, 'This is sample test . This is test', 'Category333'),
(52, 'This is sample test . This is test', 'Category333'),
(102, 'This is sample test . This is test', 'Category333'),
(152, 'This is sample test . This is test', 'eeeeeeee'),
(202, 'This is sample test . This is test', 'eeeeeeee'),
(252, 'This is sample test . This is test', 'Category333'),
(302, 'This is sample test . This is test', 'Category333'),
(352, 'string', 'string'),
(353, 'string', 'eee'),
(402, 'string', 'eee'),
(403, 'string', 'bd');

-- --------------------------------------------------------

--
-- Table structure for table `categories_seq`
--

CREATE TABLE `categories_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categories_seq`
--

INSERT INTO `categories_seq` (`next_val`) VALUES
(501);

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `id` bigint(20) NOT NULL,
  `body` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `post_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`id`, `body`, `email`, `name`, `post_id`) VALUES
(1, 'This is a comment body', 'mohosin@gmail.com', 'Kalam', 1);

-- --------------------------------------------------------

--
-- Table structure for table `comments_seq`
--

CREATE TABLE `comments_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `comments_seq`
--

INSERT INTO `comments_seq` (`next_val`) VALUES
(51);

-- --------------------------------------------------------

--
-- Table structure for table `posts`
--

CREATE TABLE `posts` (
  `id` bigint(20) NOT NULL,
  `content` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `category_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `posts`
--

INSERT INTO `posts` (`id`, `content`, `description`, `title`, `category_id`) VALUES
(1, 'Hi, this is sample content that we ahve to write', 'Brahmanbaria', 'Mohosin', 1),
(2, 'Hi, this is sample content that we ahve to write', 'This is sample test . This is test', 'This is Two', 1),
(53, 'Hi, this is sample content that we ahve to write', 'This is sample test . This is test', 'This is Three', 1),
(102, 'string', 'str 222222222222222 ingstri', 'strin 2     g', 1);

-- --------------------------------------------------------

--
-- Table structure for table `posts_seq`
--

CREATE TABLE `posts_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `posts_seq`
--

INSERT INTO `posts_seq` (`next_val`) VALUES
(201);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `roles_seq`
--

CREATE TABLE `roles_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `roles_seq`
--

INSERT INTO `roles_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `name`, `password`, `username`) VALUES
(1, 'mohosin@gmail.com', 'mohosin', '$2a$10$boT.vhZqXcKw77Yqq3z6UOV93YndYRmAAgP9WTPnLZTUfFlscFLJ6', 'mohosin'),
(2, 'admin@gmail.com', 'admin', '$2a$10$NnAl6rOmdaYH0j9fknzqtOtiv6Dzn2Kz8nAEF.sNhpIuRacoLx/h2', 'admin'),
(3, 'test@gmail.com', 'Test', '$2a$10$iInvjkAILGZW.3E4GmOYFuYGkHdL4anfaNnZ7VUbEuXjY7VUwZC6G', 'test'),
(60, 'test1@gmail.com', 'Test', '$2a$10$Mj6Rbmd5vejJPSs5duixcOkkIAMR2Tk1uQriZsc5mqQ.N/DA1cu0a', 'test1');

-- --------------------------------------------------------

--
-- Table structure for table `users_seq`
--

CREATE TABLE `users_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users_seq`
--

INSERT INTO `users_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKh4c7lvsc298whoyd4w9ta25cr` (`post_id`);

--
-- Indexes for table `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKmchce1gm7f6otpphxd6ixsdps` (`title`),
  ADD KEY `FKijnwr3brs8vaosl80jg9rp7uc` (`category_id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  ADD UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `FKh4c7lvsc298whoyd4w9ta25cr` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`);

--
-- Constraints for table `posts`
--
ALTER TABLE `posts`
  ADD CONSTRAINT `FKijnwr3brs8vaosl80jg9rp7uc` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`);

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
