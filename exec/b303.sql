-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema b303
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema b303
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `b303` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `b303` ;

-- -----------------------------------------------------
-- Table `b303`.`IN_OUT_CATEGORY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `b303`.`IN_OUT_CATEGORY` (
  `id` INT NOT NULL COMMENT 'ID',
  `category` VARCHAR(45) NULL DEFAULT NULL COMMENT '카테고리',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
COMMENT = '수입/지출 카테고리';


-- -----------------------------------------------------
-- Table `b303`.`USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `b303`.`USER` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `login_id` VARCHAR(45) NULL DEFAULT NULL COMMENT '아이디',
  `password` VARCHAR(45) NULL DEFAULT NULL COMMENT '비밀번호',
  `nickname` VARCHAR(45) NULL DEFAULT NULL COMMENT '닉네임',
  `fish_count` INT NULL DEFAULT NULL COMMENT '굴비수',
  `budget` INT NULL DEFAULT NULL COMMENT '예산',
  `phone` VARCHAR(11) NULL DEFAULT NULL COMMENT '핸드폰 번호',
  `image` VARCHAR(255) NULL DEFAULT NULL COMMENT '프사',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
COMMENT = '사용자';


-- -----------------------------------------------------
-- Table `b303`.`ACCOUNT_BOOK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `b303`.`ACCOUNT_BOOK` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `date` DATE NULL DEFAULT NULL COMMENT '날짜',
  `price` INT NULL DEFAULT NULL COMMENT '금액',
  `category` INT NULL DEFAULT NULL COMMENT '카테고리',
  `used` VARCHAR(45) NULL DEFAULT NULL COMMENT '사용처',
  `contents` TEXT NULL DEFAULT NULL COMMENT '내용',
  `user_id` INT NULL DEFAULT NULL COMMENT '사용자',
  PRIMARY KEY (`id`),
  INDEX `FK_ACCOUNT_BOOK_user_id_USER_id` (`user_id` ASC) VISIBLE,
  INDEX `FK_ACCOUNT_BOOK_category_IN_OUT_CATEGORY_id` (`category` ASC) VISIBLE,
  CONSTRAINT `FK_ACCOUNT_BOOK_category_IN_OUT_CATEGORY_id`
    FOREIGN KEY (`category`)
    REFERENCES `b303`.`IN_OUT_CATEGORY` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `FK_ACCOUNT_BOOK_user_id_USER_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `b303`.`USER` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 55
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
COMMENT = '가계부';


-- -----------------------------------------------------
-- Table `b303`.`CHALLENGE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `b303`.`CHALLENGE` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `start_date` VARCHAR(45) NULL DEFAULT NULL COMMENT '시작일',
  `end_date` VARCHAR(45) NULL DEFAULT NULL COMMENT '종료일',
  `title` TEXT NULL DEFAULT NULL COMMENT '제목',
  `entry_fee` INT NULL DEFAULT NULL COMMENT '참가비',
  `reward` INT NULL DEFAULT NULL COMMENT '리워드',
  `image` VARCHAR(255) NULL DEFAULT NULL COMMENT '사진',
  `status` INT NULL DEFAULT NULL COMMENT '상태',
  `description` TEXT NULL DEFAULT NULL COMMENT '상세설명',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
COMMENT = '챌린지';


-- -----------------------------------------------------
-- Table `b303`.`POST`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `b303`.`POST` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` INT NULL DEFAULT NULL COMMENT '작성자',
  `created_time` DATETIME NULL DEFAULT NULL COMMENT '작성시간',
  `title` VARCHAR(45) NULL DEFAULT NULL COMMENT '제목',
  `contents` TEXT NULL DEFAULT NULL COMMENT '내용',
  `price` INT NULL DEFAULT NULL COMMENT '금액',
  `image` VARCHAR(255) NULL DEFAULT NULL COMMENT '사진',
  `board_category` INT NULL DEFAULT NULL COMMENT '게시판(카테고리)',
  `challenge_id` INT NULL DEFAULT NULL COMMENT '관련챌린지',
  PRIMARY KEY (`id`),
  INDEX `FK_POST_challenge_id_CHALLENGE_id` (`challenge_id` ASC) VISIBLE,
  INDEX `FK_POST_user_id_USER_id` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FK_POST_challenge_id_CHALLENGE_id`
    FOREIGN KEY (`challenge_id`)
    REFERENCES `b303`.`CHALLENGE` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `FK_POST_user_id_USER_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `b303`.`USER` (`id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 40
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
COMMENT = '게시글';


-- -----------------------------------------------------
-- Table `b303`.`COMMENT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `b303`.`COMMENT` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `post_id` INT NULL DEFAULT NULL COMMENT '글 ID',
  `user_id` INT NULL DEFAULT NULL COMMENT '작성자',
  `created_time` VARCHAR(45) NULL DEFAULT NULL COMMENT '작성시간',
  `comment` VARCHAR(150) NULL DEFAULT NULL COMMENT '댓글 내용',
  `contents` TEXT NULL DEFAULT NULL COMMENT '댓글 내용',
  `commented_time` DATETIME NULL DEFAULT NULL COMMENT '작성시간',
  PRIMARY KEY (`id`),
  INDEX `FK_COMMENT_user_id_USER_id` (`user_id` ASC) VISIBLE,
  INDEX `FK_COMMENT_post_id_POST_id` (`post_id` ASC) VISIBLE,
  CONSTRAINT `FK_COMMENT_post_id_POST_id`
    FOREIGN KEY (`post_id`)
    REFERENCES `b303`.`POST` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_COMMENT_user_id_USER_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `b303`.`USER` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 49
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
COMMENT = '댓글';


-- -----------------------------------------------------
-- Table `b303`.`DOWN`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `b303`.`DOWN` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `post_id` INT NULL DEFAULT NULL COMMENT '글 ID',
  `user_id` INT NULL DEFAULT NULL COMMENT '누른사람',
  PRIMARY KEY (`id`),
  INDEX `FK_DOWN_post_id_POST_id` (`post_id` ASC) VISIBLE,
  INDEX `FK_DOWN_user_id_USER_id` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FK_DOWN_post_id_POST_id`
    FOREIGN KEY (`post_id`)
    REFERENCES `b303`.`POST` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_DOWN_user_id_USER_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `b303`.`USER` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
COMMENT = '싫어요';


-- -----------------------------------------------------
-- Table `b303`.`REVIEW`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `b303`.`REVIEW` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `challenge_id` INT NULL DEFAULT NULL COMMENT '챌린지 ID',
  `user_id` INT NULL DEFAULT NULL COMMENT '작성자',
  `contents` TEXT NULL DEFAULT NULL COMMENT '댓글 내용',
  `commented_time` DATETIME NULL DEFAULT NULL COMMENT '작성 시간',
  PRIMARY KEY (`id`),
  INDEX `FK_REVIEW_user_id_USER_id` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FK_REVIEW_user_id_USER_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `b303`.`USER` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
COMMENT = '챌린지 후기';


-- -----------------------------------------------------
-- Table `b303`.`UP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `b303`.`UP` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `post_id` INT NULL DEFAULT NULL COMMENT '글 ID',
  `user_id` INT NULL DEFAULT NULL COMMENT '누른사람',
  PRIMARY KEY (`id`),
  INDEX `FK_UP_post_id_POST_id` (`post_id` ASC) VISIBLE,
  INDEX `FK_UP_user_id_USER_id` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FK_UP_post_id_POST_id`
    FOREIGN KEY (`post_id`)
    REFERENCES `b303`.`POST` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_UP_user_id_USER_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `b303`.`USER` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
COMMENT = '좋아요';


-- -----------------------------------------------------
-- Table `b303`.`USER_CHALLENGE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `b303`.`USER_CHALLENGE` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `challenge_id` INT NULL DEFAULT NULL COMMENT '챌린지 ID',
  `user_id` INT NULL DEFAULT NULL COMMENT '사용자 ID',
  `status` INT NULL DEFAULT NULL COMMENT '상태',
  PRIMARY KEY (`id`),
  INDEX `FK_USER_CHALLENGE_challenge_id_CHALLENGE_id` (`challenge_id` ASC) VISIBLE,
  INDEX `FK_USER_CHALLENGE_user_id_USER_id` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FK_USER_CHALLENGE_challenge_id_CHALLENGE_id`
    FOREIGN KEY (`challenge_id`)
    REFERENCES `b303`.`CHALLENGE` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `FK_USER_CHALLENGE_user_id_USER_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `b303`.`USER` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 34
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
COMMENT = '사용자가 참여한 챌린지';


-- -----------------------------------------------------
-- Table `b303`.`USER_CHALLENGE_DETAIL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `b303`.`USER_CHALLENGE_DETAIL` (
  `id` VARCHAR(45) NULL DEFAULT NULL COMMENT 'ID',
  `date` DATE NULL DEFAULT NULL COMMENT '날짜',
  `status` INT NULL DEFAULT NULL COMMENT '상황')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
COMMENT = '챌린지별 상세 기록';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
