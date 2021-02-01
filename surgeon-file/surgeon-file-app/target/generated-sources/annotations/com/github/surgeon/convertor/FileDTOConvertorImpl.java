package com.github.surgeon.convertor;

import com.github.surgeon.domain.file.File;
import com.github.surgeon.dto.data.FileDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-30T11:47:24+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.9 (Oracle Corporation)"
)
@Component
public class FileDTOConvertorImpl implements FileDTOConvertor {

    @Override
    public File toEntity(FileDTO arg0) {
        if ( arg0 == null ) {
            return null;
        }

        File file = new File();

        file.setCreateTime( arg0.getCreateTime() );
        file.setDeleted( arg0.getDeleted() );
        file.setMd5( arg0.getMd5() );
        file.setFileName( arg0.getFileName() );
        file.setFilePath( arg0.getFilePath() );
        file.setFileSize( arg0.getFileSize() );
        file.setContentType( arg0.getContentType() );

        return file;
    }

    @Override
    public FileDTO toDto(File arg0) {
        if ( arg0 == null ) {
            return null;
        }

        FileDTO fileDTO = new FileDTO();

        fileDTO.setCreateTime( arg0.getCreateTime() );
        fileDTO.setDeleted( arg0.getDeleted() );
        fileDTO.setMd5( arg0.getMd5() );
        fileDTO.setFileName( arg0.getFileName() );
        fileDTO.setFilePath( arg0.getFilePath() );
        fileDTO.setFileSize( arg0.getFileSize() );
        fileDTO.setContentType( arg0.getContentType() );

        return fileDTO;
    }

    @Override
    public List<File> toEntity(Collection<FileDTO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<File> list = new ArrayList<File>( arg0.size() );
        for ( FileDTO fileDTO : arg0 ) {
            list.add( toEntity( fileDTO ) );
        }

        return list;
    }

    @Override
    public List<FileDTO> toDto(Collection<File> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<FileDTO> list = new ArrayList<FileDTO>( arg0.size() );
        for ( File file : arg0 ) {
            list.add( toDto( file ) );
        }

        return list;
    }
}
