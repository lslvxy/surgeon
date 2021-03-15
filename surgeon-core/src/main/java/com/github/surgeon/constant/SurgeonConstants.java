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
package com.github.surgeon.constant;

/**
 * 系统级常量
 *
 * @author lise
 * @version $Id: $Id
 */
public interface SurgeonConstants {
    /**
     * Constant <code>DATE_YYYY_MM_DD="yyyy-MM-dd"</code>
     */
    String DATE_YYYY_MM_DD          = "yyyy-MM-dd";
    /**
     * Constant <code>DATE_YYYY_MM_DD_HH_MM_SS="yyyy-MM-dd HH:mm:ss"</code>
     */
    String DATE_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    /**
     * length must ==32
     */
    String JWT_CLIENT_SECRET        = "Seal@202012221120*&^%$@!!@#$%^&*";

    String SPRING_APP_NAME_KEY = "spring.application.name";

    String ACTIVE_PROFILES_PROPERTY = "spring.profiles.active";

    /**
     * Constant <code>DEFAULT_PASSWORD="123456"</code>
     */
    String DEFAULT_PASSWORD = "123456";

    /**
     * Constant <code>DEFAULT_ERROR_CODR="B0001"</code>
     */
    String DEFAULT_ERROR_CODR = "B0001";

    /**
     * 用于IP定位转换
     */
    String REGION = "内网IP|内网IP";
    /**
     * win 系统
     */
    String WIN    = "win";

    /**
     * mac 系统
     */
    String MAC = "mac";

    /**
     * IP归属地查询
     */
    String IP_URL = "http://whois.pconline.com.cn/ipJson.jsp?ip=%s&json=true";
}

