package com.github.surgeon.domain.gateway;

import com.github.surgeon.domain.Dict;

import java.util.List;

public interface DictGateway {
    /**
     * 根据ID查询
     *
     * @param id
     * @return /
     */
    Dict findById(Long id);

    /**
     * 根据名称查询
     *
     * @param name
     * @return
     */
    List<Dict> listByName(String name);

    /**
     * 分页查询
     *
     * @return /
     */
    List<Dict> findAll();

    /**
     * 创建
     *
     * @param dict /
     */
    Dict create(Dict dict);

    /**
     * update
     *
     * @param dict
     */
    Dict update(Dict dict);

    /**
     * 删除
     *
     * @param id /
     */
    boolean delete(Long id);
}
