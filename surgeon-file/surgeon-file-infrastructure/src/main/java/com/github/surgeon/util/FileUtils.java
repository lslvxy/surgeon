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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author laysan
 * @version v1 FileUtils.java
 * @comment
 * @since 2020/12/18 16:57
 */
public class FileUtils extends cn.hutool.core.io.FileUtil {

    //中文正则
    private static Pattern ZHONGWEN_PATTERN = Pattern.compile("[\u4e00-\u9fa5]");

    /**
     * 根据日期时间生成带目录的文件path
     *
     * @param fileName
     * @return
     */
    public static String getPathByTime(String fileName) {
        fileName = replaceChar(fileName);
        LocalDateTime now = LocalDateTime.now();
        String dir = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String typePart = FileUtils.getTypePart(fileName);
        String substring = fileName.substring(0, fileName.lastIndexOf(typePart));
        return File.separator + dir + File.separator + substring + now.format(DateTimeFormatter.ofPattern("_HHmmssSSS")) + typePart;
    }

    /**
     * 判断文件名是否带盘符，重新处理
     *
     * @param fileName
     * @return
     */
    public static String replaceChar(String fileName) {
        //判断是否带有盘符信息
        // Check for Unix-style path
        int unixSep = fileName.lastIndexOf('/');
        // Check for Windows-style path
        int winSep = fileName.lastIndexOf('\\');
        // Cut off at latest possible point
        int pos = (winSep > unixSep ? winSep : unixSep);
        if (pos != -1) {
            // Any sort of path separator found...
            fileName = fileName.substring(pos + 1);
        }
        //替换上传文件名字的特殊字符
        fileName = fileName.replace("=", "").replace(",", "").replace("&", "").replace("#", "");
        ////替换上传文件名字中的中文
        //if (ifContainChinese(fileName)) {
        //    fileName = PinyinUtil.getPinyin(fileName, StrUtil.EMPTY);
        //}
        //替换上传文件名字中的空格
        fileName = fileName.replaceAll("\\s", "");
        return fileName;
    }

    // java 判断字符串里是否包含中文字符
    public static boolean ifContainChinese(String str) {
        if (str.getBytes().length == str.length()) {
            return false;
        } else {
            Matcher m = ZHONGWEN_PATTERN.matcher(str);
            if (m.find()) {
                return true;
            }
            return false;
        }
    }

    public static String getTypePart(String fileName) {
        int point = fileName.lastIndexOf('.');
        int length = fileName.length();
        if (point == -1 || point == length - 1) {
            return "";
        } else {
            return fileName.substring(point, length);
        }
    }

}