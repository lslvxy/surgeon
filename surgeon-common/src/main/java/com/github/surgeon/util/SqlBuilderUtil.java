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
package com.github.surgeon.util;

/**
 * <p>SqlBuilderUtil class.</p>
 *
 * @author lise
 * @version $Id: $Id
 */
public class SqlBuilderUtil {
    /**
     * 模糊查询
     *
     * @param s a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String addWildcards(String s) {
        return "%" + s + "%";
    }

    /**
     * <p>addLeftWildcards.</p>
     *
     * @param s a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String addLeftWildcards(String s) {
        return "%" + s;
    }

    /**
     * <p>addRightWildcards.</p>
     *
     * @param s a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String addRightWildcards(String s) {
        return "%" + s;
    }
}
