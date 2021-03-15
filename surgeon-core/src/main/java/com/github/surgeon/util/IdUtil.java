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
 * <p>IdUtil class.</p>
 *
 * @author Laysan
 * @version $Id: $Id
 */
public class IdUtil extends cn.hutool.core.util.IdUtil {
    /**
     * <p>getNextId.</p>
     *
     * @return a {@link java.lang.Long} object.
     */
    public static Long getNextId() {
        return getSnowflake(1, 1).nextId();
    }

    /**
     * <p>getNextIdStr.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public static String getNextIdStr() {
        return getSnowflake(1, 1).nextIdStr();
    }
}
