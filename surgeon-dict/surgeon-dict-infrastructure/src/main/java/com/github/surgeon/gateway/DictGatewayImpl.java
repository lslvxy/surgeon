package com.github.surgeon.gateway;

import cn.hutool.core.collection.CollectionUtil;
import com.github.surgeon.convertor.DictDOConvertor;
import com.github.surgeon.dataobject.DictDO;
import com.github.surgeon.domain.Dict;
import com.github.surgeon.domain.gateway.DictGateway;
import com.github.surgeon.repository.DictDOMapper;
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

import static com.github.surgeon.repository.DictDODynamicSqlSupport.dictDO;
import static org.mybatis.dynamic.sql.SqlBuilder.isLike;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

@Component
public class DictGatewayImpl implements DictGateway {

    @Autowired
    private DictDOConvertor dictDOConvertor;
    @Autowired
    private DictDOMapper    dictDOMapper;

    @Override
    public Dict findById(Long id) {
        Optional<DictDO> dictDO = dictDOMapper.selectByPrimaryKey(id);
        AtomicReference<Dict> file = new AtomicReference<>();
        dictDO.ifPresent(v -> file.set(dictDOConvertor.toEntity(v)));
        return file.get();
    }

    @Override
    public List<Dict> listByName(String fileName) {
        SelectStatementProvider provider = select(dictDO.allColumns())
                .from(dictDO)
                .where(dictDO.name, isLike("%" + fileName + "%").when(Objects::nonNull))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return dictDOConvertor.toEntity(dictDOMapper.selectMany(provider));
    }

    @Override
    public List<Dict> findAll() {
        SelectStatementProvider provider = select(dictDO.allColumns())
                .from(dictDO)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Iterable<DictDO> all = dictDOMapper.selectMany(provider);
        return dictDOConvertor.toEntity(CollectionUtil.toCollection(all));
    }

    @Override
    public Dict create(Dict dict) {
        DictDO dictDO = dictDOConvertor.toDto(dict);
        dictDO.setId(IdUtil.getNextId());
        dictDO.setCreateTime(new Date());
        dictDOMapper.insert(dictDO);
        return dictDOConvertor.toEntity(dictDO);
    }

    @Override
    public Dict update(Dict dict) {
        DictDO dictDO = dictDOConvertor.toDto(dict);
        dictDO.setUpdateTime(new Date());
        dictDOMapper.updateByPrimaryKeySelective(dictDO);
        return dictDOConvertor.toEntity(dictDO);
    }

    @Override
    public boolean delete(Long id) {
        int i = dictDOMapper.deleteByPrimaryKey(id);
        return i > 0;
    }
}
