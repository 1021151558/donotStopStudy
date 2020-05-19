package com.zjut.noStopStudy.controller;

import com.zjut.noStopStudy.VO.AjaxResult;
import com.zjut.noStopStudy.VO.classManagement.AddTeacherClassVO;
import com.zjut.noStopStudy.convert.*;
import com.zjut.noStopStudy.model.*;
import com.zjut.noStopStudy.model.modelUtil.CourseTeacherId;
import com.zjut.noStopStudy.model.modelUtil.TeachingSituationId;
import com.zjut.noStopStudy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classManagement")
public class ClassManagementController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseStudentService courseStudentService;

    @Autowired
    private CourseTeacherService courseTeacherService;

    @Autowired
    private TeachingSituationService teachingSituationService;

    @Transactional
    @PostMapping("/admin/addClass")
    public AjaxResult adminAddClass(@RequestBody AddTeacherClassVO addTeacherClassVO) {
        Teacher teacher = teacherService.findByTeacherId(addTeacherClassVO.getTeacherId());
        if (teacher != null) {
            try {
                Course c1 = courseService.findByCourseId(addTeacherClassVO.getCourseId());
                if (c1 == null) {
                    Course course = new Course(addTeacherClassVO.getCourseId(), addTeacherClassVO.getCourseName(), addTeacherClassVO.getDescription());
                    courseService.save(course);
                }
            }catch (Exception e){
                return AjaxResult.error("该课程不存在");
            }

            CourseTeacher courseTeacher = new CourseTeacher(addTeacherClassVO.getCourseId(), addTeacherClassVO.getTeacherId(), addTeacherClassVO.getStartWeek(),
                    addTeacherClassVO.getEndWeek(), addTeacherClassVO.getNumberLimit(), addTeacherClassVO.getNumberReality(), addTeacherClassVO.getStartTerm(), addTeacherClassVO.getTeachingClass());
            courseTeacherService.save(courseTeacher);
            TeachingSituation teachingSituation = new TeachingSituation(addTeacherClassVO.getCourseId(), addTeacherClassVO.getTeacherId(), 1, "良好", 0, addTeacherClassVO.getTeachingClass());
            teachingSituationService.save(teachingSituation);
            return AjaxResult.success("success");
        } else {
            return AjaxResult.error("error");
        }

    }

    @Transactional
    @PostMapping("/teacher/addClass/{userId}")
    public AjaxResult teacherAddClass(@PathVariable("userId") Integer userId, @RequestBody AddTeacherClassVO addTeacherClassVO) {
        Teacher teacher = teacherService.findByUserId(userId);
//        Teacher teacher = teacherService.findByTeacherId(addTeacherClassVO.getTeacherId());
        if (teacher.getTeacherId().equals(addTeacherClassVO.getTeacherId())) {

            return adminAddClass(addTeacherClassVO);
        } else {
            return AjaxResult.error("error");
        }

    }

    @GetMapping("/admin/findAll/{page}/{size}")
    public AjaxResult findAllClass(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {

        PageRequest request = PageRequest.of(page, size);
        Page<CourseTeacher> courseTeacherPage = courseTeacherService.findAll(request);


        return AjaxResult.success("success", CourseTeacherToAddClassVO.convert(courseTeacherPage));
    }

    @GetMapping("/teacher/findAll/{userId}/{page}/{size}")
    public AjaxResult findTeacherClass(@PathVariable("userId") Integer userId, @PathVariable("page") Integer page, @PathVariable("size") Integer size) {

        PageRequest request = PageRequest.of(page, size);
        Page<CourseTeacher> courseTeacherPage = courseTeacherService.findAllByTeacherId(teacherService.findByUserId(userId).getTeacherId(), request);


        return AjaxResult.success(CourseTeacherToAddClassVO.convert(courseTeacherPage));
    }

    @GetMapping("/student/findAll/{userId}/{page}/{size}")
    public AjaxResult findStudentClass(@PathVariable("userId") Integer userId, @PathVariable("page") Integer page, @PathVariable("size") Integer size) {

        PageRequest request = PageRequest.of(page, size);
        Page<CourseStudent> courseStudentPage = courseStudentService.findAllByStudentId(studentService.findByUserId(userId).getStudentId(), request);

        return AjaxResult.success(CourseStudentToCourseStudentVO.convert(courseStudentPage));
    }

    @GetMapping("/student/findAllByCourseId/{courseId}/{page}/{size}")
    public AjaxResult findAllByCourseId(@PathVariable("courseId") Integer courseId, @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest request = PageRequest.of(page, size);
        Page<CourseTeacher> courseTeacherPage = courseTeacherService.findAllByCourseId(courseId, request);

        return AjaxResult.success(CourseTeacherToCourseStudentVO.convert(courseTeacherPage));
    }

    @PostMapping("/student/addClass")
    public AjaxResult studentAddClass(@RequestParam("courseId") Integer courseId, @RequestParam("teachingClass") String teachingClass,@RequestParam("userId") Integer userId) {
        CourseTeacher courseTeacher = courseTeacherService.findByCourseTeacherId(new CourseTeacherId(courseId,teachingClass));

        courseStudentService.save(new CourseStudent(courseId,courseTeacher.getTeacherId(),studentService.findByUserId(userId).getStudentId(),teachingClass));
        return AjaxResult.success("success");
    }

    @GetMapping("/admin/findById/{typeOfClass}/{numberOfUser}/{page}/{size}")
    public AjaxResult findById(@PathVariable("typeOfClass") String typeOfClass, @PathVariable("numberOfUser") Integer numberOfUser, @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest request = PageRequest.of(page, size);
        if (typeOfClass.equals("student")) {
            Page<CourseStudent> courseStudentPage = courseStudentService.findAllByStudentId(numberOfUser, request);
            return AjaxResult.success(CourseStudentToAddTeacherClassVO.convert(courseStudentPage));
        } else if (typeOfClass.equals("teacher")) {
            Page<CourseTeacher> courseTeacherPage = courseTeacherService.findAllByTeacherId(numberOfUser, request);
            return AjaxResult.success(CourseTeacherToAddClassVO.convert(courseTeacherPage));
        }
        return null;
    }

    @GetMapping("/admin/findAllSituation/{page}/{size}")
    public AjaxResult findAllSituation(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest request = PageRequest.of(page, size);
        Page<TeachingSituation> teachingSituationPage = teachingSituationService.findAll(request);
        return AjaxResult.success(TeachingClassToTeachingSituationVO.convert(teachingSituationPage));
    }


    @DeleteMapping("/deleteClass/{courseId}/{teachingClass}")
    public AjaxResult deleteClass(@PathVariable("courseId") Integer courseId, @PathVariable("teachingClass") String teachingClass) {
        Course course = courseService.findByCourseId(courseId);
        if (course != null) {
            teachingSituationService.deleteByTeachingSituationId(new TeachingSituationId(courseId, teachingClass));
            courseTeacherService.deleteByCourseTeacherId(new CourseTeacherId(courseId, teachingClass));
            courseStudentService.deleteAllByCourseIdAndTeachingClass(courseId, teachingClass);
            return AjaxResult.success("success");
        } else {
            return AjaxResult.error("error");
        }
    }
}
