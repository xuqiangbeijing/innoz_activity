package com.clouderwork.innoz.service;

import com.clouderwork.innoz.domain.User;
import com.clouderwork.innoz.repository.UserMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Transactional(readOnly = true)
    public User getUser(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
    public List<User> getAllUser(int page, int size, Map<String, Object> params) {
        PageHelper.startPage(page, size);
        return userMapper.selectAllUser(params);
    }

    @Transactional
    public void saveUser(User user) {
        userMapper.insertSelective(user);
    }

    @Transactional
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Transactional
    public void deleteUser(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }
}
