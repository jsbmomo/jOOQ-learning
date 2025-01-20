DROP TABLE IF EXISTS member;

CREATE TABLE member
(
    id      BIGINT          NOT NULL AUTO_INCREMENT,
    name    VARCHAR(30)     NOT NULL,
    age     INT,
    address VARCHAR(255),
    email   VARCHAR(100),
    reg_dt  DATETIME        NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS product;

CREATE TABLE product
(
    prod_id     IDENTITY        PRIMARY KEY,
    prod_name   VARCHAR(255)    NOT NULL,
    prod_price  INT             NOT NULL
);