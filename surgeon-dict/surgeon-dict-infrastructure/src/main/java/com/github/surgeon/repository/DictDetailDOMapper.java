/*
 * Copyright © ${project.inceptionYear} Laysan (lslvxy@gmail.com)
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
package com.github.surgeon.repository;

import com.github.surgeon.base.BaseMapper;
import com.github.surgeon.dataobject.DictDetailDO;
import org.apache.ibatis.annotations.*;
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

import static com.github.surgeon.repository.DictDetailDODynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface DictDetailDOMapper extends BaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, createTime, updateTime, createBy, updateBy, dictId, text, value, dictSort);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    int insert(InsertStatementProvider<DictDetailDO> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<DictDetailDO> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("DictDetailDOResult")
    Optional<DictDetailDO> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "DictDetailDOResult", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "create_by", property = "createBy", jdbcType = JdbcType.VARCHAR),
            @Result(column = "update_by", property = "updateBy", jdbcType = JdbcType.VARCHAR),
            @Result(column = "dict_id", property = "dictId", jdbcType = JdbcType.BIGINT),
            @Result(column = "text", property = "text", jdbcType = JdbcType.VARCHAR),
            @Result(column = "value", property = "value", jdbcType = JdbcType.VARCHAR),
            @Result(column = "dict_sort", property = "dictSort", jdbcType = JdbcType.INTEGER)
    })
    List<DictDetailDO> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, dictDetailDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, dictDetailDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(DictDetailDO record) {
        return MyBatis3Utils.insert(this::insert, record, dictDetailDO, c ->
                c.map(id).toProperty("id")
                        .map(createTime).toProperty("createTime")
                        .map(updateTime).toProperty("updateTime")
                        .map(createBy).toProperty("createBy")
                        .map(updateBy).toProperty("updateBy")
                        .map(dictId).toProperty("dictId")
                        .map(text).toProperty("text")
                        .map(value).toProperty("value")
                        .map(dictSort).toProperty("dictSort")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<DictDetailDO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, dictDetailDO, c ->
                c.map(id).toProperty("id")
                        .map(createTime).toProperty("createTime")
                        .map(updateTime).toProperty("updateTime")
                        .map(createBy).toProperty("createBy")
                        .map(updateBy).toProperty("updateBy")
                        .map(dictId).toProperty("dictId")
                        .map(text).toProperty("text")
                        .map(value).toProperty("value")
                        .map(dictSort).toProperty("dictSort")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(DictDetailDO record) {
        return MyBatis3Utils.insert(this::insert, record, dictDetailDO, c ->
                c.map(id).toPropertyWhenPresent("id", record::getId)
                        .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                        .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
                        .map(createBy).toPropertyWhenPresent("createBy", record::getCreateBy)
                        .map(updateBy).toPropertyWhenPresent("updateBy", record::getUpdateBy)
                        .map(dictId).toPropertyWhenPresent("dictId", record::getDictId)
                        .map(text).toPropertyWhenPresent("text", record::getText)
                        .map(value).toPropertyWhenPresent("value", record::getValue)
                        .map(dictSort).toPropertyWhenPresent("dictSort", record::getDictSort)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<DictDetailDO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, dictDetailDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<DictDetailDO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, dictDetailDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<DictDetailDO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, dictDetailDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<DictDetailDO> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, dictDetailDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(DictDetailDO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(createBy).equalTo(record::getCreateBy)
                .set(updateBy).equalTo(record::getUpdateBy)
                .set(dictId).equalTo(record::getDictId)
                .set(text).equalTo(record::getText)
                .set(value).equalTo(record::getValue)
                .set(dictSort).equalTo(record::getDictSort);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(DictDetailDO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(createBy).equalToWhenPresent(record::getCreateBy)
                .set(updateBy).equalToWhenPresent(record::getUpdateBy)
                .set(dictId).equalToWhenPresent(record::getDictId)
                .set(text).equalToWhenPresent(record::getText)
                .set(value).equalToWhenPresent(record::getValue)
                .set(dictSort).equalToWhenPresent(record::getDictSort);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(DictDetailDO record) {
        return update(c ->
                c.set(createTime).equalTo(record::getCreateTime)
                        .set(updateTime).equalTo(record::getUpdateTime)
                        .set(createBy).equalTo(record::getCreateBy)
                        .set(updateBy).equalTo(record::getUpdateBy)
                        .set(dictId).equalTo(record::getDictId)
                        .set(text).equalTo(record::getText)
                        .set(value).equalTo(record::getValue)
                        .set(dictSort).equalTo(record::getDictSort)
                        .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(DictDetailDO record) {
        return update(c ->
                c.set(createTime).equalToWhenPresent(record::getCreateTime)
                        .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                        .set(createBy).equalToWhenPresent(record::getCreateBy)
                        .set(updateBy).equalToWhenPresent(record::getUpdateBy)
                        .set(dictId).equalToWhenPresent(record::getDictId)
                        .set(text).equalToWhenPresent(record::getText)
                        .set(value).equalToWhenPresent(record::getValue)
                        .set(dictSort).equalToWhenPresent(record::getDictSort)
                        .where(id, isEqualTo(record::getId))
        );
    }
}