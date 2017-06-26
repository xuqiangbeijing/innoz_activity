package com.clouderwork.innoz.api;

import com.clouderwork.innoz.common.CommResult;
import com.clouderwork.innoz.domain.User;
import com.clouderwork.innoz.service.UserService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springside.modules.utils.Identities;
import org.springside.modules.web.MediaTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "user api", description = "用户相关接口")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @ApiOperation(value = "通过用户id查询用户", response = CommResult.class)
    @GetMapping(value = "/api/user/{id}", produces = MediaTypes.JSON_UTF_8)
    public CommResult listOneUser(@PathVariable("id") Integer id) {
        User user = userService.getUser(id);

        if (user == null) {
            String message = "用户不存在(id:" + id + ")";
            logger.warn(message);
            return new CommResult(101, message);
        }

        List list = new ArrayList<User>();
        list.add(user);

        return new CommResult(0, "ok", list);
    }

    @ApiOperation(value = "根据输入条件查询用户（分页显示）", response = CommResult.class)
    @GetMapping(value = "/api/users", produces = MediaTypes.JSON_UTF_8)
    public CommResult listAllUser(@RequestParam(value = "page", defaultValue = "1") int page,
                                  @RequestParam(value = "size", defaultValue = "10") int size,
                                  @RequestParam(value = "username", defaultValue = "") String userName,
                                  @RequestParam(value = "email", defaultValue = "") String email) {
        Map<String, Object> params = Maps.newHashMap();
        if (!StringUtils.isEmpty(userName)) params.put("user_name", userName);
        if (!StringUtils.isEmpty(email)) params.put("email", email);

        return new CommResult(0, "ok", userService.getAllUser(page, size, params));
    }

    @ApiOperation(value = "新增用户", response = CommResult.class)
    @PostMapping(value = "/api/user/save", consumes = MediaTypes.JSON)
    public CommResult saveUser(@Validated @RequestBody User user) {
        //这里生成UUID
        user.setPassword(Identities.uuid2());
        userService.saveUser(user);

        List list = new ArrayList<User>();
        list.add(user);

        return new CommResult(0, "ok", list);
    }

    @ApiOperation(value = "更新用户信息", response = CommResult.class)
    @PostMapping(value = "/api/user/update", consumes = MediaTypes.JSON)
    public CommResult updateUser(@RequestBody User user) {
        userService.updateUser(user);

        List list = new ArrayList<User>();
        list.add(user);

        return new CommResult(0, "ok", list);
    }

    @ApiOperation(value = "根据用户id删除用户", response = CommResult.class)
    @PostMapping(value = "/api/user/delete/{id}")
    public CommResult deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return new CommResult(0, "ok");
    }

    @GetMapping(value = "/api/v2/user/{id}", produces = MediaTypes.JSON_UTF_8)
    public User listOneUser_v2(@PathVariable("id") Integer id) {
        User user = userService.getUser(id);

        if (user == null) {
            String message = "用户不存在(id:" + id + ")";
            logger.warn(message);
            return null;
        }

        return user;
    }
}
