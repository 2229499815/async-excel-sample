drop table if exists `u_user`;
create table `u_user`(
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_code` varchar(50) NOT NULL DEFAULT '' COMMENT '用户编码',
  `user_name` varchar(60) DEFAULT '' COMMENT '用户姓名',
  `mobile` varchar(60) DEFAULT '' COMMENT '手机号',
  `remarks` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
