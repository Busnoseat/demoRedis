package com.busnoseat.redis.common;

import com.busnoseat.redis.entity.User;

import java.util.List;
import java.util.Map;

/**
 * The type UserResponse.
 *
 * @author xubo
 * @Description:
 * @Date 2017/4/25
 */
public class UserResponse extends  BaseResponse {
    private User user;
    private List<User> users;
    private Map<String,Object> userMap;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Map<String, Object> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, Object> userMap) {
        this.userMap = userMap;
    }
}
