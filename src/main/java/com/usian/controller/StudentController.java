package com.usian.controller;

import com.github.pagehelper.PageInfo;
import com.usian.pojo.Student;
import com.usian.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zby
 * @create 2020-10-28 20:05
 */

@Controller
@RequestMapping("student")
public class StudentController {


    @Autowired
    private StudentService studentService;



    @RequestMapping("studentList")
    public String userList(Model model ,Student student, @RequestParam(defaultValue = "1")Integer pageNum,
                           @RequestParam(defaultValue = "3")Integer pageSize,
                           HttpServletResponse response, HttpServletRequest request){
        System.out.println("sdasdasdasdasdasdasdasdasdasd");
        PageInfo<Student> pageInfo = studentService.queryAllStudent(student, pageNum, pageSize);
        model.addAttribute("page",pageInfo);
        model.addAttribute("name",student.getName());
        return "list";
    }

    @RequestMapping("del")
    public  String deleteById(Integer id){
        studentService.deleteStudentByids(id);
        return "redirect:/studentList";
    }
    @RequestMapping("goupdate")
    public  String goupdate(Integer id,Model model){
        Student student = studentService.queryStudentByid(id);
        model.addAttribute("student", student);
        return "update";
    }
    @RequestMapping("goAdd")
    public  String goAdd(){
        return "add";
    }
    @RequestMapping("doAdd")
    public  String doAdd(Student student){
        studentService.addStudent(student);
        return "redirect:/studentList";
    }

}
