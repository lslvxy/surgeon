/*
 * Copyright © 2021 Laysan (lslvxy@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * This is domain module, the core business logic is implemented here.
 *
 * @author Laysan
 */
package com.github.surgeon.file;
/*

文件夹安装模块划分
dataobject 和repository 目录通过 mybatis 自动生成,不要修改
配置文件及sql在resources 目录
通过mvn 执行mybatis-generator:generate 生成代码
mybatis-generator.xml 底部添加需要生成的表
*/
