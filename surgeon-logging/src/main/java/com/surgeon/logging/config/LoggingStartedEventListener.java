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