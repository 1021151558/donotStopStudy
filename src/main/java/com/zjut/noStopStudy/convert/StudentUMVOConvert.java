package com.zjut.noStopStudy.convert;

import com.zjut.noStopStudy.VO.userManagement.StudentUserManagementVO;
import com.zjut.noStopStudy.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentUMVOConvert {

    public static StudentUserManagementVO convert(Student student){
        return new StudentUserManagementVO(student.getName(),student.getStudentId(),student.getPhoneNumber());
    }

    public static Page<StudentUserManagementVO> convert(Page<Student> studentPage){
        List<Student> students = studentPage.getContent();
        Iterator it = students.iterator();
        List<StudentUserManagementVO> studentUserManagementVOS = new ArrayList<>();
        while (it.hasNext()) {
            studentUserManagementVOS.add(convert((Student) it.next()));
        }
        return new PageImpl<>(studentUserManagementVOS);
    }
}
