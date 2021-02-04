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
package com.github.surgeon.util;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author laysan
 * @version v1 FileUtils.java
 * @comment
 * @since 2020/12/18 16:57
 */
public class FileUtils extends cn.hutool.core.io.FileUtil {

    /**
     * 根据日期时间生成带目录的文件path
     *
     * @param fileName
     * @return
     */
    public static String getPathByTime(String fileName) {
        fileName = cleanInvalid(fileName);
        LocalDateTime now = LocalDateTime.now();
        String dir = now.format(DateTimeFormatter.ofPattern("yyyy" + File.separator + "MM" + File.separator + "dd"));
        return dir + File.separator + mainName(fileName) + now.format(DateTimeFormatter.ofPattern("_HHmmssSSS")) + "." + extName(fileName);
    }


}