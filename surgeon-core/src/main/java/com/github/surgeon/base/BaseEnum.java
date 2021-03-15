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
package com.github.surgeon.base;

/**
 * <p>BaseEnum interface.</p>
 *
 * @author Laysan
 * @version $Id: $Id
 */
public interface BaseEnum {
    /**
     * <p>getValue.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    Integer getValue();

    /**
     * <p>getDesc.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    String getDesc();

    /**
     * <p>NullEnum.</p>
     *
     * @return a {@link com.github.surgeon.base.BaseEnum} object.
     */
    static BaseEnum NullEnum() {
        return new BaseEnum() {
            @Override
            public Integer getValue() {
                return null;
            }

            @Override
            public String getDesc() {
                return null;
            }
        };
    }
}
