CREATE TABLE `payment_service_db`.`payment_tb` (
    `payment_Id` INT NOT NULL AUTO_INCREMENT,
    `payment_Status` VARCHAR(45) NOT NULL,
    `transaction_Id` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`payment_Id`)
);