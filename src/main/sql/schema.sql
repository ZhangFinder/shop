-- 创建用户表
CREATE TABLE `tb_user` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `usertype` int NOT NULL COMMENT '用户类型',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='用户表'
-- 创建用户表
CREATE TABLE `tb_product` (
  `product_id` int NOT NULL AUTO_INCREMENT COMMENT '产品ID',
  `title` varchar(80) NOT NULL COMMENT '标题',
  `summary` varchar(150) NOT NULL COMMENT '摘要',
  `imageUrl` varchar(200) NOT NULL COMMENT '图片',
  `detail` varchar(1000) NOT NULL COMMENT '详情',
  `price` int NOT NULL COMMENT '价格',
  
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='产品表'