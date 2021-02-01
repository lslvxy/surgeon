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
package com.github.surgeon.exception;

import com.alibaba.cola.exception.BaseException;

/**
 * @author Zheng Jie
 * @date 2018-11-23
 */
public class EntityNotFoundException extends BaseException {

    private static final long   serialVersionUID = 1L;
    private static final String DEFAULT_ERR_CODE = "A0001";
    public EntityNotFoundException( ) {
        super(DEFAULT_ERR_CODE, "对象不存在");
    }
    public EntityNotFoundException(String errMessage) {
        super(DEFAULT_ERR_CODE, errMessage);
    }

    public EntityNotFoundException(String errCode, String errMessage) {
        super(errCode, errMessage);
    }

    public EntityNotFoundException(String errMessage, Throwable e) {
        super(DEFAULT_ERR_CODE, errMessage, e);
    }

    public EntityNotFoundException(String errorCode, String errMessage, Throwable e) {
        super(errorCode, errMessage, e);
    }
}