INSERT INTO user_tb (id, user_id, user_email, user_password, username, user_gender, user_birth, role) VALUES ('1', 'z2poter', 'ssar@nate.com', '$2a$10$sSu6qQgNY8pqivmlVHaQfOapmxrC0A8B0C/0TTN4cd0BErUBcU8pq', 'ssar', 'MAN', '1997-08-29', 'NORMAL');
INSERT INTO notice_tb (notice_content, notice_title, notice_type) VALUES ('공지내용', '공지제목', '일반공지');

insert into category_tb(ID,CATEGORY_PIC ,CATEGORY_TYPE ) values(1, '/images/categorypic/1.jpg', '채소 · 과일');
insert into category_tb(ID,CATEGORY_PIC ,CATEGORY_TYPE ) values(2, '/images/categorypic/2.jpg', '정육 · 계란');
insert into category_tb(ID,CATEGORY_PIC ,CATEGORY_TYPE ) values(3, '/images/categorypic/3.jpg', '수산 · 해산 · 건어물');
insert into category_tb(ID,CATEGORY_PIC ,CATEGORY_TYPE ) values(4, '/images/categorypic/4.jpg', '면 · 양념 · 오일');
insert into category_tb(ID,CATEGORY_PIC ,CATEGORY_TYPE ) values(5, '/images/categorypic/5.jpg', '국 · 반찬 · 메인요리');
insert into category_tb(ID,CATEGORY_PIC ,CATEGORY_TYPE ) values(6, '/images/categorypic/6.jpg', '베이커리 · 델리');
insert into category_tb(ID,CATEGORY_PIC ,CATEGORY_TYPE ) values(7, '/images/categorypic/7.jpg', '음료 · 주류');
insert into category_tb(ID,CATEGORY_PIC ,CATEGORY_TYPE ) values(8, '/images/categorypic/8.jpg', '건강 · 생활용품');


INSERT INTO product_tb (`id`, `product_thumbnail`, `product_name`, `discount_rate`, `product_uploaded_at`, `category_id`, `seller_id`) VALUES ('1', '/images/1.jpg', '기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션 외 주방용품 특가전', '20', '2023-10-29', 1,1);
INSERT INTO product_tb (`id`, `product_thumbnail`, `product_name`, `discount_rate`, `product_uploaded_at`, `category_id`, `seller_id`) VALUES ('2', '/images/2.jpg', '[황금약단밤 골드]2022년산 햇밤 칼집밤700g외/군밤용/생율','20', '2023-08-29', 2,1);
INSERT INTO product_tb (`id`, `product_thumbnail`, `product_name`, `discount_rate`, `product_uploaded_at`, `category_id`, `seller_id`) VALUES ('3', '/images/3.jpg', '삼성전자 JBL JR310 외 어린이용/성인용 헤드셋 3종!', '20', '2023-08-29', 3,1);
INSERT INTO product_tb (`id`, `product_thumbnail`, `product_name`, `discount_rate`, `product_uploaded_at`, `category_id`, `seller_id`) VALUES ('4', '/images/4.jpg', '바른 누룽지맛 발효효소 2박스 역가수치보장 / 외 7종', '20', '2023-10-29', 3,1);
INSERT INTO product_tb (`id`, `product_thumbnail`, `product_name`, `discount_rate`, `product_uploaded_at`, `category_id`, `seller_id`) VALUES ('5', '/images/5.jpg', '[더주] 컷팅말랑장족, 숏다리 100g/300g 외 주전부리 모음 /중독성 최고/마른안주', '20', '2023-8-29', 4,1);
INSERT INTO product_tb (`id`, `product_thumbnail`, `product_name`, `discount_rate`, `product_uploaded_at`, `category_id`, `seller_id`) VALUES ('6', '/images/6.jpg', '굳지않는 앙금절편 1,050g 2팩 외 우리쌀떡 모음전', '20', '2023-10-29', 5,1);
INSERT INTO product_tb (`id`, `product_thumbnail`, `product_name`, `discount_rate`, `product_uploaded_at`, `category_id`, `seller_id`) VALUES ('7', '/images/7.jpg', 'eoe 이너딜리티 30포, 오렌지맛 고 식이섬유 보충제', '20', '2023-09-29', 5,1);
INSERT INTO product_tb (`id`, `product_thumbnail`, `product_name`, `discount_rate`, `product_uploaded_at`, `category_id`, `seller_id`) VALUES ('8', '/images/8.jpg', 'eoe 이너딜리티 30포, 초코맛 고 식이섬유 보충제', '20', '2023-10-29', 5,1);
INSERT INTO product_tb (`id`, `product_thumbnail`, `product_name`, `discount_rate`, `product_uploaded_at`, `category_id`, `seller_id`) VALUES ('9', '/images/9.jpg', '플레이스테이션 VR2 호라이즌 번들. 생생한 몰입감', '20', '2023-09-29', 5,1);
INSERT INTO product_tb (`id`, `product_thumbnail`, `product_name`, `discount_rate`, `product_uploaded_at`, `category_id`, `seller_id`) VALUES ('10', '/images/10.jpg', '통영 홍 가리비 2kg, 2세트 구매시 1kg 추가증정', '20', '2023-7-29', 6,1);
INSERT INTO product_tb (`id`, `product_thumbnail`, `product_name`, `discount_rate`, `product_uploaded_at`, `category_id`, `seller_id`) VALUES ('11', '/images/11.jpg', '아삭한 궁채 장아찌 1kg 외 인기 반찬 모음전', '20', '2023-10-29', 6,1);
INSERT INTO product_tb (`id`, `product_thumbnail`, `product_name`, `discount_rate`, `product_uploaded_at`, `category_id`, `seller_id`) VALUES ('12', '/images/12.jpg', '깨끗한나라 순수소프트 30롤 2팩. 무형광, 도톰 3겹', '20', '2023-10-29', 7,1);
INSERT INTO product_tb (`id`, `product_thumbnail`, `product_name`, `discount_rate`, `product_uploaded_at`, `category_id`, `seller_id`) VALUES ('13', '/images/13.jpg', '생활공작소 초미세모 칫솔 12입 2개+가글 증정', '20', '2023-10-29', 7,1);
INSERT INTO product_tb (`id`, `product_thumbnail`, `product_name`, `discount_rate`, `product_uploaded_at`, `category_id`, `seller_id`) VALUES ('14', '/images/14.jpg', '경북 영천 샤인머스켓 가정용 1kg 2수 내외', '20', '2023-08-29', 7,1);
INSERT INTO product_tb (`id`, `product_thumbnail`, `product_name`, `discount_rate`, `product_uploaded_at`, `category_id`, `seller_id`) VALUES ('15', '/images/15.jpg', '[LIVE][5%쿠폰] 홈카페 Y3.3 캡슐머신 베이직 세트', '20', '2023-10-29', 8,1);

INSERT INTO review_tb (`id`, `review_title`, `review_content`, `star_count`, `user_id`, `product_id`)VALUES (1, 'asd', '123', 5, 1, 1);
INSERT INTO review_tb (`id`, `review_title`, `review_content`, `star_count`, `user_id`, `product_id`)VALUES (2, 'asd', '123', 5, 1, 1);
INSERT INTO review_tb (`id`, `review_title`, `review_content`, `star_count`, `user_id`, `product_id`)VALUES (3, 'asd', '123', 4, 1, 1);
INSERT INTO review_tb (`id`, `review_title`, `review_content`, `star_count`, `user_id`, `product_id`)VALUES (4, 'asd', '123', 3, 1, 2);
INSERT INTO review_tb (`id`, `review_title`, `review_content`, `star_count`, `user_id`, `product_id`)VALUES (5, 'asd', '123', 4, 1, 2);
INSERT INTO review_tb (`id`, `review_title`, `review_content`, `star_count`, `user_id`, `product_id`)VALUES (6, 'asd', '123', 3, 1, 2);

INSERT INTO option_tb (`id`,`option_stack`, `option_name`, `option_price`, `product_id`) VALUES ('1', '1', '01. 슬라이딩 지퍼백 크리스마스에디션 4종', '10000', '1');
INSERT INTO option_tb (`id`,`option_stack`, `option_name`, `option_price`, `product_id`) VALUES ('2', '1', '01. 슬라이딩 지퍼백 크리스마스에디션 4종', '5000', '1');
INSERT INTO option_tb (`id`,`option_stack`, `option_name`, `option_price`, `product_id`) VALUES ('3', '1', '01. 슬라이딩 지퍼백 크리스마스에디션 4종', '20000', '1');
INSERT INTO option_tb (`id`,`option_stack`, `option_name`, `option_price`, `product_id`) VALUES ('4', '1', '01. 슬라이딩 지퍼백 크리스마스에디션 4종', '10000', '2');
INSERT INTO option_tb (`id`,`option_stack`, `option_name`, `option_price`, `product_id`) VALUES ('5', '1', '01. 슬라이딩 지퍼백 크리스마스에디션 4종', '10000', '3');
INSERT INTO option_tb (`id`,`option_stack`, `option_name`, `option_price`, `product_id`) VALUES ('6', '1', '01. 슬라이딩 지퍼백 크리스마스에디션 4종', '10000', '4');
INSERT INTO option_tb (`id`,`option_stack`, `option_name`, `option_price`, `product_id`) VALUES ('7', '1', '01. 슬라이딩 지퍼백 크리스마스에디션 4종', '10000', '5');
INSERT INTO option_tb (`id`,`option_stack`, `option_name`, `option_price`, `product_id`) VALUES ('8', '1', '01. 슬라이딩 지퍼백 크리스마스에디션 4종', '10000', '6');
INSERT INTO option_tb (`id`,`option_stack`, `option_name`, `option_price`, `product_id`) VALUES ('9', '1', '01. 슬라이딩 지퍼백 크리스마스에디션 4종', '10000', '7');
INSERT INTO option_tb (`id`,`option_stack`, `option_name`, `option_price`, `product_id`) VALUES ('10', '1', '01. 슬라이딩 지퍼백 크리스마스에디션 4종', '10000', '8');
INSERT INTO option_tb (`id`,`option_stack`, `option_name`, `option_price`, `product_id`) VALUES ('11', '1', '01. 슬라이딩 지퍼백 크리스마스에디션 4종', '10000', '9');
INSERT INTO option_tb (`id`,`option_stack`, `option_name`, `option_price`, `product_id`) VALUES ('12', '1', '01. 슬라이딩 지퍼백 크리스마스에디션 4종', '10000', '10');
INSERT INTO option_tb (`id`,`option_stack`, `option_name`, `option_price`, `product_id`) VALUES ('13', '1', '01. 슬라이딩 지퍼백 크리스마스에디션 4종', '10000', '11');
INSERT INTO option_tb (`id`,`option_stack`, `option_name`, `option_price`, `product_id`) VALUES ('14', '1', '01. 슬라이딩 지퍼백 크리스마스에디션 4종', '10000', '12');
INSERT INTO option_tb (`id`,`option_stack`, `option_name`, `option_price`, `product_id`) VALUES ('15', '1', '01. 슬라이딩 지퍼백 크리스마스에디션 4종', '10000', '13');
INSERT INTO option_tb (`id`,`option_stack`, `option_name`, `option_price`, `product_id`) VALUES ('16', '1', '01. 슬라이딩 지퍼백 크리스마스에디션 4종', '10000', '14');
INSERT INTO option_tb (`id`,`option_stack`, `option_name`, `option_price`, `product_id`) VALUES ('17', '1', '01. 슬라이딩 지퍼백 크리스마스에디션 4종', '10000', '15');


INSERT INTO order_tb(`id`, `order_number`, `ordered_at`, `user_id`) VALUES (1, 1, '2023-10-29', 1);
INSERT INTO order_tb(`id`, `order_number`, `ordered_at`, `user_id`) VALUES (2, 2, '2023-10-29', 1);
INSERT INTO order_tb(`id`, `order_number`, `ordered_at`, `user_id`) VALUES (3, 3, '2023-10-29', 1);

INSERT INTO ordered_option_tb(`id`, `ordered_option_quantity`, `ordered_option_price`, `ordered_discount_rate`, `option_id`, `order_id`)
VALUES (1, 1, 1000, 10, 1, 1);
INSERT INTO ordered_option_tb(`id`, `ordered_option_quantity`, `ordered_option_price`, `ordered_discount_rate`, `option_id`, `order_id`)
VALUES (2, 2, 2000, 20, 2, 2);
INSERT INTO ordered_option_tb(`id`, `ordered_option_quantity`, `ordered_option_price`, `ordered_discount_rate`, `option_id`, `order_id`)
VALUES (3, 1, 1000, 10, 5, 3);

insert into address_tb(DESTINATION ,DESTINATION_DETAIL ,IS_DEFAULT_ADDRESS ,RECEIVER_NAME ,RECEIVER_TEL ,USER_ID ) values ('서울특별시 관악구 신길동 명동빌딩','2층',true,'강호동','01012345678',1); 
insert into address_tb(DESTINATION ,DESTINATION_DETAIL ,IS_DEFAULT_ADDRESS ,RECEIVER_NAME ,RECEIVER_TEL ,USER_ID ) values ('부산광역시 부산진구 부전동 혜도빌딩','3층',false,'김수미','01012345678',1); 
insert into address_tb(DESTINATION ,DESTINATION_DETAIL ,IS_DEFAULT_ADDRESS ,RECEIVER_NAME ,RECEIVER_TEL ,USER_ID ) values ('경상남도 창원시 의창구 XX동 OO아파트','12-1',false,'이동국','01012345678',1); 
insert into address_tb(DESTINATION ,DESTINATION_DETAIL ,IS_DEFAULT_ADDRESS ,RECEIVER_NAME ,RECEIVER_TEL ,USER_ID ) values ('서울특별시 관악구 신길동 명동빌딩','4층',false,'강호동','01012345678',1); 
insert into address_tb(DESTINATION ,DESTINATION_DETAIL ,IS_DEFAULT_ADDRESS ,RECEIVER_NAME ,RECEIVER_TEL ,USER_ID ) values ('부산광역시 부산진구 부전동 혜도빌딩','5층',false,'김수미','01012345678',1); 
insert into address_tb(DESTINATION ,DESTINATION_DETAIL ,IS_DEFAULT_ADDRESS ,RECEIVER_NAME ,RECEIVER_TEL ,USER_ID ) values ('경상남도 창원시 의창구 XX동 OO아파트','112-1',false,'이동국','01012345678',1); 

insert into PRODUCT_QUESTION_TB (IS_ANSWERED ,IS_SECRETED ,PRODUCT_QUESTION_CONTENT ,PRODUCT_QUESTION_TITLE ,PRODUCT_ID ,PRODUCT_REPLY_ID ,USER_ID  ) 
values (false,true, '상품질문 내용1', '상품질문 제목1', 1, null, 1); 
insert into PRODUCT_QUESTION_TB (IS_ANSWERED ,IS_SECRETED ,PRODUCT_QUESTION_CONTENT ,PRODUCT_QUESTION_TITLE ,PRODUCT_ID ,PRODUCT_REPLY_ID ,USER_ID  ) 
values (false,true, '상품질문 내용2', '상품질문 제목2', 1, null, 1); 
insert into PRODUCT_QUESTION_TB (IS_ANSWERED ,IS_SECRETED ,PRODUCT_QUESTION_CONTENT ,PRODUCT_QUESTION_TITLE ,PRODUCT_ID ,PRODUCT_REPLY_ID ,USER_ID  ) 
values (false,true, '상품질문 내용3', '상품질문 제목3', 1, null, 1); 
insert into PRODUCT_QUESTION_TB (IS_ANSWERED ,IS_SECRETED ,PRODUCT_QUESTION_CONTENT ,PRODUCT_QUESTION_TITLE ,PRODUCT_ID ,PRODUCT_REPLY_ID ,USER_ID  ) 
values (false,true, '상품질문 내용4', '상품질문 제목4', 1, null, 1); 

-- INSERT INTO option_tb (`id`,`option_stack`, `option_name`, `option_price`, `product_id`) VALUES ('2', '1', '02. 슬라이딩 지퍼백 플라워에디션 5종', '10900', '1');
-- INSERT INTO option_tb (`id`,`option_stack`, `option_name`, `option_price`, `product_id`) VALUES ('3', '1', '고무장갑 베이지 S(소형) 6팩', '9900', '1');
-- INSERT INTO option_tb (`id`,`option_stack`, `option_name`, `option_price`, `product_id`) VALUES ('4', '1', '뽑아쓰는 키친타올 130매 12팩', '16900', '1');
-- INSERT INTO option_tb (`id`,`option_stack`, `option_name`, `option_price`, `product_id`) VALUES ('5', '1', '2겹 식빵수세미 6매', '8900', '2');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('6', '2', '22년산 햇단밤 700g(한정판매)', '9900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('7', '2', '22년산 햇단밤 1kg(한정판매)', '14500');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('8', '2', '밤깎기+다회용 구이판 세트', '5500');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('9', '3', 'JR310 (유선 전용) - 블루', '29900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('10', '3', 'JR310BT (무선 전용) - 레드', '49900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('11', '3', 'JR310BT (무선 전용) - 그린', '49900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('12', '3', 'JR310BT (무선 전용) - 블루', '49900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('13', '3', 'T510BT (무선 전용) - 블랙', '52900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('15', '4', '선택01_바른곡물효소 누룽지맛 2박스', '17900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('16', '4', '선택02_바른곡물효소누룽지맛 6박스', '50000');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('17', '4', '선택03_바른곡물효소3박스+유산균효소3박스', '50000');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('18', '4', '선택04_바른곡물효소3박스+19종유산균3박스', '50000');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('19', '5', '01. 말랑컷팅장족 100g', '4900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('20', '5', '02. 말랑컷팅장족 300g', '12800');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('21', '5', '03. 눌린장족 100g', '4900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('22', '6', '굳지않는 쑥 앙금 절편 1050g', '15900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('23', '6', '굳지않는 흑미 앙금 절편 1050g', '15900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('24', '6', '굳지않는 흰 가래떡 1050g', '15900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('14', '3', 'T510BT (무선 전용) - 화이트', '52900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('25', '7', '이너딜리티 1박스', '26800');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('26', '7', '이너딜리티 2박스+사은품 2종', '49800');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('27', '8', '제나벨 PDRN 자생크림 1+1', '25900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('28', '9', '플레이스테이션 VR2 호라이즌 번들', '839000');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('29', '9', '플레이스테이션 VR2', '797000');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('30', '10', '홍가리비2kg(50미이내)', '8900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('31', '11', '궁채 절임 1kg', '6900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('32', '11', '양념 깻잎 1kg', '8900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('33', '11', '된장 깻잎 1kg', '8900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('34', '11', '간장 깻잎 1kg', '7900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('35', '11', '고추 무침 1kg', '8900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('36', '11', '파래 무침 1kg', '9900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('37', '12', '01_순수소프트 27m 30롤 2팩', '28900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('38', '12', '02_벚꽃 프리미엄 27m 30롤 2팩', '32900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('39', '13', '(증정) 초미세모 칫솔 12개 x 2개', '11900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('40', '13', '(증정) 잇몸케어 치약 100G 3개 x 2개', '16900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('41', '13', '(증정) 구취케어 치약 100G 3개 x 2개', '16900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('42', '13', '(증정)화이트케어 치약 100G 3개 x 2개', '19900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('43', '13', '(증정) 어린이 칫솔 12EA', '9900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('44', '14', '[가정용] 샤인머스켓 1kg 2수내외', '9900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('45', '14', '[특품] 샤인머스켓 1kg 1-2수', '12900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('46', '14', '[특품] 샤인머스켓 2kg 2-3수', '23900');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('47', '15', '화이트', '148000');
-- INSERT INTO option_tb (`id`,`product_id`,`option_name`,`price`) VALUES ('48', '15', '블랙', '148000');

-- INSERT INTO cart_tb (`id`, `user_id`,`option_id`,`quantity`, `price`) VALUES (4, 1, 3, 1, 9900);
-- INSERT INTO cart_tb (`id`,`user_id`,`option_id`,`quantity`, `price`) VALUES (5, 1, 4, 1, 16900);
-- INSERT INTO cart_tb (`id`,`user_id`,`option_id`,`quantity`, `price`) VALUES (6, 1, 17, 2, 100000);

-- INSERT INTO order_tb (`id`,`user_id`) VALUES (1, 1);

-- INSERT INTO item_tb (`option_id`,`order_id`,`quantity`, `price`) VALUES (1, 1, 1, 10000);
-- INSERT INTO item_tb (`option_id`,`order_id`,`quantity`, `price`) VALUES (2, 1, 1, 10900);
-- INSERT INTO item_tb (`option_id`,`order_id`,`quantity`, `price`) VALUES (6, 1, 2, 19800);
