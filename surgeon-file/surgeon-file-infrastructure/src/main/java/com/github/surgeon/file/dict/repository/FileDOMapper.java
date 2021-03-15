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
package com.github.surgeon.file.dict.repository;

import com.github.surgeon.base.BaseMapper;
import com.github.surgeon.file.dataobject.FileDO;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import javax.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface FileDOMapper extends BaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(FileDODynamicSqlSupport.id, FileDODynamicSqlSupport.createTime,
            FileDODynamicSqlSupport.updateTime, FileDODynamicSqlSupport.createBy, FileDODynamicSqlSupport.updateBy,
            FileDODynamicSqlSupport.deleted, FileDODynamicSqlSupport.md5, FileDODynamicSqlSupport.fileName,
            FileDODynamicSqlSupport.filePath, FileDODynamicSqlSupport.fileSize, FileDODynamicSqlSupport.contentType);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    int insert(InsertStatementProvider<FileDO> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<FileDO> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("FileDOResult")
    Optional<FileDO> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "FileDOResult", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "create_by", property = "createBy", jdbcType = JdbcType.VARCHAR),
            @Result(column = "update_by", property = "updateBy", jdbcType = JdbcType.VARCHAR),
            @Result(column = "deleted", property = "deleted", jdbcType = JdbcType.INTEGER),
            @Result(column = "md5", property = "md5", jdbcType = JdbcType.VARCHAR),
            @Result(column = "file_name", property = "fileName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "file_path", property = "filePath", jdbcType = JdbcType.VARCHAR),
            @Result(column = "file_size", property = "fileSize", jdbcType = JdbcType.BIGINT),
            @Result(column = "content_type", property = "contentType", jdbcType = JdbcType.VARCHAR)
    })
    List<FileDO> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, FileDODynamicSqlSupport.fileDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, FileDODynamicSqlSupport.fileDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c ->
                c.where(FileDODynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(FileDO record) {
        return MyBatis3Utils.insert(this::insert, record, FileDODynamicSqlSupport.fileDO, c ->
                c.map(FileDODynamicSqlSupport.id).toProperty("id")
                        .map(FileDODynamicSqlSupport.createTime).toProperty("createTime")
                        .map(FileDODynamicSqlSupport.updateTime).toProperty("updateTime")
                        .map(FileDODynamicSqlSupport.createBy).toProperty("createBy")
                        .map(FileDODynamicSqlSupport.updateBy).toProperty("updateBy")
                        .map(FileDODynamicSqlSupport.deleted).toProperty("deleted")
                        .map(FileDODynamicSqlSupport.md5).toProperty("md5")
                        .map(FileDODynamicSqlSupport.fileName).toProperty("fileName")
                        .map(FileDODynamicSqlSupport.filePath).toProperty("filePath")
                        .map(FileDODynamicSqlSupport.fileSize).toProperty("fileSize")
                        .map(FileDODynamicSqlSupport.contentType).toProperty("contentType")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<FileDO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, FileDODynamicSqlSupport.fileDO, c ->
                c.map(FileDODynamicSqlSupport.id).toProperty("id")
                        .map(FileDODynamicSqlSupport.createTime).toProperty("createTime")
                        .map(FileDODynamicSqlSupport.updateTime).toProperty("updateTime")
                        .map(FileDODynamicSqlSupport.createBy).toProperty("createBy")
                        .map(FileDODynamicSqlSupport.updateBy).toProperty("updateBy")
                        .map(FileDODynamicSqlSupport.deleted).toProperty("deleted")
                        .map(FileDODynamicSqlSupport.md5).toProperty("md5")
                        .map(FileDODynamicSqlSupport.fileName).toProperty("fileName")
                        .map(FileDODynamicSqlSupport.filePath).toProperty("filePath")
                        .map(FileDODynamicSqlSupport.fileSize).toProperty("fileSize")
                        .map(FileDODynamicSqlSupport.contentType).toProperty("contentType")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(FileDO record) {
        return MyBatis3Utils.insert(this::insert, record, FileDODynamicSqlSupport.fileDO, c ->
                c.map(FileDODynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
                        .map(FileDODynamicSqlSupport.createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                        .map(FileDODynamicSqlSupport.updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
                        .map(FileDODynamicSqlSupport.createBy).toPropertyWhenPresent("createBy", record::getCreateBy)
                        .map(FileDODynamicSqlSupport.updateBy).toPropertyWhenPresent("updateBy", record::getUpdateBy)
                        .map(FileDODynamicSqlSupport.deleted).toPropertyWhenPresent("deleted", record::getDeleted)
                        .map(FileDODynamicSqlSupport.md5).toPropertyWhenPresent("md5", record::getMd5)
                        .map(FileDODynamicSqlSupport.fileName).toPropertyWhenPresent("fileName", record::getFileName)
                        .map(FileDODynamicSqlSupport.filePath).toPropertyWhenPresent("filePath", record::getFilePath)
                        .map(FileDODynamicSqlSupport.fileSize).toPropertyWhenPresent("fileSize", record::getFileSize)
                        .map(FileDODynamicSqlSupport.contentType).toPropertyWhenPresent("contentType", record::getContentType)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<FileDO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, FileDODynamicSqlSupport.fileDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<FileDO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, FileDODynamicSqlSupport.fileDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<FileDO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, FileDODynamicSqlSupport.fileDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<FileDO> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
                c.where(FileDODynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, FileDODynamicSqlSupport.fileDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(FileDO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(FileDODynamicSqlSupport.id).equalTo(record::getId)
                .set(FileDODynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(FileDODynamicSqlSupport.updateTime).equalTo(record::getUpdateTime)
                .set(FileDODynamicSqlSupport.createBy).equalTo(record::getCreateBy)
                .set(FileDODynamicSqlSupport.updateBy).equalTo(record::getUpdateBy)
                .set(FileDODynamicSqlSupport.deleted).equalTo(record::getDeleted)
                .set(FileDODynamicSqlSupport.md5).equalTo(record::getMd5)
                .set(FileDODynamicSqlSupport.fileName).equalTo(record::getFileName)
                .set(FileDODynamicSqlSupport.filePath).equalTo(record::getFilePath)
                .set(FileDODynamicSqlSupport.fileSize).equalTo(record::getFileSize)
                .set(FileDODynamicSqlSupport.contentType).equalTo(record::getContentType);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(FileDO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(FileDODynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(FileDODynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(FileDODynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(FileDODynamicSqlSupport.createBy).equalToWhenPresent(record::getCreateBy)
                .set(FileDODynamicSqlSupport.updateBy).equalToWhenPresent(record::getUpdateBy)
                .set(FileDODynamicSqlSupport.deleted).equalToWhenPresent(record::getDeleted)
                .set(FileDODynamicSqlSupport.md5).equalToWhenPresent(record::getMd5)
                .set(FileDODynamicSqlSupport.fileName).equalToWhenPresent(record::getFileName)
                .set(FileDODynamicSqlSupport.filePath).equalToWhenPresent(record::getFilePath)
                .set(FileDODynamicSqlSupport.fileSize).equalToWhenPresent(record::getFileSize)
                .set(FileDODynamicSqlSupport.contentType).equalToWhenPresent(record::getContentType);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(FileDO record) {
        return update(c ->
                c.set(FileDODynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                        .set(FileDODynamicSqlSupport.updateTime).equalTo(record::getUpdateTime)
                        .set(FileDODynamicSqlSupport.createBy).equalTo(record::getCreateBy)
                        .set(FileDODynamicSqlSupport.updateBy).equalTo(record::getUpdateBy)
                        .set(FileDODynamicSqlSupport.deleted).equalTo(record::getDeleted)
                        .set(FileDODynamicSqlSupport.md5).equalTo(record::getMd5)
                        .set(FileDODynamicSqlSupport.fileName).equalTo(record::getFileName)
                        .set(FileDODynamicSqlSupport.filePath).equalTo(record::getFilePath)
                        .set(FileDODynamicSqlSupport.fileSize).equalTo(record::getFileSize)
                        .set(FileDODynamicSqlSupport.contentType).equalTo(record::getContentType)
                        .where(FileDODynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(FileDO record) {
        return update(c ->
                c.set(FileDODynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                        .set(FileDODynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime)
                        .set(FileDODynamicSqlSupport.createBy).equalToWhenPresent(record::getCreateBy)
                        .set(FileDODynamicSqlSupport.updateBy).equalToWhenPresent(record::getUpdateBy)
                        .set(FileDODynamicSqlSupport.deleted).equalToWhenPresent(record::getDeleted)
                        .set(FileDODynamicSqlSupport.md5).equalToWhenPresent(record::getMd5)
                        .set(FileDODynamicSqlSupport.fileName).equalToWhenPresent(record::getFileName)
                        .set(FileDODynamicSqlSupport.filePath).equalToWhenPresent(record::getFilePath)
                        .set(FileDODynamicSqlSupport.fileSize).equalToWhenPresent(record::getFileSize)
                        .set(FileDODynamicSqlSupport.contentType).equalToWhenPresent(record::getContentType)
                        .where(FileDODynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }
}