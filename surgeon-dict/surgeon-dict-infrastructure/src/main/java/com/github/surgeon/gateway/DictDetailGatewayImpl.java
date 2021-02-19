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
package com.github.surgeon.gateway;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.github.surgeon.convertor.DictDetailDOConvertor;
import com.github.surgeon.dataobject.DictDetailDO;
import com.github.surgeon.domain.DictDetail;
import com.github.surgeon.domain.gateway.DictDetailGateway;
import com.github.surgeon.dto.DictDetailQry;
import com.github.surgeon.repository.DictDetailDOMapper;
import com.github.surgeon.util.IdUtil;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static com.github.surgeon.repository.DictDODynamicSqlSupport.dictDO;
import static com.github.surgeon.repository.DictDetailDODynamicSqlSupport.dictDetailDO;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Component
public class DictDetailGatewayImpl implements DictDetailGateway {
    @Autowired
    private DictDetailDOConvertor dictDetailDOConvertor;
    @Autowired
    private DictDetailDOMapper dictDetailDOMapper;

    @Override
    public DictDetail findById(Long id) {
        Optional<DictDetailDO> dictDetailDO = dictDetailDOMapper.selectByPrimaryKey(id);
        AtomicReference<DictDetail> dictDetail = new AtomicReference<>();
        dictDetailDO.ifPresent(v -> dictDetail.set(dictDetailDOConvertor.toEntity(v)));
        return dictDetail.get();
    }

    @Override
    public List<DictDetail> findAll(DictDetailQry qry) {
        SelectStatementProvider s = select(dictDetailDO.allColumns(), dictDO.allColumns()).from(dictDetailDO, "dd")
                .leftJoin(dictDO, "d")
                .on(dictDO.id, equalTo(dictDetailDO.dictId))
                .where(dictDetailDO.text, isLike("%" + qry.getText() + "%").when(ss -> StrUtil.isNotBlank(qry.getText())))
                .and(dictDetailDO.value, isEqualTo(qry.getValue()).when(StrUtil::isNotBlank))
                .and(dictDO.id, isEqualTo(qry.getDictId()).when(ObjectUtil::isNotNull))
                .and(dictDO.name, isLike("%" + qry.getDictName() + "%").when(ss -> StrUtil.isNotBlank(qry.getDictName())))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return dictDetailDOConvertor.toEntity(dictDetailDOMapper.selectMany(s));
    }

    @Override
    public List<DictDetail> findAll() {
        SelectStatementProvider s = select(dictDetailDO.allColumns(), dictDO.allColumns()).from(dictDetailDO, "dd")
                .leftJoin(dictDO, "d")
                .on(dictDO.id, equalTo(dictDetailDO.dictId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return dictDetailDOConvertor.toEntity(dictDetailDOMapper.selectMany(s));
    }

    @Override
    public DictDetail create(DictDetail dictDetail) {
        DictDetailDO dictDetailDO = dictDetailDOConvertor.toDto(dictDetail);
        dictDetailDO.setId(IdUtil.getNextId());
        dictDetailDO.setCreateTime(new Date());
        dictDetailDOMapper.insert(dictDetailDO);
        return dictDetailDOConvertor.toEntity(dictDetailDO);
    }

    @Override
    public DictDetail update(DictDetail dictDetail) {
        DictDetailDO fileDO = dictDetailDOConvertor.toDto(dictDetail);
        fileDO.setUpdateTime(new Date());
        dictDetailDOMapper.updateByPrimaryKeySelective(fileDO);
        return dictDetailDOConvertor.toEntity(fileDO);
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
