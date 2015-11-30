-- 점주 PL_OWNER 테이블 --
create table PL_OWNER (
	OWNER_ID VARCHAR2(24) primary key,
	OWNER_PASSWORD VARCHAR2(32) NOT NULL,
	OWNER_NAME VARCHAR2(15) NOT NULL,
	OWNER_PHONE VARCHAR2(11) NOT NULL
)


-- 관리자 PL_ADMIN 테이블 --
create table PL_ADMIN (
	ADMIN_ID VARCHAR2(24) primary key,
	ADMIN_PASSWORD VARCHAR2(32) NOT NULL,
	ADMIN_NAME VARCHAR2(15) NOT NULL,
	ADMIN_PHONE VARCHAR2(11) NOT NULL
)

select store_key from PL_STORE where STORE_NAME = '판교점'

-- 편의점 PL_STORE 테이블 --
create table PL_STORE (
	STORE_ID NUMBER(3) primary key,
	STORE_NAME VARCHAR2(21) NOT NULL,
	OWNER_ID VARCHAR2(24),
	STORE_ADDRESS VARCHAR2(150) NOT NULL,
	STORE_PHONE VARCHAR2(11) NOT NULL,
	STORE_LICENSE VARCHAR2(10) NOT NULL,
	constraint STORE_to_OWNER_fk foreign key (OWNER_ID) references PL_OWNER (OWNER_ID)
)

alter table PL_STORE add (store_timestamp VARCHAR2(50));
alter table PL_STORE add (store_key VARCHAR2(50));


-- 고객 PL_CUSTOMER 테이블 --
create table PL_CUSTOMER (
	CUSTOMER_ID VARCHAR2(24) primary key,
	CUSTOMER_PASSWORD VARCHAR2(32) NOT NULL,
	CUSTOMER_NAME VARCHAR2(15) NOT NULL,
	CUSTOMER_ADDRESS VARCHAR2(150) NOT NULL,
	CUSTOMER_BIRTH VARCHAR2(8) NOT NULL,
	CUSTOMER_GENDER NUMBER(1) NOT NULL,
	CUSTOMER_PHONE VARCHAR2(11) NOT NULL,
	CUSTOMER_EMAIL VARCHAR2(30) NOT NULL,
	CUSTOMER_POINT NUMBER(6) NOT NULL,
	STORE_ID NUMBER(3),
	constraint CUSTOMER_to_STORE_fk foreign key (STORE_ID) references PL_STORE (STORE_ID)
)


-- 카테고리 PL_CATEGORY 테이블 --
create table PL_CATEGORY (
	CATEGORY_ID NUMBER(2) primary key,
	CATEGORY_NAME VARCHAR2(21) NOT NULL
)


-- 물품 정보 PL_ITEM_INFO 테이블 --
create table PL_ITEM_INFO (
	ITEM_ID NUMBER(4) primary key,
	ITEM_NAME VARCHAR2(90)  NOT NULL,
	ITEM_PRICE NUMBER(5) NOT NULL,
	CATEGORY_ID NUMBER(2),
	constraint ITEM_to_CATEGORY_fk foreign key (CATEGORY_ID) references PL_CATEGORY (CATEGORY_ID)
)


-- 서버 물품 PL_SERVER_ITEM 테이블 --
create table PL_SERVER_ITEM (
	SERVER_INDEX NUMBER(8) primary key,
	STORE_ID NUMBER(3),
	ITEM_ID NUMBER(4),
	ITEM_EXPIRATION_DATE DATE NOT NULL,  
	ITEM_COUNT NUMBER(3) NOT NULL,
	constraint SERVER_ITEM_to_STORE_fk foreign key (STORE_ID) references PL_STORE (STORE_ID),
	constraint SERVER_ITEM_to_ITEM_INFO_fk foreign key (ITEM_ID) references PL_ITEM_INFO (ITEM_ID) on delete cascade
)


-- 주문 PL_ORDER 테이블 --
create table PL_ORDER (
	ORDER_NUMBER NUMBER(4) primary key, 
	CUSTOMER_ID VARCHAR2(24),
	STORE_ID NUMBER(3),
	ITEM_ID NUMBER(4),
	ORDER_COUNT NUMBER(3) NOT NULL,
	ORDER_DATE DATE NOT NULL,
	ORDER_STATUS NUMBER(1) DEFAULT 1,
	constraint ORDER_to_CUSTOMER_fk foreign key (CUSTOMER_ID) references PL_CUSTOMER (CUSTOMER_ID),
	constraint ORDER_to_STORE_fk foreign key (STORE_ID) references PL_STORE (STORE_ID),
	constraint ORDER_to_ITEM_INFO_fk foreign key (ITEM_ID) references PL_ITEM_INFO (ITEM_ID)
)


-- 장바구니 PL_CART 테이블 --
create table PL_CART (
	CART_NUMBER NUMBER(4) primary key, 
	CUSTOMER_ID VARCHAR2(24),
	STORE_ID NUMBER(3),
	ITEM_ID NUMBER(4),
	CART_COUNT NUMBER(3) NOT NULL,
	CART_DATE DATE NOT NULL,
	constraint CART_to_CUSTOMER_fk foreign key (CUSTOMER_ID) references PL_CUSTOMER (CUSTOMER_ID),
	constraint CART_to_STORE_fk foreign key (STORE_ID) references PL_STORE (STORE_ID),
	constraint CART_to_ITEM_INFO_fk foreign key (ITEM_ID) references PL_ITEM_INFO (ITEM_ID)
)


create table PL_BOARD (
	BOARD_IDX NUMBER(8) primary key,
	BOARD_TITLE VARCHAR2(60) NOT NULL,
	BOARD_DATE DATE NOT NULL,
	BOARD_READ_COUNT NUMBER(3) NOT NULL,
	BOARD_CONTENT VARCHAR2(300) NOT NULL,
	BOARD_WRITER VARCHAR2(15) NOT NULL,
	BOARD_CATEGORY NUMBER(1) NOT NULL,
	BOARD_CATEGORY_NAME VARCHAR2(6) NOT NULL
)
--
--create table PL_SERVICE_CENTER (
--	SERVICE_NUMBER
--)


-- 서버 물품 인덱스 시퀀스 --
create sequence item_index_seq
	start with 1
	increment by 1
	maxvalue 99999999
	nocycle
	nocache;


-- 게시판 인덱스 시퀀스 --
create sequence board_index_seq
	start with 1
	increment by 1
	maxvalue 99999999
	nocycle
	nocache;
	
create sequence cart_index_seq
   start with 1
   increment by 1
   maxvalue 99999999
   nocycle
   nocache;
   
create sequence order_index_seq
	start with 1
	increment by 1
	maxvalue 99999999
	nocycle
	nocache;

	

-- 모든 테이블 드랍 --
drop table PL_ADMIN

drop table PL_ORDER

drop table PL_CART

drop table PL_CUSTOMER

drop table PL_SERVER_ITEM

drop table PL_ITEM_INFO

drop table PL_CATEGORY

drop table PL_STORE

drop table PL_OWNER

drop table PL_BOARD


-- 서버 물품 인덱스 시퀀스 드랍 --
drop sequence item_index_seq


-- 게시판 인덱스 시퀀스 드랍 --
drop sequence board_index_seq




--select e.item_name, e.item_price, d.item_count, d.item_expiration_date, e.item_id, e.category_id, d.store_id from PL_ITEM_INFO e, PL_SERVER_ITEM d where d.store_id=(select store_id from PL_STORE where owner_id='owner1') and e.item_id = d.item_id 
--
--
--
--select * from PL_SERVER_ITEM, PL_ITEM_INFO where store_id=1
--
--select * from PL_SERVER_ITEM
--
--
--select * from PL_SERVER_ITEM where store_id=(select store_id from PL_STORE where owner_id='owner1')
--
--
--
--
--select * from PL_ITEM_INFO


insert into pl_board values(board_index_seq.nextval, '안녕', sysdate, 1, '퍼킹', '아낙수나문')

insert into pl_board values(board_index_seq.nextval, '그래', sysdate, 1, '퍼킹1234', '이모텝')

select board_idx, board_title, board_date, board_read_count, board_content, board_writer
		from (
			select ceil(rownum/10) page, board_idx, board_title, board_date, board_read_count, board_content, board_writer
			from (
				select board_idx, board_title, board_date, board_read_count, board_content, board_writer from pl_board order by board_idx desc
			)
		) where page = 1

		
		select count(board_idx) from pl_board
		
insert into PL_STORE values(100, '안녕', 'dongshin', '경기도', '01043636', '5555')		
		

select * from (select * from pl_board order by board_date desc) order by board_category desc

select * from (select * from pl_board order by board_category desc) order by board_date desc

select * from pl_board order by board_category, board_date desc


(select * from pl_board where board_category=2 order by board_date desc)
union
(select * from pl_board where board_category=1 order by board_date desc)


select board_idx, board_title, board_date, board_read_count, board_content, board_writer, board_category, board_category_name
		from (
			select ceil(rownum/10) page, board_idx, board_title, board_date, board_read_count, board_content, board_writer, board_category, board_category_name
			from (
				select board_idx, board_title, board_date, board_read_count, board_content, board_writer, board_category, board_category_name from pl_board where board_category=1 order by board_date desc
			)
		) where page = 1

-- 공지사항 최신 3개와 나머지 일반 게시글  합쳐서 각각 날짜 순으로 조회 --
select * from (select * from pl_board where board_category=2 order by board_date desc) where rownum between 1 and 3
union all
select * from (select * from pl_board where board_category=1 order by board_date desc)


-- 공지게시글 최신 3개 글 가져오기 (최신 날짜 순) --
select * from (select * from pl_board where board_category=2 order by board_date desc) where rownum between 1 and 3

-- 일반게시글 모두 가져오기 (최신 날짜 순)
select * from pl_board where board_category=1 order by board_date desc

board_index_seq.nextval