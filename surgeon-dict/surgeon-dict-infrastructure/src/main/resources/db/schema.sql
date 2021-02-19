DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`
(
    `id`          bigint                                  NOT NULL COMMENT 'ID',
    `create_time` datetime                                NOT NULL COMMENT '创建时间',
    `update_time` datetime                                DEFAULT NULL COMMENT '更新时间',
    `create_by`   varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
    `update_by`   varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',

    `name`        varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典名称',
    `description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = COMPACT COMMENT ='数据字典';

DROP TABLE IF EXISTS `sys_dict_detail`;
CREATE TABLE `sys_dict_detail`
(
    `id`          bigint                                  NOT NULL COMMENT 'ID',
    `create_time` datetime                                NOT NULL COMMENT '创建时间',
    `update_time` datetime                                DEFAULT NULL COMMENT '更新时间',
    `create_by`   varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
    `update_by`   varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',

    `dict_id`     bigint                                  DEFAULT NULL COMMENT '字典id',
    `text`        varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字典标签',
    `value`       varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典值',
    `dict_sort`   int                                     DEFAULT NULL COMMENT '排序',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = COMPACT COMMENT ='数据字典详情';
