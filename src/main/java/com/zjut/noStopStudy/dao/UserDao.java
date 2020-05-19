package com.zjut.noStopStudy.dao;

import com.zjut.noStopStudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    User findByUserNameAndPassword(String userName,String password);
    User findByUserName(String userName);
    User findByType(String type);
//    User findByName(String name);
}
