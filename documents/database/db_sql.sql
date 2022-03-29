-- USER
create table USER
(
    LOGIN_ID VARCHAR(255) comment '로그인 아이디'
        primary key,
    EMAIL VARCHAR(255) comment '이메일',
    PASSWORD VARCHAR(255) comment '비밀번호',
    GRADE VARCHAR(50) comment '등급',
    LOGIN_TYPE VARCHAR(50) COMMENT '로그인 유형',
    REG_DT datetime null comment 'REG_DT',
    REG_ID INT null comment 'REG_ID',
    UPD_DT datetime null comment 'UPD_DT',
    UPD_ID INT null comment 'UPD_ID',
    DEL_DT datetime null comment 'DEL_DT',
    DEL_ID INT null comment 'DEL_ID',
    DEL_YN bit null comment 'DEL_YN'
);