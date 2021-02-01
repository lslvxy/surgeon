package com.github.surgeon.config;

import com.github.surgeon.constant.KamalaConstants;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "kamala.file.local")
public class LocalProp {
    private ElPath mac;

    private ElPath linux;

    private ElPath windows;

    public String getPath() {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith(KamalaConstants.WIN)) {
            return windows.getPath();
        } else if (os.toLowerCase().startsWith(KamalaConstants.MAC)) {
            return mac.getPath();
        }
        return linux.getPath();
    }

    @Data
    public static class ElPath {
        private String path;
    }
}
