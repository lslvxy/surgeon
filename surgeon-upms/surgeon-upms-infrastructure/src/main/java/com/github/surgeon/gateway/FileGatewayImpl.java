package com.github.surgeon.gateway;

import cn.hutool.core.collection.CollectionUtil;
import com.github.surgeon.convertor.FileDOConvertor;
import com.github.surgeon.dataobject.FileDO;
import com.github.surgeon.domain.file.File;
import com.github.surgeon.domain.gateway.FileGateway;
import com.github.surgeon.repository.FileDOMapper;
import com.github.surgeon.util.IdUtil;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static com.github.surgeon.repository.FileDODynamicSqlSupport.fileDO;
import static org.mybatis.dynamic.sql.SqlBuilder.isLike;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

@Component
public class FileGatewayImpl implements FileGateway {

    @Autowired
    private FileDOConvertor fileDOConvertor;
    @Autowired
    private FileDOMapper    fileDOMapper;

    @Override
    public File findById(Long id) {
        Optional<FileDO> fileDO = fileDOMapper.selectByPrimaryKey(id);
        AtomicReference<File> file = new AtomicReference<>();
        fileDO.ifPresent(v -> file.set(fileDOConvertor.toEntity(v)));
        return file.get();
    }

    @Override
    public List<File> listByName(String fileName) {
        SelectStatementProvider provider = select(fileDO.allColumns())
                .from(fileDO)
                .where(fileDO.fileName, isLike(fileName).when(Objects::nonNull))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return fileDOConvertor.toEntity(fileDOMapper.selectMany(provider));
    }

    @Override
    public List<File> findAll() {
        SelectStatementProvider provider = select(fileDO.allColumns())
                .from(fileDO)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Iterable<FileDO> all = fileDOMapper.selectMany(provider);
        return fileDOConvertor.toEntity(CollectionUtil.toCollection(all));
    }

    @Override
    public File create(File file) {
        FileDO fileDO = fileDOConvertor.toDto(file);
        fileDO.setId(IdUtil.getNextId());
        fileDO.setCreateTime(new Date());
        fileDOMapper.insert(fileDO);
        return fileDOConvertor.toEntity(fileDO);
    }

    @Override
    public File update(File file) {
        FileDO fileDO = fileDOConvertor.toDto(file);
        fileDO.setUpdateTime(new Date());
        fileDOMapper.updateByPrimaryKeySelective(fileDO);
        return fileDOConvertor.toEntity(fileDO);
    }

    @Override
    public boolean delete(Long id) {
        int i = fileDOMapper.deleteByPrimaryKey(id);
        return i > 0;
    }
}
