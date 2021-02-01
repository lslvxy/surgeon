package com.github.surgeon.domain.gateway;

import com.github.surgeon.domain.file.File;

import java.util.List;

public interface FileGateway {
    /**
     * 根据ID查询
     *
     * @param id
     * @return /
     */
    File findById(Long id);

    /**
     * 根据文件名查询
     *
     * @param fileName
     * @return
     */
    List<File> listByName(String fileName);

    /**
     * 分页查询
     *
     * @return /
     */
    List<File> findAll();

    /**
     * 创建
     *
     * @param file /
     */
    File create(File file);

    /**
     * update
     *
     * @param file
     */
    File update(File file);

    /**
     * 删除
     *
     * @param id /
     */
    boolean delete(Long id);
}
