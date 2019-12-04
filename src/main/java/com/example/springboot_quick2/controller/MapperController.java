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
import java.util.Map;

@Controller
public class MapperController {
    @Autowired
    private StudentService StudentService;

    @RequestMapping("")
    public String index(){
        return "index.html";
    }

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
        StudentInfo studentInfo = StudentService.findStudentByStudentNo(studentNo);
        return studentInfo;
    }

    @RequestMapping(value = "/stuNoToStuName/{studentNo}", method = RequestMethod.GET)
    @ResponseBody
    String stuNoToStuName(@PathVariable("studentNo") String studentNo) {
        return StudentService.stuNoToStuName(studentNo);
    }


//    @RequestMapping("/Score")
//    @ResponseBody
//    public List<StudentScore> queryScore() {
//        List<StudentScore> list = StudentService.queryAllInfo();
//        return list;
//    }

    @RequestMapping(value = "/queryScoreById", method = RequestMethod.GET)
    @ResponseBody
    public StudentScore queryScoreById(@RequestParam("id") int scoreid) {
        StudentScore studentScore = StudentService.queryScoreById(scoreid);
        return studentScore;
    }

    @RequestMapping(value = "/queryAllInfoByScoreId", method = RequestMethod.GET)
    @ResponseBody
    public AllStudentInfo queryAllByScoreid(@RequestParam("scoreid") int scoreid) {
        AllStudentInfo allStudentInfo = StudentService.queryAllByScoreid(scoreid);

        return allStudentInfo;
    }

    @RequestMapping(value = "/PageQueryAllInfo/{pageNum}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> PageQueryAllInfo(@PathVariable("pageNum") int pageNum) {
        return StudentService.queryAllInfo(pageNum);
    }

    @RequestMapping(value = ("/insertscore"), method = RequestMethod.GET)
    @ResponseBody
    public String insertScore(@RequestParam int subjectid, @RequestParam String studentNo, @RequestParam String studentscore) {
        float score = 0;
        try {
            score = Float.parseFloat(studentscore);
        } catch (NumberFormatException e) {
            return "分数输入格式有误";
        }
        int t = StudentService.insertScore(subjectid, studentNo, score);
        if (t > 0)
            return "success";
        else if (t == -1)
            return "无此学号学生";
        else if (t == -2)
            return "此学生的课程成绩已经存在";
        else
            return "fail";
    }

    @RequestMapping(value = ("/updatescore"), method = RequestMethod.GET)
    @ResponseBody
    public String updateScore(@RequestParam String studentscore, @RequestParam String studentNo, @RequestParam int subjectid) {
        float score = 0;
        try {
            score = Float.parseFloat(studentscore);
        } catch (NumberFormatException e) {
            return "分数输入格式有误";
        }
        int t = StudentService.updateScore(score, studentNo, subjectid);
        if (t > 0)
            return "success";
        else if (t == -1)
            return "无此学号学生";
        else
            return "fail";
    }
    @RequestMapping(value = ("/deletescore/{scoreid}"), method = RequestMethod.GET)
    @ResponseBody
    public int deleteScore(@PathVariable("scoreid")int scoreid){
        return StudentService.deleteScoreByScoreId(scoreid);
    }

}
