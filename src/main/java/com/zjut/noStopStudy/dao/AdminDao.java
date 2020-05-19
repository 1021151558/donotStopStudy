package com.zjut.noStopStudy.dao;

import com.zjut.noStopStudy.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin,Integer> {
    Admin findByUserId(Integer userId);
}
