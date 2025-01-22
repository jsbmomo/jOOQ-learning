DROP TABLE IF EXISTS member;

CREATE TABLE member
(
    user_id BIGINT              NOT NULL AUTO_INCREMENT,
    name    VARCHAR(30)         NOT NULL,
    age     INT,
    address VARCHAR(255),
    email   VARCHAR(100),
    reg_dt  DATETIME            NOT NULL,
    PRIMARY KEY (user_id)
);

DROP TABLE IF EXISTS product;

CREATE TABLE product
(
    prod_id     BIGINT          NOT NULL AUTO_INCREMENT,
    prod_name   VARCHAR(255)    NOT NULL,
    prod_price  INT             NOT NULL,
    PRIMARY KEY (prod_id)
);

DROP TABLE IF EXISTS purchase_history;

CREATE TABLE purchase
(
    history_id  BIGINT         NOT NULL AUTO_INCREMENT,
    prod_id     BIGINT,
    user_id     BIGINT,
    PRIMARY KEY (history_id)
);