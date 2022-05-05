CREATE DATABASE new_companydata;

USE new_companydata;
CREATE TABLE loginuser(
    accountId VARCHAR(255) NOT NULL COMMENT "アカウント",
    password CHAR(6) NOT NULL COMMENT "パスワード",
	PRIMARY KEY (accountId)
);


CREATE TABLE nationality
(
	nationalityCd CHAR(3) NOT NULL COMMENT '国籍コード', -- nationalityCdカラムを設定
	nationalityName VARCHAR(255) COMMENT '国籍',         -- nationalityNameカラムを設定
	PRIMARY KEY( nationalityCd )
);

CREATE TABLE gender(
    genderCd CHAR(2) NOT NULL COMMENT '性別コード',
    genderName VARCHAR(255) NOT NULL COMMENT '性別',
    PRIMARY KEY( genderCd )
	);
    
CREATE
   TABLE empdata(
        -- 社員番号
        empCd CHAR(6) NOT NULL COMMENT '社員番号',
        -- 姓名
        name VARCHAR(255) NOT NULL COMMENT '姓名',
        -- 生年月日
        birthday DATE NOT NULL COMMENT '生年月日',
        -- 国籍コード
        nationalityCd CHAR(3) NOT NULL COMMENT '国籍コード',
        -- 性別コード
        genderCd CHAR(2) NOT NULL COMMENT '性別コード',
        PRIMARY KEY (empCd),
        FOREIGN KEY (nationalityCd) REFERENCES nationality(nationalityCd),
        FOREIGN KEY (genderCd) REFERENCES gender(genderCd)
    );
 
 
INSERT loginuser(accountId, password)values("111@elife.com","000001");
INSERT loginuser(accountId, password)values("222@elife.com","000002");
INSERT loginuser(accountId, password)values("333@elife.com","000003");


insert into nationality(nationalityCd,nationalityName)  values ("001","中国");
insert into nationality(nationalityCd,nationalityName)  values ("002","日本");
insert into nationality(nationalityCd,nationalityName)  values ("003","アメリカ");
insert into nationality(nationalityCd,nationalityName)  values ("004","カナダ");
insert into nationality(nationalityCd,nationalityName)  values ("005","イギリス");

INSERT INTO gender (genderCd,genderName) VALUES('01','女性');
INSERT INTO gender (genderCd,genderName) VALUES('02','男性');
INSERT INTO gender (genderCd,genderName) VALUES('03','不明');

insert into empdata(empCd,name,birthday,nationalityCd,genderCd)  values ("10001","Ada","1990-09-09","001","02");
insert into empdata(empCd,name,birthday,nationalityCd,genderCd)  values ("10002","Bill","1993-09-06","001","01");
insert into empdata(empCd,name,birthday,nationalityCd,genderCd)  values ("10003","Candy","1990-05-09","002","02");
insert into empdata(empCd,name,birthday,nationalityCd,genderCd)  values ("10004","Diona","1992-09-09","002","01");
insert into empdata(empCd,name,birthday,nationalityCd,genderCd)  values ("10005","Ella","1990-04-09","001","02");
insert into empdata(empCd,name,birthday,nationalityCd,genderCd)  values ("10006","Ford","1992-09-11","004","02");
insert into empdata(empCd,name,birthday,nationalityCd,genderCd)  values ("10007","Gin","1991-09-09","001","02");
insert into empdata(empCd,name,birthday,nationalityCd,genderCd)  values ("10008","Helen","1991-09-04","003","01");
insert into empdata(empCd,name,birthday,nationalityCd,genderCd)  values ("10009","Ivan","1990-09-09","002","01");
insert into empdata(empCd,name,birthday,nationalityCd,genderCd)  values ("10010","Jason","1990-09-09","005","01");