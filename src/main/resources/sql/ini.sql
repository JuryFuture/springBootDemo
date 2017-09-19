CREATE TABLE `t_user` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `f_password` varchar(255) DEFAULT NULL COMMENT '密码',
  `f_create_date` datetime NOT NULL COMMENT '创建时间',
  `f_update_date` datetime NOT NULL COMMENT '更新时间',
  `f_is_delete` int(11) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='用户表';