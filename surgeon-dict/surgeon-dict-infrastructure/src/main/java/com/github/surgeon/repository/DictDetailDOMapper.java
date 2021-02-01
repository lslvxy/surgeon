package com.github.surgeon.repository;

import static com.github.surgeon.repository.DictDetailDODynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.github.surgeon.base.BaseMapper;
import com.github.surgeon.dataobject.DictDetailDO;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
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

@Mapper
public interface DictDetailDOMapper extends BaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, createBy, createTime, updateTime, updateBy, dictSort, label, value, dictId);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<DictDetailDO> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<DictDetailDO> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("DictDetailDOResult")
    Optional<DictDetailDO> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="DictDetailDOResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="dict_sort", property="dictSort", jdbcType=JdbcType.INTEGER),
        @Result(column="label", property="label", jdbcType=JdbcType.VARCHAR),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="dict_id", property="dictId", jdbcType=JdbcType.BIGINT)
    })
    List<DictDetailDO> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
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
            .map(createBy).toProperty("createBy")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(updateBy).toProperty("updateBy")
            .map(dictSort).toProperty("dictSort")
            .map(label).toProperty("label")
            .map(value).toProperty("value")
            .map(dictId).toProperty("dictId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<DictDetailDO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, dictDetailDO, c ->
            c.map(id).toProperty("id")
            .map(createBy).toProperty("createBy")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(updateBy).toProperty("updateBy")
            .map(dictSort).toProperty("dictSort")
            .map(label).toProperty("label")
            .map(value).toProperty("value")
            .map(dictId).toProperty("dictId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(DictDetailDO record) {
        return MyBatis3Utils.insert(this::insert, record, dictDetailDO, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(createBy).toPropertyWhenPresent("createBy", record::getCreateBy)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(updateBy).toPropertyWhenPresent("updateBy", record::getUpdateBy)
            .map(dictSort).toPropertyWhenPresent("dictSort", record::getDictSort)
            .map(label).toPropertyWhenPresent("label", record::getLabel)
            .map(value).toPropertyWhenPresent("value", record::getValue)
            .map(dictId).toPropertyWhenPresent("dictId", record::getDictId)
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
                .set(createBy).equalTo(record::getCreateBy)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(updateBy).equalTo(record::getUpdateBy)
                .set(dictSort).equalTo(record::getDictSort)
                .set(label).equalTo(record::getLabel)
                .set(value).equalTo(record::getValue)
                .set(dictId).equalTo(record::getDictId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(DictDetailDO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(createBy).equalToWhenPresent(record::getCreateBy)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(updateBy).equalToWhenPresent(record::getUpdateBy)
                .set(dictSort).equalToWhenPresent(record::getDictSort)
                .set(label).equalToWhenPresent(record::getLabel)
                .set(value).equalToWhenPresent(record::getValue)
                .set(dictId).equalToWhenPresent(record::getDictId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(DictDetailDO record) {
        return update(c ->
            c.set(createBy).equalTo(record::getCreateBy)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(updateBy).equalTo(record::getUpdateBy)
            .set(dictSort).equalTo(record::getDictSort)
            .set(label).equalTo(record::getLabel)
            .set(value).equalTo(record::getValue)
            .set(dictId).equalTo(record::getDictId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(DictDetailDO record) {
        return update(c ->
            c.set(createBy).equalToWhenPresent(record::getCreateBy)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(updateBy).equalToWhenPresent(record::getUpdateBy)
            .set(dictSort).equalToWhenPresent(record::getDictSort)
            .set(label).equalToWhenPresent(record::getLabel)
            .set(value).equalToWhenPresent(record::getValue)
            .set(dictId).equalToWhenPresent(record::getDictId)
            .where(id, isEqualTo(record::getId))
        );
    }
}