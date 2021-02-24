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
package com.github.surgeon.enums;

import com.github.surgeon.base.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * <p>DeleteStatusEnum class.</p>
 *
 * @author lise
 * @version $Id: $Id
 */
@Getter
@AllArgsConstructor
public enum DeleteStatusEnum implements BaseEnum {

    /**
     * 正常
     */
    NORMAL(0, "正常"),
    /**
     * 已删除
     */
    DELETED(1, "已删除");
    /**
     * code
     */
    /**
     * <p>get.</p>
     *
     * @param value a {@link java.lang.Integer} object.
     * @return a {@link com.github.surgeon.enums.DeleteStatusEnum} object.
     */
    /**
     * <p>get.</p>
     *
     * @param value a {@link java.lang.Integer} object.
     * @return a {@link com.github.surgeon.enums.DeleteStatusEnum} object.
     */
    private Integer value;
    /**
     * desc
     */
    private String desc;

    public static DeleteStatusEnum get(Integer value) {
        if (Objects.isNull(value)) {
            return DeleteStatusEnum.NORMAL;
        }
        return Arrays.stream(DeleteStatusEnum.values()).filter(item -> item.getValue().equals(value)).findFirst().orElse(
                DeleteStatusEnum.NORMAL);
    }
}

