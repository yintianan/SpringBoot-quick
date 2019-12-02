package com.example.springboot_quick2.controller;

import com.example.springboot_quick2.model.AllStudentInfo;
import com.example.springboot_quick2.model.StudentInfo;
import com.example.springboot_quick2.model.StudentScore;
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
    public List<SubjectInfo> querySubjectList() {
        List<SubjectInfo> list = StudentService.querySubjectList();
        return list;
    }

    @RequestMapping("/Student")
    @ResponseBody
    public List<StudentInfo> queryStudentList() {
        List<StudentInfo> list = StudentService.queryStudentList();
        return list;
    }

    @RequestMapping(value = "/Student", method = RequestMethod.GET)
    @ResponseBody
    public StudentInfo findStudentById(@RequestParam("id") int id) {
        StudentInfo studentInfo = StudentService.findStudentById(id);
        return studentInfo;
    }

    @RequestMapping(value = "/findStudentByStudentNo", method = RequestMethod.GET)
    @ResponseBody
    public StudentInfo findStudentByStudentNo(@RequestParam("studentNo") String studentNo) {
        StudentInfo studentInfo =StudentService.findStudentByStudentNo(studentNo);
        return studentInfo;
    }

    @RequestMapping("/Score")
    @ResponseBody
    public List<StudentScore> queryScore() {
        List<StudentScore> list = StudentService.queryScore();
        return list;
    }

    @RequestMapping(value = "/queryScoreById", method = RequestMethod.GET)
    @ResponseBody
    public StudentScore queryScoreById(@RequestParam("id") int scoreid) {
        StudentScore studentScore = StudentService.queryScoreById(scoreid);
        return studentScore;
    }

    @RequestMapping(value = "/queryAllInfoByScoreId", method = RequestMethod.GET)
    @ResponseBody
    public AllStudentInfo queryAllByScoreid(@RequestParam("scoreid") int scoreid) {
        return StudentService.queryAllByScoreid(scoreid);
    }

    @RequestMapping(value=("/insertscore"),method = RequestMethod.POST)
    public void insertScore(@RequestBody int subjectid,@RequestBody String studentNo,@RequestBody int studentscore){
        StudentService.insertScore(subjectid,studentNo,studentscore);
    }


}
