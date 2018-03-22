-- 创建用户表
CREATE TABLE `tb_user` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `usertype` int NOT NULL COMMENT '用户类型',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='用户表'
-- 创建产品表
CREATE TABLE `tb_product` (
  `product_id` int NOT NULL AUTO_INCREMENT COMMENT '产品ID',
  `title` varchar(80) NOT NULL COMMENT '标题',
  `summary` varchar(150) NOT NULL COMMENT '摘要',
  `imageUrl` varchar(200) NOT NULL COMMENT '图片',
  `detail` varchar(1000) NOT NULL COMMENT '详情',
  `price` int NOT NULL COMMENT '价格',
  
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='产品表'
-- 创建产品表
CREATE TABLE `tb_shop_cart` (
  `cart_id` int NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `product_id` int NOT NULL COMMENT '产品ID',
  `user_id` int NOT NULL COMMENT '买家id',
  `buy_price` int NOT NULL COMMENT '购买价格',
  `buy_ammount` int NOT NULL COMMENT '购买数量',
  foreign key(`product_id`) references tb_product(`product_id`),
  foreign key(`user_id`) references tb_user(`user_id`),
  
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='购物车表'
-- 创建购买记录表
CREATE TABLE `tb_buy_history` (
  `buy_id` int NOT NULL AUTO_INCREMENT COMMENT '购买ID',
  `product_id` int NOT NULL COMMENT '产品ID',
  `buyer_id` int NOT NULL COMMENT '买家id',
  `buy_ammount` int NOT NULL COMMENT '购买数量',
  `buy_time` varchar(50) NOT NULL COMMENT '购买时间',
  foreign key(`product_id`) references tb_product(`product_id`),
  foreign key(`buyer_id`) references tb_user(`user_id`),
  
  PRIMARY KEY (`buy_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='购物车表'

