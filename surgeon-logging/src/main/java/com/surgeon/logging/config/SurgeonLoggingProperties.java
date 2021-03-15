package com.surgeon.logging.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("surgeon.logging")
public class SurgeonLoggingProperties {

    /**
     * 使用 json 格式化
     */
    private       boolean  useJsonFormat = false;
    private final Console  console       = new Console();
    private final Logstash logstash      = new Logstash();

    @Getter
    @Setter
    public static class Console {
        /**
         * 是否启动完成后关闭控制台日志，适用于，正式环境
         */
        private boolean closeAfterStart = false;
    }

    @Getter
    @Setter
    public static class Logstash {
        /**
         * 是否开启 logstash 日志收集
         */
        private boolean enabled   = false;
        /**
         * logstash host
         */
        private String  host      = "localhost";
        /**
         * logstash port
         */
        private int     port      = 5000;
        /**
         * logstash 队列大小
         */
        private int     queueSize = 512;
    }
}
