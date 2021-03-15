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
package com.github.surgeon.file.gateway;

import com.github.surgeon.file.File;
import com.github.surgeon.file.dto.FileQuery;

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
     * @param query
     * @return /
     */
    List<File> findAll(FileQuery query);

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
