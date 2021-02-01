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
 * 统一异常处理
 */
public class BadRequestException extends BaseException {
    private static final long   serialVersionUID = 1L;
    private static final String DEFAULT_ERR_CODE = "A0001";

    public BadRequestException() {
        super(DEFAULT_ERR_CODE, "请求参数错误");
    }

    public BadRequestException(String errMessage) {
        super(DEFAULT_ERR_CODE, errMessage);
    }

    public BadRequestException(String errCode, String errMessage) {
        super(errCode, errMessage);
    }

    public BadRequestException(String errMessage, Throwable e) {
        super(DEFAULT_ERR_CODE, errMessage, e);
    }

    public BadRequestException(String errorCode, String errMessage, Throwable e) {
        super(errorCode, errMessage, e);
    }
}
