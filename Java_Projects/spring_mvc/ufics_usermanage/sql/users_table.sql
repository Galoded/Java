CREATE TABLE users (
  user_id varchar(10) NOT NULL COMMENT '工号',
  user_name varchar(20) NOT NULL COMMENT '用户名',
  sex char(1) NOT NULL COMMENT '性别',
  birthday date DEFAULT NULL COMMENT '生日',
  telephone varchar(20) DEFAULT NULL COMMENT '电话',
  address varchar(256) DEFAULT NULL COMMENT '联系地址',
  PRIMARY KEY (user_id)
);
