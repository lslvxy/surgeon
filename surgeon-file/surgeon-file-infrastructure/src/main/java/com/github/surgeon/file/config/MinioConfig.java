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
package com.github.surgeon.file.config;

import com.github.surgeon.property.file.MinioProperties;
import io.minio.MinioClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@ConditionalOnProperty(name = "surgeon.file.provider", havingValue = "minio")
public class MinioConfig {
    @Resource
    private MinioProperties minioProperties;

    /**
     * 获取 MinioClient
     *
     * @return
     */
    @Bean
    public MinioClient minioClient() throws Exception {
        MinioClient minioClient = new MinioClient(minioProperties.getEndpoint(), minioProperties.getAccessKey(),
                minioProperties.getSecretKey());
        // 检查存储桶是否已经存在
        boolean isExist = minioClient.bucketExists(minioProperties.getBucket());
        if (!isExist) {
            minioClient.makeBucket(minioProperties.getBucket());
        }
        return minioClient;
    }
}
