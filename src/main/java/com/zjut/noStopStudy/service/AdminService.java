package com.zjut.noStopStudy.service;

import com.zjut.noStopStudy.model.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminService {

    Admin findByUserId(Integer userId);

    Admin save(Admin admin);

    Page<Admin> findAll(Pageable pageable);

    Admin findByAdminId(Integer adminId);
}
