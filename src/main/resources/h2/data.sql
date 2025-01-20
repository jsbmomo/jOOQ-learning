create sequence if not exists hibernate_sequence start with 1 increment by 1;

call next value for hibernate_sequence;
insert into member (name, age, address, email, reg_dt) values ('홍길동', 20, '대한민국 서울', 'hong@naver.com', now());

call next value for hibernate_sequence;
insert into member (name, age, address, email, reg_dt) values ('이흥선', 25, '대한민국 인천', 'lee@naver.com', now());

call next value for hibernate_sequence;
insert into member (name, age, address, email, reg_dt) values ('Mr.Kim', 21, '대한민국 광주', 'kim21@naver.com', now());

call next value for hibernate_sequence;
insert into member (name, age, address, email, reg_dt) values ('김규하', 28, '대한민국 울산', 'kim28@naver.com', now());

call next value for hibernate_sequence;
insert into member (name, age, address, email, reg_dt) values ('진민수', 30, '대한민국 부산', 'jin@naver.com', now());

insert into product (prod_id, prod_name, prod_price) values (1, '노트북', 3200000);
insert into product (prod_id, prod_name, prod_price) values (2, '모니터', 550000);
insert into product (prod_id, prod_name, prod_price) values (3, '키보드', 189000);
insert into product (prod_id, prod_name, prod_price) values (4, '마우스', 126000);
insert into product (prod_id, prod_name, prod_price) values (5, '사무용품', 50000);