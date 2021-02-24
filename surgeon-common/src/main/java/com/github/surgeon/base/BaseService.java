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
package com.github.surgeon.base;

import java.util.Map;

public interface BaseService {
    /**
     * Checks whether or not a given value exists for a given field
     *
     * @param fieldMap k The name of the field for which to check if the value exists
     * @param fieldMap v  The value to check for
     * @return True if the value exists for the field; false otherwise
     * @throws UnsupportedOperationException
     */
    default boolean fieldValueExists(Map<String, Object> fieldMap, Object id) throws UnsupportedOperationException {
        return false;
    }


}
