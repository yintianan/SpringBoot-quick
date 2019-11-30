package com.example.springboot_quick2.controller;

import com.example.springboot_quick2.model.StudentInfo;
import com.example.springboot_quick2.model.SubjectInfo;
import com.example.springboot_quick2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MapperController {
    @Autowired
    private StudentService StudentService;

    @RequestMapping("/Subject")
    @ResponseBody
    public List<SubjectInfo> querySubjectList(){
        List<SubjectInfo> list= StudentService.querySubjectList();
        return list;
    }

    @RequestMapping("/Student")
    @ResponseBody
    public List<StudentInfo> queryStudentLsit(){
        List<StudentInfo> list =StudentService.queryStudentList();
        return  list;
    }

    @RequestMapping(value = "/Student", method = RequestMethod.GET)
    @ResponseBody
    public StudentInfo findStudentById(@RequestParam("id") int id){
        StudentInfo studentInfo=StudentService.findStudentById(id);
        return  studentInfo;
    }


}
