CREATE TABLE `crm`.`user` (
                                `user_id` INT NOT NULL AUTO_INCREMENT,
                                `login` VARCHAR(45) NOT NULL,
                                `password` VARCHAR(45) NOT NULL,
                                `name` VARCHAR(45) NOT NULL,
                                `surname` VARCHAR(45) NOT NULL,
                                `is_admin` TINYINT NOT NULL,
                                `unit_id` INT NOT NULL,
                                `salary` DECIMAL(10) NOT NULL,
                                PRIMARY KEY (`user_id`));

CREATE TABLE `crm`.`unit` (
                                `unit_id` INT NOT NULL AUTO_INCREMENT,
                                `name` VARCHAR(45) NOT NULL,
                                `description` VARCHAR(200) NULL,
                                `user_id` INT NOT NULL,
                                PRIMARY KEY (`unit_id`));

ALTER TABLE `crm`.`user`
    ADD INDEX `fk_user_to_unit_idx` (`unit_id` ASC) VISIBLE;
;
ALTER TABLE `crm`.`user`
    ADD CONSTRAINT `fk_user_to_unit`
        FOREIGN KEY (`unit_id`)
            REFERENCES `crm`.`unit` (`unit_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

ALTER TABLE `crm`.`unit`
    ADD INDEX `fk_unit_to_user_idx` (`user_id` ASC) VISIBLE;
;
ALTER TABLE `crm`.`unit`
    ADD CONSTRAINT `fk_unit_to_user`
        FOREIGN KEY (`user_id`)
            REFERENCES `crm`.`user` (`user_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;