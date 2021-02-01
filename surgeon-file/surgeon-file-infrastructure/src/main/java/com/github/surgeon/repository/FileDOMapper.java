package com.github.surgeon.repository;

import static com.github.surgeon.repository.FileDODynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.github.surgeon.base.BaseMapper;
import com.github.surgeon.dataobject.FileDO;
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
public interface FileDOMapper extends BaseMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, createTime, updateTime, createBy, updateBy, deleted, md5, fileName, filePath, fileSize, contentType);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<FileDO> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<FileDO> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("FileDOResult")
    Optional<FileDO> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="FileDOResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="deleted", property="deleted", jdbcType=JdbcType.INTEGER),
        @Result(column="md5", property="md5", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_name", property="fileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_path", property="filePath", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_size", property="fileSize", jdbcType=JdbcType.BIGINT),
        @Result(column="content_type", property="contentType", jdbcType=JdbcType.VARCHAR)
    })
    List<FileDO> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, fileDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, fileDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(FileDO record) {
        return MyBatis3Utils.insert(this::insert, record, fileDO, c ->
            c.map(id).toProperty("id")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(createBy).toProperty("createBy")
            .map(updateBy).toProperty("updateBy")
            .map(deleted).toProperty("deleted")
            .map(md5).toProperty("md5")
            .map(fileName).toProperty("fileName")
            .map(filePath).toProperty("filePath")
            .map(fileSize).toProperty("fileSize")
            .map(contentType).toProperty("contentType")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<FileDO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, fileDO, c ->
            c.map(id).toProperty("id")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(createBy).toProperty("createBy")
            .map(updateBy).toProperty("updateBy")
            .map(deleted).toProperty("deleted")
            .map(md5).toProperty("md5")
            .map(fileName).toProperty("fileName")
            .map(filePath).toProperty("filePath")
            .map(fileSize).toProperty("fileSize")
            .map(contentType).toProperty("contentType")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(FileDO record) {
        return MyBatis3Utils.insert(this::insert, record, fileDO, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(createBy).toPropertyWhenPresent("createBy", record::getCreateBy)
            .map(updateBy).toPropertyWhenPresent("updateBy", record::getUpdateBy)
            .map(deleted).toPropertyWhenPresent("deleted", record::getDeleted)
            .map(md5).toPropertyWhenPresent("md5", record::getMd5)
            .map(fileName).toPropertyWhenPresent("fileName", record::getFileName)
            .map(filePath).toPropertyWhenPresent("filePath", record::getFilePath)
            .map(fileSize).toPropertyWhenPresent("fileSize", record::getFileSize)
            .map(contentType).toPropertyWhenPresent("contentType", record::getContentType)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<FileDO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, fileDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<FileDO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, fileDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<FileDO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, fileDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<FileDO> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, fileDO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(FileDO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(createBy).equalTo(record::getCreateBy)
                .set(updateBy).equalTo(record::getUpdateBy)
                .set(deleted).equalTo(record::getDeleted)
                .set(md5).equalTo(record::getMd5)
                .set(fileName).equalTo(record::getFileName)
                .set(filePath).equalTo(record::getFilePath)
                .set(fileSize).equalTo(record::getFileSize)
                .set(contentType).equalTo(record::getContentType);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(FileDO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(createBy).equalToWhenPresent(record::getCreateBy)
                .set(updateBy).equalToWhenPresent(record::getUpdateBy)
                .set(deleted).equalToWhenPresent(record::getDeleted)
                .set(md5).equalToWhenPresent(record::getMd5)
                .set(fileName).equalToWhenPresent(record::getFileName)
                .set(filePath).equalToWhenPresent(record::getFilePath)
                .set(fileSize).equalToWhenPresent(record::getFileSize)
                .set(contentType).equalToWhenPresent(record::getContentType);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(FileDO record) {
        return update(c ->
            c.set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(createBy).equalTo(record::getCreateBy)
            .set(updateBy).equalTo(record::getUpdateBy)
            .set(deleted).equalTo(record::getDeleted)
            .set(md5).equalTo(record::getMd5)
            .set(fileName).equalTo(record::getFileName)
            .set(filePath).equalTo(record::getFilePath)
            .set(fileSize).equalTo(record::getFileSize)
            .set(contentType).equalTo(record::getContentType)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(FileDO record) {
        return update(c ->
            c.set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(createBy).equalToWhenPresent(record::getCreateBy)
            .set(updateBy).equalToWhenPresent(record::getUpdateBy)
            .set(deleted).equalToWhenPresent(record::getDeleted)
            .set(md5).equalToWhenPresent(record::getMd5)
            .set(fileName).equalToWhenPresent(record::getFileName)
            .set(filePath).equalToWhenPresent(record::getFilePath)
            .set(fileSize).equalToWhenPresent(record::getFileSize)
            .set(contentType).equalToWhenPresent(record::getContentType)
            .where(id, isEqualTo(record::getId))
        );
    }
}