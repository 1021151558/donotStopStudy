package com.zjut.noStopStudy.service.impl;

import com.zjut.noStopStudy.dao.UserDao;
import com.zjut.noStopStudy.enums.RegisterEnum;
import com.zjut.noStopStudy.exception.RegisterException;
import com.zjut.noStopStudy.model.User;
import com.zjut.noStopStudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public User findByUserNameAndPassword(String userName, String password) {
        return userDao.findByUserNameAndPassword(userName,password);
    }

    @Override
    public User findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    @Override
    public User findByType(String type) {
        return userDao.findByType(type);
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id).get();
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void delete(User user) {
        try {
            userDao.delete(user);
        }catch (RegisterException registerException){
            throw new RegisterException(RegisterEnum.DELETE_FALL);
        }

    }

    @Override
    public void deleteByUserId(Integer id) {
        try {
            userDao.deleteById(id);
        }catch (RegisterException registerException){
            throw new RegisterException(RegisterEnum.DELETE_FALL);
        }
    }
}
