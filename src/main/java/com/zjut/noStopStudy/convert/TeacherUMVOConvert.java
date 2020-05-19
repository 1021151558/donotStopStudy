package com.zjut.noStopStudy.convert;

import com.zjut.noStopStudy.VO.userManagement.TeacherUserManagementVO;
import com.zjut.noStopStudy.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TeacherUMVOConvert {

    public static TeacherUserManagementVO convert(Teacher teacher){
        return new TeacherUserManagementVO(teacher.getName(),teacher.getTeacherId(),teacher.getPhoneNumber());
    }

    public static Page<TeacherUserManagementVO> convert(Page<Teacher> teacherPage){
        List<Teacher> teachers = teacherPage.getContent();
        Iterator it = teachers.iterator();
        List<TeacherUserManagementVO> teacherUserManagementVOS = new ArrayList<>();
        while (it.hasNext()){
            teacherUserManagementVOS.add(convert((Teacher)it.next()));
        }

        return new PageImpl<>(teacherUserManagementVOS);
    }
}
