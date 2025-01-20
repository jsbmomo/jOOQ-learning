-- Auto increment 초기화 및 증가를 수동으로 할 경우.
-- create sequence if not exists hibernate_sequence start with 1 increment by 1;
-- call next value for hibernate_sequence;

insert into member (name, age, address, email, reg_dt) values ('홍길동', 20, '대한민국 서울', 'hong@naver.com', now());
insert into member (name, age, address, email, reg_dt) values ('이흥선', 25, '대한민국 인천', 'lee@naver.com', now());
insert into member (name, age, address, email, reg_dt) values ('Mr.Kim', 21, '대한민국 광주', 'kim21@naver.com', now());
insert into member (name, age, address, email, reg_dt) values ('김규하', 28, '대한민국 울산', 'kim28@naver.com', now());
insert into member (name, age, address, email, reg_dt) values ('진민수', 30, '대한민국 부산', 'jin@naver.com', now());

insert into product (prod_name, prod_price) values ('노트북', 3200000);
insert into product (prod_name, prod_price) values ('모니터', 550000);
insert into product (prod_name, prod_price) values ('키보드', 189000);
insert into product (prod_name, prod_price) values ('마우스', 126000);
insert into product (prod_name, prod_price) values ('사무용품', 50000);

insert into purchase_history (prod_id, user_id) values (1, 3);
insert into purchase_history (prod_id, user_id) values (1, 4);
insert into purchase_history (prod_id, user_id) values (2, 1);
insert into purchase_history (prod_id, user_id) values (2, 2);
insert into purchase_history (prod_id, user_id) values (2, 3);
insert into purchase_history (prod_id, user_id) values (2, 4);
insert into purchase_history (prod_id, user_id) values (3, 5);
insert into purchase_history (prod_id, user_id) values (4, 1);
insert into purchase_history (prod_id, user_id) values (4, 2);
insert into purchase_history (prod_id, user_id) values (4, 5);
insert into purchase_history (prod_id, user_id) values (5, 1);
insert into purchase_history (prod_id, user_id) values (5, 5);