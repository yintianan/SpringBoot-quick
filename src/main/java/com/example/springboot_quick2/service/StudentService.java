package com.example.springboot_quick2.service;

import com.example.springboot_quick2.mapper.ScoreMapper;
import com.example.springboot_quick2.mapper.StudentMapper;
import com.example.springboot_quick2.mapper.SubjectMapper;
import com.example.springboot_quick2.model.AllStudentInfo;
import com.example.springboot_quick2.model.StudentInfo;
import com.example.springboot_quick2.model.StudentScore;
import com.example.springboot_quick2.model.SubjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentService {
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ScoreMapper scoreMapper;

    public List<StudentInfo> queryStudentList(){
        List<StudentInfo> list=studentMapper.queryStudentList();
        return list;
    }

    public List<SubjectInfo> querySubjectList() {
        List<SubjectInfo> list = subjectMapper.querySubjectList();
        return list;
    }
    public StudentInfo findStudentById(int id){
        StudentInfo studentInfo=studentMapper.findStudentById(id);
        return studentInfo;
    }
    public  StudentInfo findStudentByStudentNo(String studentNo){
        return studentMapper.findStudentByStudentNo(studentNo);
    }
    public List<StudentScore> queryScore(){
        List<StudentScore> list=scoreMapper.queryScore();
        return list;
    }
    public  StudentScore queryScoreById(int scoreid){
        StudentScore studentScore=scoreMapper.queryScoreById(scoreid);
        return studentScore;
    }
    public AllStudentInfo queryAllByScoreid(int scoreid){
        StudentScore studentScore=scoreMapper.queryScoreById(scoreid);
        StudentInfo studentInfo=studentMapper.findStudentById(studentScore.getStudentid());
        SubjectInfo subjectInfo=subjectMapper.querySubjectByid(studentScore.getSubjectid());
        return new AllStudentInfo(studentInfo,studentScore,subjectInfo);
    }
    public void insertScore(int subjectid,String studentNo,int studentscore){
        int studentid=studentMapper.stuNoToStuId(studentNo);
        scoreMapper.insertScore(subjectid,studentid,studentscore);
    }



}
