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
package com.github.surgeon.base;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 通用字段， is_del 根据需求自行添加
 *
 * @author Laysan
 * @version $Id: $Id
 * @Date 2019年10月24日20:46:32
 */
@ToString
public class BaseDO implements Serializable {

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * <p>Getter for the field <code>createBy</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * <p>Setter for the field <code>createBy</code>.</p>
     *
     * @param createBy a {@link java.lang.String} object.
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * <p>Getter for the field <code>updateBy</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * <p>Setter for the field <code>updateBy</code>.</p>
     *
     * @param updateBy a {@link java.lang.String} object.
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * <p>Getter for the field <code>createTime</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * <p>Setter for the field <code>createTime</code>.</p>
     *
     * @param createTime a {@link java.util.Date} object.
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * <p>Getter for the field <code>updateTime</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * <p>Setter for the field <code>updateTime</code>.</p>
     *
     * @param updateTime a {@link java.util.Date} object.
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
