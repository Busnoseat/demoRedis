package com.busnoseat.redis.entity;

import java.io.Serializable;

/**
 * The type User.
 *
 * @author xubo
 * @Description:
 * @Date 2017/4/24
 */
public class User implements Serializable {

    private static final long serialVersionUID = -3766780183428993793L;
    private String name;
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
