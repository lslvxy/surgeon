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
package com.github.surgeon.config;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.exception.BizException;
import com.alibaba.cola.exception.SysException;
import com.github.surgeon.constant.SurgeonConstants;
import com.github.surgeon.util.ThrowableUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Objects;

/**
 * @author Laysan
 * @date 2018-11-23
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * BizException
     */
    @ExceptionHandler(value = {ConstraintViolationException.class})
    public Response constraintViolationException(ConstraintViolationException e) {
        log.error(ThrowableUtil.getStackTrace(e));
        return buildResponseEntity("验证异常," + e.getMessage().replaceAll("\\S*: ", ""));
    }

    @ExceptionHandler(value = {BizException.class})
    public Response bizException(BizException e) {
        log.error(ThrowableUtil.getStackTrace(e));
        return buildResponseEntity("业务异常," + e.getMessage());
    }

    /**
     * 处理 SysException
     */
    @ExceptionHandler(value = SysException.class)
    public Response sysException(SysException e) {
        log.error(ThrowableUtil.getStackTrace(e));
        return buildResponseEntity("系统异常," + e.getMessage());
    }


    /**
     * 处理所有接口数据验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(ThrowableUtil.getStackTrace(e));
        String[] str = Objects.requireNonNull(e.getBindingResult().getAllErrors().get(0).getCodes())[1].split("\\.");
        String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        String msg = "不能为空";
        if (msg.equals(message)) {
            message = str[1] + ":" + message;
        }
        return buildResponseEntity((message));
    }

    /**
     * 处理所有不可知的异常
     */
    @ExceptionHandler(Throwable.class)
    public Response handleException(Throwable e) {
        log.error(ThrowableUtil.getStackTrace(e));
        return buildResponseEntity("系统发生异常");
    }

    /**
     * 统一返回
     */
    private Response buildResponseEntity(String msg) {
        return Response.buildFailure(SurgeonConstants.DEFAULT_ERROR_CODR, msg);
    }
}
