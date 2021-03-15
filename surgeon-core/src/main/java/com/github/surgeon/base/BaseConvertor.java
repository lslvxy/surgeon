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

import java.util.Collection;
import java.util.List;

/**
 * <p>BaseConvertor interface.</p>
 *
 * @author Laysan
 * @version $Id: $Id
 * @date 2018-11-23
 */
public interface BaseConvertor<S, T> {

    /**
     * DTO转Entity
     *
     * @param s /
     * @return /
     */
    T toTarget(S s);

    /**
     * Entity转DTO
     *
     * @param t /
     * @return /
     */
    S toSource(T t);

    /**
     * DTO集合转Entity集合
     *
     * @param sourceList /
     * @return /
     */
    List<T> toTarget(Collection<S> sourceList);

    /**
     * Entity集合转DTO集合
     *
     * @param targetList /
     * @return /
     */
    List<S> toSource(Collection<T> targetList);
}
