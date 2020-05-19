package com.zjut.noStopStudy.service.impl;

import com.zjut.noStopStudy.dao.AdminDao;
import com.zjut.noStopStudy.model.Admin;
import com.zjut.noStopStudy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin findByUserId(Integer userId) {
        return adminDao.findByUserId(userId);
    }

    @Override
    public Admin save(Admin admin) {
        return adminDao.save(admin);
    }

    @Override
    public Page<Admin> findAll(Pageable pageable) {
        return adminDao.findAll(pageable);
    }

    @Override
    public Admin findByAdminId(Integer adminId) {
        return adminDao.findById(adminId).get();
    }
}
