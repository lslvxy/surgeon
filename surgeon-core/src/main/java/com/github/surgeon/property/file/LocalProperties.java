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
package com.github.surgeon.property.file;

import com.github.surgeon.constant.SurgeonConstants;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@EqualsAndHashCode
@Component
@ConfigurationProperties(prefix = "surgeon.file.local")
public class LocalProperties {
    private FilePath mac;

    private FilePath linux;

    private FilePath windows;

    public String getPath() {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith(SurgeonConstants.WIN)) {
            return windows.getPath();
        } else if (os.toLowerCase().startsWith(SurgeonConstants.MAC)) {
            return mac.getPath();
        }
        return linux.getPath();
    }

    @Getter
    @Setter
    public static class FilePath {
        private String path;
    }
}
