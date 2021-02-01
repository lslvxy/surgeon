package com.github.surgeon.convertor;

import com.github.surgeon.dataobject.FileDO;
import com.github.surgeon.domain.file.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-30T11:47:23+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.9 (Oracle Corporation)"
)
@Component
public class FileDOConvertorImpl implements FileDOConvertor {

    @Override
    public File toEntity(FileDO arg0) {
        if ( arg0 == null ) {
            return null;
        }

        File file = new File();

        file.setCreateBy( arg0.getCreateBy() );
        file.setCreateTime( arg0.getCreateTime() );
        file.setUpdateTime( arg0.getUpdateTime() );
        file.setDeleted( arg0.getDeleted() );
        file.setMd5( arg0.getMd5() );
        file.setFileName( arg0.getFileName() );
        file.setFilePath( arg0.getFilePath() );
        file.setFileSize( arg0.getFileSize() );
        file.setContentType( arg0.getContentType() );

        return file;
    }

    @Override
    public FileDO toDto(File arg0) {
        if ( arg0 == null ) {
            return null;
        }

        FileDO fileDO = new FileDO();

        fileDO.setCreateBy( arg0.getCreateBy() );
        fileDO.setCreateTime( arg0.getCreateTime() );
        fileDO.setUpdateTime( arg0.getUpdateTime() );
        fileDO.setDeleted( arg0.getDeleted() );
        fileDO.setMd5( arg0.getMd5() );
        fileDO.setFileName( arg0.getFileName() );
        fileDO.setFilePath( arg0.getFilePath() );
        fileDO.setFileSize( arg0.getFileSize() );
        fileDO.setContentType( arg0.getContentType() );

        return fileDO;
    }

    @Override
    public List<File> toEntity(Collection<FileDO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<File> list = new ArrayList<File>( arg0.size() );
        for ( FileDO fileDO : arg0 ) {
            list.add( toEntity( fileDO ) );
        }

        return list;
    }

    @Override
    public List<FileDO> toDto(Collection<File> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<FileDO> list = new ArrayList<FileDO>( arg0.size() );
        for ( File file : arg0 ) {
            list.add( toDto( file ) );
        }

        return list;
    }
}
