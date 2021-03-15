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
 * <p>CommonStatusEnum class.</p>
 *
 * @author Laysan
 * @version $Id: $Id
 */
@Getter
@AllArgsConstructor
public enum CommonStatusEnum implements BaseEnum {

    /**
     * 正常
     */
    NORMAL(0, "正常"),
    /**
     * 禁用
     */
    DISABLED(1, "禁用");
    /**
     * code
     */
    /**
     * <p>get.</p>
     *
     * @param value a {@link java.lang.Integer} object.
     * @return a {@link com.github.surgeon.enums.CommonStatusEnum} object.
     */
    /**
     * <p>get.</p>
     *
     * @param value a {@link java.lang.Integer} object.
     * @return a {@link com.github.surgeon.enums.CommonStatusEnum} object.
     */
    private Integer value;
    /**
     * desc
     */
    private String  desc;

    public static CommonStatusEnum get(Integer value) {
        if (Objects.isNull(value)) {
            return CommonStatusEnum.DISABLED;
        }
        return Arrays.stream(CommonStatusEnum.values()).filter(item -> item.getValue().equals(value)).findFirst().orElse(
                CommonStatusEnum.DISABLED);
    }
}
