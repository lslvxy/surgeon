DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file`
(
    `id`           bigint   NOT NULL,
    `create_time`  datetime NOT NULL COMMENT '创建时间',
    `update_time`  datetime                                DEFAULT NULL COMMENT '更新时间',
    `create_by`    varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
    `update_by`    varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
    `deleted`      int(1) DEFAULT NULL COMMENT '是否删除  1：已删除  0：正常',

    `md5`          varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件MD5',
    `file_name`    varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件名称',
    `file_path`    varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件路径',
    `file_size`    bigint                                  DEFAULT NULL COMMENT '文件大小',
    `content_type` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件类型',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='文件表';