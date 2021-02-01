package com.github.surgeon.convertor;

import com.github.surgeon.domain.DictDetail;
import com.github.surgeon.dto.data.DictDetailDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-01T09:44:21+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.9 (Oracle Corporation)"
)
@Component
public class DictDetailDTOConvertorImpl implements DictDetailDTOConvertor {

    @Autowired
    private DictDTOConvertor dictDTOConvertor;

    @Override
    public DictDetail toEntity(DictDetailDTO arg0) {
        if ( arg0 == null ) {
            return null;
        }

        DictDetail dictDetail = new DictDetail();

        dictDetail.setId( arg0.getId() );
        dictDetail.setDict( dictDTOConvertor.toEntity( arg0.getDict() ) );
        dictDetail.setDictSort( arg0.getDictSort() );
        dictDetail.setLabel( arg0.getLabel() );
        dictDetail.setValue( arg0.getValue() );

        return dictDetail;
    }

    @Override
    public DictDetailDTO toDto(DictDetail arg0) {
        if ( arg0 == null ) {
            return null;
        }

        DictDetailDTO dictDetailDTO = new DictDetailDTO();

        dictDetailDTO.setId( arg0.getId() );
        dictDetailDTO.setDict( dictDTOConvertor.toDto( arg0.getDict() ) );
        dictDetailDTO.setDictSort( arg0.getDictSort() );
        dictDetailDTO.setLabel( arg0.getLabel() );
        dictDetailDTO.setValue( arg0.getValue() );

        return dictDetailDTO;
    }

    @Override
    public List<DictDetail> toEntity(Collection<DictDetailDTO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<DictDetail> list = new ArrayList<DictDetail>( arg0.size() );
        for ( DictDetailDTO dictDetailDTO : arg0 ) {
            list.add( toEntity( dictDetailDTO ) );
        }

        return list;
    }

    @Override
    public List<DictDetailDTO> toDto(Collection<DictDetail> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<DictDetailDTO> list = new ArrayList<DictDetailDTO>( arg0.size() );
        for ( DictDetail dictDetail : arg0 ) {
            list.add( toDto( dictDetail ) );
        }

        return list;
    }
}
