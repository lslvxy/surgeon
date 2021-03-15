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

import ch.qos.logback.classic.LoggerContext;
import cn.hutool.json.JSONUtil;
import com.github.surgeon.constant.SurgeonConstants;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.logging.LoggingSystemProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(SurgeonLoggingProperties.class)
public class SurgeonLoggingConfiguration {
    @Autowired
    public SurgeonLoggingConfiguration(Environment environment,
                                       SurgeonLoggingProperties loggingProperties) {
        // 1. 服务名和环境和日志目录
        String appName = environment.getRequiredProperty(SurgeonConstants.SPRING_APP_NAME_KEY);
        String profile = environment.getRequiredProperty(SurgeonConstants.ACTIVE_PROFILES_PROPERTY);
        // 2. 文件日志格式
        String fileLogPattern = environment.resolvePlaceholders(LoggingUtil.DEFAULT_FILE_LOG_PATTERN);
        System.setProperty(LoggingSystemProperties.FILE_LOG_PATTERN, fileLogPattern);
        // 3. 生成日志文件的文件
        String logDir = environment.getProperty("logging.file.path", LoggingUtil.DEFAULT_LOG_DIR);
        String logFile = logDir + '/' + appName + "/all.log";
        String logErrorFile = logDir + '/' + appName + "/error.log";
        // 4. logStash 配置
        SurgeonLoggingProperties.Logstash logStashProperties = loggingProperties.getLogstash();
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        // 4. json 自定义字段
        Map<String, Object> customFields = new HashMap<>();
        customFields.put("appName", appName);
        customFields.put("profile", profile);
        String customFieldsJson = JSONUtil.toJsonStr(customFields);
        // 是否采用 json 格式化
        boolean useJsonFormat = loggingProperties.isUseJsonFormat();
        if (logStashProperties.isEnabled()) {
            LoggingUtil.addLogStashTcpSocketAppender(context, customFieldsJson, logStashProperties);
        } else {
            LoggingUtil.addFileAppender(context, logFile, logErrorFile, useJsonFormat, customFieldsJson);
        }
        if (useJsonFormat || logStashProperties.isEnabled()) {
            LoggingUtil.addContextListener(context, logFile, logErrorFile, customFieldsJson, loggingProperties);
        }
    }

    @Bean
    public LoggingStartedEventListener loggingStartedEventListener(SurgeonLoggingProperties loggingProperties) {
        return new LoggingStartedEventListener(loggingProperties);
    }
}
