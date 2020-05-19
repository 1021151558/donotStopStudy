package com.zjut.noStopStudy.controller;

import com.zjut.noStopStudy.VO.AjaxResult;
import com.zjut.noStopStudy.VO.login.PasswordUpVO;
import com.zjut.noStopStudy.VO.login.RegisterVO;
import com.zjut.noStopStudy.VO.login.LoginVO;
import com.zjut.noStopStudy.enums.RegisterEnum;
import com.zjut.noStopStudy.exception.RegisterException;
import com.zjut.noStopStudy.model.Admin;
import com.zjut.noStopStudy.model.Student;
import com.zjut.noStopStudy.model.Teacher;
import com.zjut.noStopStudy.model.User;
import com.zjut.noStopStudy.security.JwtUtil;
import com.zjut.noStopStudy.service.AdminService;
import com.zjut.noStopStudy.service.StudentService;
import com.zjut.noStopStudy.service.TeacherService;
import com.zjut.noStopStudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserLoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private AdminService adminService;



    @PostMapping(value = "/userLogin")
    public AjaxResult userLogin(@RequestBody LoginVO loginVO) {

//        System.out.println("userLogin");
        User userEntity = userService.findByUserNameAndPassword(loginVO.getUserName(), loginVO.getPassword());

        if(userEntity!=null){
            AjaxResult ajax = AjaxResult.success();
            // 生成令牌
            String role = userEntity.getType();
            if(role.equals("admin")){
               ajax.put("name",adminService.findByUserId(userEntity.getId()).getName());
            }else if(role.equals("teacher")){
                ajax.put("name",teacherService.findByUserId(userEntity.getId()).getName());
            }else{
                ajax.put("name",studentService.findByUserId(userEntity.getId()).getName());
            }

            String token = JwtUtil.sign(loginVO.getUserName(), userService.findByUserName(loginVO.getUserName()).getId());
            System.out.println("token"+token);
            ajax.put("token", token);
            ajax.put("role",role);
            ajax.put("userId",userEntity.getId());
            return ajax;
        }else{
            AjaxResult ajax = AjaxResult.error("用户不存在");
            return ajax;
        }

    }



    @Transactional
    @RequestMapping(value = "/addRegister", method = RequestMethod.POST)
    public AjaxResult register(@RequestBody RegisterVO registerVO) {
        if(userService.findByUserName(registerVO.getUserName()) == null){
            if (registerVO.getPassword().equals(registerVO.getCfPassword())) {
                if(registerVO.getTypeOfUser().equals("admin") ){
                    User user = new User(registerVO.getUserName(),registerVO.getPassword(),registerVO.getTypeOfUser());
                    userService.save(user);
                    Admin admin = new Admin(user.getId(),Integer.valueOf(registerVO.getNumberOfUser()),registerVO.getName(),registerVO.getSex(),
                            registerVO.getInstitute(),registerVO.getNativePlace(),registerVO.getPhoneNumber());

                    adminService.save(admin);

                    AjaxResult ajax = AjaxResult.success("管理员账户注册成功！");
                    return ajax;
                }else if(registerVO.getTypeOfUser().equals("teacher")){
                    User user = new User(registerVO.getUserName(),registerVO.getPassword(),registerVO.getTypeOfUser());
                    userService.save(user);

                    Teacher teacher = new Teacher(user.getId(),Integer.valueOf(registerVO.getNumberOfUser()),registerVO.getName(),registerVO.getSex(),
                            registerVO.getInstitute(),registerVO.getNativePlace(),registerVO.getPhoneNumber());
                    System.out.println(teacher);
                    teacherService.save(teacher);

                    AjaxResult ajax = AjaxResult.success("教师账户注册成功！");
                    return ajax;

                }else if(registerVO.getTypeOfUser().equals("student")){
                    User user = new User(registerVO.getUserName(),registerVO.getPassword(),registerVO.getTypeOfUser());
                    userService.save(user);

                    Student student = new Student(user.getId(),Integer.valueOf(registerVO.getNumberOfUser()),registerVO.getName(),registerVO.getSex(),
                            registerVO.getInstitute(),registerVO.getNativePlace(),registerVO.getPhoneNumber());
                    studentService.save(student);

                    AjaxResult ajax = AjaxResult.success("学生账户注册成功！");
                    return ajax;

                }
//                map.addAttribute("CZ","该用户已存在");
                AjaxResult ajax = AjaxResult.error("该用户已存在");
                return ajax;

            } else {
                throw new RegisterException(RegisterEnum.FAIL);
//                return "register";

            }
        }else {
            AjaxResult ajax = AjaxResult.error("该用户已存在");
            return ajax;
//            throw new RegisterException(RegisterEnum.FAIL);
        }
    }

    @RequestMapping(value = "/passwordUpdate",method = RequestMethod.PUT)
    public AjaxResult passwordUpdate(@RequestBody PasswordUpVO passwordUpVO){

        User userEntity = userService.findByUserNameAndPassword(passwordUpVO.getUserName(), passwordUpVO.getPassword());

        if(userEntity!=null && passwordUpVO.getNewPassword().equals(passwordUpVO.getCheckNewPassword())){
            userEntity.setPassword(passwordUpVO.getNewPassword());
            userService.save(userEntity);
            AjaxResult ajax = AjaxResult.success("success");
            return ajax;
        }else {
            AjaxResult ajax = AjaxResult.error("账号密码错误");
            return ajax;
        }
    }

}
