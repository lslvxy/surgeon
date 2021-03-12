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

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Ticker;
import com.github.surgeon.config.CacheNameProperties.CacheSpec;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.DurationStyle;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Swagger2配置
 *
 * @author L.cm
 */
@Slf4j
@Data
@EnableCaching
@Configuration
@EnableConfigurationProperties(value = {CacheProperties.class, CacheNameProperties.class})
@ConditionalOnMissingBean(CacheManager.class)
@ConditionalOnClass({Caffeine.class, CaffeineCacheManager.class})
@ConditionalOnProperty(value = "spring.cache.type", havingValue = "caffeine", matchIfMissing = true)
public class CaffeineCacheAutoConfiguration {

    @Bean
    public CacheManager cacheManager(CacheNameProperties cacheNameProperties, Ticker ticker) {
        SimpleCacheManager manager = new SimpleCacheManager();
        Map<String, CacheSpec> specs = cacheNameProperties.getSpecs();
        if (Objects.isNull(specs)) {
            specs = new HashMap<>(1);
            specs.put("surgeonCache", new CacheSpec());
        }
        List<CaffeineCache> caches =
                specs.entrySet().stream()
                        .map(entry -> buildCache(entry.getKey(),
                                entry.getValue(),
                                ticker))
                        .collect(Collectors.toList());
        manager.setCaches(caches);
        return manager;
    }

    private CaffeineCache buildCache(String name, CacheSpec cacheSpec, Ticker ticker) {
        Duration duration = DurationStyle.detectAndParse(cacheSpec.getTimeout(), ChronoUnit.SECONDS);
        log.info("Cache {} specified timeout of {}, max of {}", name, duration.toString().replace("PT", ""), cacheSpec.getMax());
        final Caffeine<Object, Object> caffeineBuilder
                = Caffeine.newBuilder()
                .expireAfterWrite(duration)
                .maximumSize(cacheSpec.getMax())
                .ticker(ticker);
        return new CaffeineCache(name, caffeineBuilder.build());
    }

    @Bean
    public Ticker ticker() {
        return Ticker.systemTicker();
    }

}
