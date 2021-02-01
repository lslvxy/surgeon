package com.github.surgeon.convertor;

import com.github.surgeon.dataobject.DictDO;
import com.github.surgeon.domain.Dict;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-01T09:44:20+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.9 (Oracle Corporation)"
)
@Component
public class DictDOConvertorImpl implements DictDOConvertor {

    @Override
    public Dict toEntity(DictDO arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Dict dict = new Dict();

        dict.setCreateBy( arg0.getCreateBy() );
        dict.setCreateTime( arg0.getCreateTime() );
        dict.setUpdateTime( arg0.getUpdateTime() );
        dict.setId( arg0.getId() );
        dict.setName( arg0.getName() );
        dict.setDescription( arg0.getDescription() );

        return dict;
    }

    @Override
    public DictDO toDto(Dict arg0) {
        if ( arg0 == null ) {
            return null;
        }

        DictDO dictDO = new DictDO();

        dictDO.setCreateBy( arg0.getCreateBy() );
        dictDO.setCreateTime( arg0.getCreateTime() );
        dictDO.setUpdateTime( arg0.getUpdateTime() );
        dictDO.setId( arg0.getId() );
        dictDO.setName( arg0.getName() );
        dictDO.setDescription( arg0.getDescription() );

        return dictDO;
    }

    @Override
    public List<Dict> toEntity(Collection<DictDO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Dict> list = new ArrayList<Dict>( arg0.size() );
        for ( DictDO dictDO : arg0 ) {
            list.add( toEntity( dictDO ) );
        }

        return list;
    }

    @Override
    public List<DictDO> toDto(Collection<Dict> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<DictDO> list = new ArrayList<DictDO>( arg0.size() );
        for ( Dict dict : arg0 ) {
            list.add( toDto( dict ) );
        }

        return list;
    }
}
