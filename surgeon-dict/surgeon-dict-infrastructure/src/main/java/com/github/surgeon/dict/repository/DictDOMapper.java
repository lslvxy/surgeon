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
package com.github.surgeon.dict.repository;

import com.github.surgeon.base.BaseMapper;
import com.github.surgeon.dict.dataobject.DictDO;
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

import static com.github.surgeon.dict.repository.DictDODynamicSqlSupport.code;
import static com.github.surgeon.dict.repository.DictDODynamicSqlSupport.createBy;
import static com.github.surgeon.dict.repository.DictDODynamicSqlSupport.createTime;
import static com.github.surgeon.dict.repository.DictDODynamicSqlSupport.description;
import static com.github.surgeon.dict.repository.DictDODynamicSqlSupport.dictDO;
import static com.github.surgeon.dict.repository.DictDODynamicSqlSupport.id;
import static com.github.surgeon.dict.repository.DictDODynamicSqlSupport.name;
import static com.github.surgeon.dict.repository.DictDODynamicSqlSupport.updateBy;
import static com.github.surgeon.dict.repository.DictDODynamicSqlSupport.updateTime;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface DictDOMapper extends BaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, createTime, updateTime, createBy, updateBy, code, name, description);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    int insert(InsertStatementProvider<DictDO> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<DictDO> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("DictDOResult")
    Optional<DictDO> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "DictDOResult", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "create_by", property = "createBy", jdbcType = JdbcType.VARCHAR),
            @Result(column = "update_by", property = "updateBy", jdbcType = JdbcType.VARCHAR),
            @Result(column = "code", property = "code", jdbcType = JdbcType.VARCHAR),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR)
    })
    List<DictDO> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, dictDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, dictDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(DictDO record) {
        return MyBatis3Utils.insert(this::insert, record, dictDO, c ->
                c.map(id).toProperty("id")
                        .map(createTime).toProperty("createTime")
                        .map(updateTime).toProperty("updateTime")
                        .map(createBy).toProperty("createBy")
                        .map(updateBy).toProperty("updateBy")
                        .map(code).toProperty("code")
                        .map(name).toProperty("name")
                        .map(description).toProperty("description")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<DictDO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, dictDO, c ->
                c.map(id).toProperty("id")
                        .map(createTime).toProperty("createTime")
                        .map(updateTime).toProperty("updateTime")
                        .map(createBy).toProperty("createBy")
                        .map(updateBy).toProperty("updateBy")
                        .map(code).toProperty("code")
                        .map(name).toProperty("name")
                        .map(description).toProperty("description")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(DictDO record) {
        return MyBatis3Utils.insert(this::insert, record, dictDO, c ->
                c.map(id).toPropertyWhenPresent("id", record::getId)
                        .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                        .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
                        .map(createBy).toPropertyWhenPresent("createBy", record::getCreateBy)
                        .map(updateBy).toPropertyWhenPresent("updateBy", record::getUpdateBy)
                        .map(code).toPropertyWhenPresent("code", record::getCode)
                        .map(name).toPropertyWhenPresent("name", record::getName)
                        .map(description).toPropertyWhenPresent("description", record::getDescription)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<DictDO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, dictDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<DictDO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, dictDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<DictDO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, dictDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<DictDO> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, dictDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(DictDO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(createBy).equalTo(record::getCreateBy)
                .set(updateBy).equalTo(record::getUpdateBy)
                .set(code).equalTo(record::getCode)
                .set(name).equalTo(record::getName)
                .set(description).equalTo(record::getDescription);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(DictDO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(createBy).equalToWhenPresent(record::getCreateBy)
                .set(updateBy).equalToWhenPresent(record::getUpdateBy)
                .set(code).equalToWhenPresent(record::getCode)
                .set(name).equalToWhenPresent(record::getName)
                .set(description).equalToWhenPresent(record::getDescription);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(DictDO record) {
        return update(c ->
                c.set(createTime).equalTo(record::getCreateTime)
                        .set(updateTime).equalTo(record::getUpdateTime)
                        .set(createBy).equalTo(record::getCreateBy)
                        .set(updateBy).equalTo(record::getUpdateBy)
                        .set(code).equalTo(record::getCode)
                        .set(name).equalTo(record::getName)
                        .set(description).equalTo(record::getDescription)
                        .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(DictDO record) {
        return update(c ->
                c.set(createTime).equalToWhenPresent(record::getCreateTime)
                        .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                        .set(createBy).equalToWhenPresent(record::getCreateBy)
                        .set(updateBy).equalToWhenPresent(record::getUpdateBy)
                        .set(code).equalToWhenPresent(record::getCode)
                        .set(name).equalToWhenPresent(record::getName)
                        .set(description).equalToWhenPresent(record::getDescription)
                        .where(id, isEqualTo(record::getId))
        );
    }
}