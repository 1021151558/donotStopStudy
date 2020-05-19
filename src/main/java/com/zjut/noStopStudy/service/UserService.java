package com.zjut.noStopStudy.service;

import com.zjut.noStopStudy.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findByUserNameAndPassword(String userName, String password);
    User findByUserName(String userName);
    User findByType(String type);
    User findById(Integer id);
    User save(User user);
    List<User> findAll();
    void delete(User userEntity);
    void deleteByUserId(Integer id);
}
