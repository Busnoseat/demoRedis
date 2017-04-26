package com.busnoseat.redis;

import com.busnoseat.redis.common.BaseResponse;
import com.busnoseat.redis.common.UserResponse;
import com.busnoseat.redis.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * redis主从复制: http://blog.csdn.net/ajun_studio/article/details/6714130
 *               http://blog.csdn.net/ajun_studio/article/details/7667746
 *
 * @author xubo
 * @Description:
 * @Date 2017/4/24
 */

@Controller
@RequestMapping("/demo")
public class demoController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public void index() {
        System.out.println("1123344");
    }

    @RequestMapping(value = "/set", method = RequestMethod.GET)
    public
    @ResponseBody BaseResponse set(User user) {
        BaseResponse response = new BaseResponse();
        try {
            Assert.hasLength(user.getName(), "用户姓名不能为空");
            Assert.hasLength(user.getDesc(), "用户描述不能为空");
            RedisUtil.value(user.getName()).set(user.getDesc());
            response.setRespCode("000");
            response.setRespMessage("设置成功");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            response.setRespCode("001");
            response.setRespMessage(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.setRespCode("009");
            response.setRespMessage("redis链接失败");
        }
        return response;
    }

    @RequestMapping(value = "/setEntity", method = RequestMethod.GET)
    public  @ResponseBody  BaseResponse setEntity(User user) {
        BaseResponse response=new BaseResponse();
        try {
            Assert.hasLength(user.getName(), "用户姓名不能为空");
            Assert.hasLength(user.getDesc(), "用户描述不能为空");
            RedisUtil.value(user.getName()).set(user);
            response.setRespCode("000");
            response.setRespMessage("设置成功");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            response.setRespCode("001");
            response.setRespMessage(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.setRespCode("009");
            response.setRespMessage("redis链接失败");
        }
        return response;
    }

    @RequestMapping(value = "/setList", method = RequestMethod.GET)
    public  @ResponseBody  BaseResponse setList(User user) {
        BaseResponse response=new BaseResponse();
        try {
            Assert.hasLength(user.getName(), "用户姓名不能为空");
            Assert.hasLength(user.getDesc(), "用户描述不能为空");
            List<User> list=new ArrayList<>();
            list.add(user);
            RedisUtil.value(user.getName()).set(list);
            response.setRespCode("000");
            response.setRespMessage("设置成功");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            response.setRespCode("001");
            response.setRespMessage(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.setRespCode("009");
            response.setRespMessage("redis链接失败");
        }
        return response;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public  @ResponseBody UserResponse get(User user) {
        UserResponse response=new UserResponse();
        try {
            String name=user.getName();
            Assert.hasLength(name,"用户姓名不能为空");
            Object o = RedisUtil.value(user.getName()).get();
            if(o instanceof String){
                user.setDesc(String.valueOf(o));
                response.setUser(user);
            }else if(o instanceof User){
                Map<String,Object> map=new HashMap<>();
                map.put(name, o);
                response.setUserMap(map);
            }else if(o instanceof List){
                response.setUsers((List<User>) o);
            }
            response.setRespCode("000");
            response.setRespMessage("成功");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            response.setRespCode("001");
            response.setRespMessage(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.setRespCode("009");
            response.setRespMessage("redis链接失败");
        }
        return response;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public  @ResponseBody  BaseResponse remove(User user) {
        BaseResponse response=new BaseResponse();
        try {
            RedisUtil.remove(user.getName());
            response.setRespCode("000");
            response.setRespMessage("移除成功");
        } catch (Exception e) {
            e.printStackTrace();
            response.setRespCode("009");
            response.setRespMessage("redis链接失败");
        }
        return response;
    }
}
