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
package com.github.surgeon.config;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.github.surgeon.annotation.Dict;
import com.github.surgeon.base.BaseEnum;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

public class DictSerializer extends JsonSerializer<Object> {

    private Dict annotation;

    public DictSerializer(Dict annotation) {
        this.annotation = annotation;
    }

    @Override
    public void serialize(Object value, JsonGenerator jsonGenerator,
                          SerializerProvider provider) throws IOException {
        String name = jsonGenerator.getOutputContext().getCurrentName();
        if (Objects.isNull(value)) {
            jsonGenerator.writeNull();
            jsonGenerator.writeStringField(name + "Desc", null);
        } else {
            jsonGenerator.writeString(value.toString());

            //enum
            Class clazz = annotation.clazz();
            if (!Objects.equals(clazz, Void.class)) {
                BaseEnum[] enumConstants = (BaseEnum[]) clazz.getEnumConstants();
                jsonGenerator.writeStringField(name + "Desc", getEnumByCode(enumConstants, value.toString()).getDesc());
            } else {
                //dict
                String code = annotation.code();
                if (StrUtil.isNotBlank(code)) {
                    Object gateway = SpringContextHolder.getBean("dictDetailGateway");
                    try {
                        Method m = gateway.getClass().getDeclaredMethod("findByDictCode", String.class, String.class);
                        Object invoke = m.invoke(gateway, code, value.toString());
                        if (Objects.isNull(invoke)) {
                            jsonGenerator.writeStringField(name + "Desc", null);
                        } else {
                            String s = invoke.toString();
                            String str = JSONUtil.parseObj(s).getStr("text");
                            jsonGenerator.writeStringField(name + "Desc", str);
                        }
                    } catch (Exception e) {
                        jsonGenerator.writeStringField(name + "Desc", null);
                    }
                }
            }

        }

    }

    private BaseEnum getEnumByCode(BaseEnum[] enumConstants, String code) {
        return Arrays.stream(enumConstants).filter(enumConstant -> Objects.equals(enumConstant.getValue().toString(), code)).findFirst().orElse(BaseEnum.NullEnum());
    }
}