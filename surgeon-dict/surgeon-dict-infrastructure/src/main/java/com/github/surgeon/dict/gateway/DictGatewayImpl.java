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
package com.github.surgeon.dict.gateway;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.github.surgeon.dict.Dict;
import com.github.surgeon.dict.convertor.DictDOConvertor;
import com.github.surgeon.dict.dataobject.DictDO;
import com.github.surgeon.dict.repository.DictDOMapper;
import com.github.surgeon.util.IdUtil;
import com.github.surgeon.util.SqlBuilderUtil;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static com.github.surgeon.dict.repository.DictDODynamicSqlSupport.dictDO;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isLike;
import static org.mybatis.dynamic.sql.SqlBuilder.isNotNull;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

@Component
public class DictGatewayImpl implements DictGateway {

    @Autowired
    private DictDOConvertor dictDOConvertor;
    @Autowired
    private DictDOMapper dictDOMapper;

    @Override
    public Dict findById(Long id) {
        Optional<DictDO> dictDO = dictDOMapper.selectByPrimaryKey(id);
        AtomicReference<Dict> file = new AtomicReference<>();
        dictDO.ifPresent(v -> file.set(dictDOConvertor.toTarget(v)));
        return file.get();
    }

    @Override
    public List<Dict> findAll(String name) {
        SelectStatementProvider provider = select(dictDO.allColumns())
                .from(dictDO)
                .where(dictDO.name, isLike(name).when(StrUtil::isNotBlank).then(SqlBuilderUtil::addWildcards))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return dictDOConvertor.toTarget(dictDOMapper.selectMany(provider));
    }

    @Override
    public List<Dict> findAll() {
        SelectStatementProvider provider = select(dictDO.allColumns())
                .from(dictDO)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Iterable<DictDO> all = dictDOMapper.selectMany(provider);
        return dictDOConvertor.toTarget(CollectionUtil.toCollection(all));
    }

    @Override
    public Dict create(Dict dict) {
        DictDO dictDO = dictDOConvertor.toSource(dict);
        dictDO.setId(IdUtil.getNextId());
        dictDO.setCreateTime(new Date());
        dictDOMapper.insert(dictDO);
        return dictDOConvertor.toTarget(dictDO);
    }

    @Override
    public Dict update(Dict dict) {
        DictDO dictDO = dictDOConvertor.toSource(dict);
        dictDO.setUpdateTime(new Date());
        dictDOMapper.updateByPrimaryKeySelective(dictDO);
        return dictDOConvertor.toTarget(dictDO);
    }

    @Override
    public boolean delete(Long id) {
        int i = dictDOMapper.deleteByPrimaryKey(id);
        return i > 0;
    }


    @Override
    public Dict findByField(Map<String, Object> fieldMap) {
        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder from = select(dictDO.allColumns())
                .from(dictDO).where(dictDO.id, isNotNull());
        fieldMap.forEach((k, v) -> from.and(dictDO.column(k), isEqualTo(v)));
        SelectStatementProvider provider = from.limit(1)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Optional<DictDO> dictDO = dictDOMapper.selectOne(provider);
        return dictDOConvertor.toTarget(dictDO.orElse(null));
    }
}
