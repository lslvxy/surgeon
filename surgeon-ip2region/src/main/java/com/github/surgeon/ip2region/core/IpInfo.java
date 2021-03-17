/*
 * Copyright (c) 2019-2029, Dreamlu 卢春梦 (596392912@qq.com & www.dreamlu.net).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.surgeon.ip2region.core;

import cn.hutool.core.util.StrUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * ip 信息详情
 *
 * @author Laysan
 */
@Data
public class IpInfo implements Serializable {

    /**
     * 城市id
     */
    private Integer cityId;
    /**
     * 国家
     */
    private String  country;
    /**
     * 区域
     */
    private String  region;
    /**
     * 省
     */
    private String  province;
    /**
     * 城市
     */
    private String  city;
    /**
     * 运营商
     */
    private String  isp;
    /**
     * region ptr in the db file
     */
    private int     dataPtr;

    /**
     * 拼接完整的地址
     *
     * @return address
     */
    public String getAddress() {
        Set<String> regionSet = new LinkedHashSet<>();
        regionSet.add(country);
        regionSet.add(region);
        regionSet.add(province);
        regionSet.add(city);
        regionSet.removeIf(Objects::isNull);
        return StrUtil.join("", regionSet);
    }

    /**
     * 拼接完整的地址
     *
     * @return address
     */
    public String getAddressAndIsp() {
        Set<String> regionSet = new LinkedHashSet<>();
        regionSet.add(country);
        regionSet.add(region);
        regionSet.add(province);
        regionSet.add(city);
        regionSet.add(isp);
        regionSet.removeIf(Objects::isNull);
        return StrUtil.join(" ", regionSet);
    }
}
