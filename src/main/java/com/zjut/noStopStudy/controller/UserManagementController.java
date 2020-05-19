package com.zjut.noStopStudy.controller;

import com.zjut.noStopStudy.VO.AjaxResult;
import com.zjut.noStopStudy.VO.userManagement.AdminUserManagementVO;
import com.zjut.noStopStudy.VO.userManagement.StudentUserManagementVO;
import com.zjut.noStopStudy.VO.userManagement.TeacherUserManagementVO;
import com.zjut.noStopStudy.convert.AdminUMVOConvert;
import com.zjut.noStopStudy.convert.StudentUMVOConvert;
import com.zjut.noStopStudy.convert.TeacherUMVOConvert;
import com.zjut.noStopStudy.model.Admin;
import com.zjut.noStopStudy.model.Student;
import com.zjut.noStopStudy.model.Teacher;
import com.zjut.noStopStudy.service.AdminService;
import com.zjut.noStopStudy.service.StudentService;
import com.zjut.noStopStudy.service.TeacherService;
import com.zjut.noStopStudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userManagement")
public class UserManagementController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;


    @GetMapping("/teacher/findAll/{page}/{size}")
    public AjaxResult findAllTeacher(@PathVariable("page") Integer page, @PathVariable("size") Integer size){

        PageRequest request = PageRequest.of(page,size);
        Page<Teacher> teacherPage = teacherService.findAll(request);

        return AjaxResult.success(TeacherUMVOConvert.convert(teacherPage));
    }

    @GetMapping("/admin/findAll/{page}/{size}")
    public AjaxResult findAllAdmin(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return AjaxResult.success(AdminUMVOConvert.convert(adminService.findAll(request)));
    }

    @GetMapping("/student/findAll/{page}/{size}")
    public AjaxResult findAllStudent(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return AjaxResult.success(StudentUMVOConvert.convert(studentService.findAll(request)));
    }

    @PutMapping("/teacher/update")
    @Transactional
    public AjaxResult teacherInfoUpdate(@RequestBody TeacherUserManagementVO teacherUserManagementVO){
        Teacher teacher = teacherService.findByTeacherId(teacherUserManagementVO.getTeacherId());
        teacher.setName(teacherUserManagementVO.getName());
        teacher.setPhoneNumber(teacherUserManagementVO.getPhoneNumber());
        teacherService.save(teacher);
        return  AjaxResult.success("success");
    }

    @PutMapping("/admin/update")
    @Transactional
    public AjaxResult adminInfoUpdate(@RequestBody AdminUserManagementVO adminUserManagementVO){
        Admin admin = adminService.findByAdminId(adminUserManagementVO.getAdminId());
        admin.setName(adminUserManagementVO.getName());
        admin.setPhoneNumber(adminUserManagementVO.getPhoneNumber());
        adminService.save(admin);
        return  AjaxResult.success("success");
    }

    @PutMapping("/student/update")
    @Transactional
    public AjaxResult studentInfoUpdate(@RequestBody StudentUserManagementVO studentUserManagementVO){
        Student student = studentService.findByStudentId(studentUserManagementVO.getStudentId());
        student.setName(studentUserManagementVO.getName());
        student.setPhoneNumber(studentUserManagementVO.getPhoneNumber());
        studentService.save(student);
        return  AjaxResult.success("success");
    }

    @DeleteMapping("/teacher/deleteById")
    @Transactional
    public AjaxResult deleteTeacherById(@RequestParam("id") Integer id){
        Integer userId = teacherService.findByTeacherId(id).getUserId();
        teacherService.deleteByTeacherId(id);
        userService.deleteByUserId(userId);
        return AjaxResult.success("success");
    }

    @DeleteMapping("/student/deleteById")
    @Transactional
    public AjaxResult deleteStudentById(@RequestParam("id") Integer id){
       Integer userId = studentService.findByStudentId(id).getUserId();
        studentService.deleteByStudentId(id);
        userService.deleteByUserId(userId);
        return AjaxResult.success("success");
    }

}
