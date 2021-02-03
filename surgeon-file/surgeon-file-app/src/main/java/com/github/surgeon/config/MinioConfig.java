/*
 * Copyright © ${project.inceptionYear} Laysan (lslvxy@gmail.com)
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

import io.minio.MinioClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@EnableConfigurationProperties({MinioProp.class})
@ConditionalOnProperty(name = "surgeon.file.provider", havingValue = "minio")
public class MinioConfig {
    @Resource
    private MinioProp minioProp;

    /**
     * 获取 MinioClient
     *
     * @return
     */
    @Bean
    public MinioClient minioClient() throws Exception {
        MinioClient minioClient = new MinioClient(minioProp.getEndpoint(), minioProp.getAccessKey(), minioProp.getSecretKey());
        // 检查存储桶是否已经存在
        boolean isExist = minioClient.bucketExists(minioProp.getBucket());
        if (!isExist) {
            minioClient.makeBucket(minioProp.getBucket());
        }
        return minioClient;
    }
}
