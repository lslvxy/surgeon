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
package com.surgeon.logging.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

@RequiredArgsConstructor
public class LoggingStartedEventListener {
    private final SurgeonLoggingProperties properties;

    @Async
    @Order
    @EventListener(WebServerInitializedEvent.class)
    public void afterStart() {
        // 1. 关闭控制台
        SurgeonLoggingProperties.Console console = properties.getConsole();
        if (console.isCloseAfterStart()) {
            LoggingUtil.detachAppender(LoggingUtil.CONSOLE_APPENDER_NAME);
        }
    }
}