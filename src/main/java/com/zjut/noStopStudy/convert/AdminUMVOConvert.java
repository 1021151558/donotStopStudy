package com.zjut.noStopStudy.convert;

import com.zjut.noStopStudy.VO.userManagement.AdminUserManagementVO;
import com.zjut.noStopStudy.VO.userManagement.StudentUserManagementVO;
import com.zjut.noStopStudy.model.Admin;
import com.zjut.noStopStudy.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AdminUMVOConvert {

    public static AdminUserManagementVO convert(Admin admin){
        return new AdminUserManagementVO(admin.getName(),admin.getAdminId(),admin.getPhoneNumber());
    }

    public static Page<AdminUserManagementVO> convert(Page<Admin> adminPage){
        List<Admin> admins = adminPage.getContent();
        Iterator it = admins.iterator();
        List<AdminUserManagementVO> adminUserManagementVOS = new ArrayList<>();
        while (it.hasNext()){
            adminUserManagementVOS.add(convert((Admin)it.next()));
        }

        return new PageImpl<>(adminUserManagementVOS);
    }

}
