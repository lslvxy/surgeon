package com.github.surgeon.convertor;

import com.github.surgeon.domain.Dict;
import com.github.surgeon.dto.data.DictDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-01T09:44:21+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.9 (Oracle Corporation)"
)
@Component
public class DictDTOConvertorImpl implements DictDTOConvertor {

    @Override
    public Dict toEntity(DictDTO arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Dict dict = new Dict();

        dict.setId( arg0.getId() );
        dict.setName( arg0.getName() );
        dict.setDescription( arg0.getDescription() );

        return dict;
    }

    @Override
    public DictDTO toDto(Dict arg0) {
        if ( arg0 == null ) {
            return null;
        }

        DictDTO dictDTO = new DictDTO();

        dictDTO.setId( arg0.getId() );
        dictDTO.setName( arg0.getName() );
        dictDTO.setDescription( arg0.getDescription() );

        return dictDTO;
    }

    @Override
    public List<Dict> toEntity(Collection<DictDTO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Dict> list = new ArrayList<Dict>( arg0.size() );
        for ( DictDTO dictDTO : arg0 ) {
            list.add( toEntity( dictDTO ) );
        }

        return list;
    }

    @Override
    public List<DictDTO> toDto(Collection<Dict> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<DictDTO> list = new ArrayList<DictDTO>( arg0.size() );
        for ( Dict dict : arg0 ) {
            list.add( toDto( dict ) );
        }

        return list;
    }
}
