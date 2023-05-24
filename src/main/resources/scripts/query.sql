-- CREATE SCHEMA IF NOT EXISTS `spring_mvc` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
-- USE `spring_mvc`;

DROP TABLE IF EXISTS `boards`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `roles`;

CREATE TABLE IF NOT EXISTS `roles` (
    `role_id` INT NOT NULL AUTO_INCREMENT,
    `role_name` VARCHAR(20) UNIQUE NOT NULL,
    PRIMARY KEY (`role_id`)
);

CREATE TABLE IF NOT EXISTS `users` (
    `user_id` BIGINT NOT NULL AUTO_INCREMENT,
    `user_login_id` VARCHAR(100) UNIQUE NOT NULL,
    `user_password` VARCHAR(100) NOT NULL,
    `user_name` VARCHAR(20) NOT NULL,
    `user_profile_image` VARCHAR(200) DEFAULT NULL,
    `user_role_id` INT NOT NULL DEFAULT 3,
    PRIMARY KEY (`user_id`),
    FOREIGN KEY (`user_role_id`) REFERENCES `roles` (`role_id`)
);

CREATE TABLE IF NOT EXISTS `boards` (
    `board_id` BIGINT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(100) NOT NULL,
    `content` TEXT,
    `user_id` BIGINT NOT NULL,
    `create_date_time` DATETIME NOT NULL DEFAULT now(),
    `update_date_time` DATETIME NOT NULL DEFAULT now(),
    `view_count` INT NOT NULL DEFAULT 0,
    PRIMARY KEY (`board_id`),
    FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
);

INSERT INTO `roles` (`role_name`) values ('ROLE_ADMIN');
INSERT INTO `roles` (`role_name`) values ('ROLE_MEMBER');
INSERT INTO `roles` (`role_name`) values ('ROLE_GUEST');

INSERT INTO `users` (`user_login_id`, `user_password`, `user_name`, `user_role_id`) values ('admin', 'admin', '어드민', 1);
INSERT INTO `users` (`user_login_id`, `user_password`, `user_name`, `user_role_id`) values ('member', 'member', '멤버', 2);
INSERT INTO `users` (`user_login_id`, `user_password`, `user_name`, `user_role_id`) values ('guest', 'guest', '게스트', 3);

INSERT INTO `boards` (`title`, `content`, `user_id`) values ('첫번째 게시글', '첫번째 게시글 내용', 1);
INSERT INTO `boards` (`title`, `content`, `user_id`) values ('두번째 게시글', '두번째 게시글 내용', 2);
INSERT INTO `boards` (`title`, `content`, `user_id`) values ('세번째 게시글', '세번째 게시글 내용', 3);