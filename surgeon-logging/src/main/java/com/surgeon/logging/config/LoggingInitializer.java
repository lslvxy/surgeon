package com.surgeon.logging.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

public class LoggingInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {
    @Override
    public void initialize(ConfigurableApplicationContext context) {
        ConfigurableEnvironment environment = context.getEnvironment();
        // 读取系统配置的日志目录，默认为项目下 logs
        String logBase = environment.getProperty("logging.file.path", LoggingUtil.DEFAULT_LOG_DIR);
        // 用于 spring boot admin 中展示日志
        System.setProperty("logging.file.name", logBase + "/${spring.application.name}/all.log");
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
