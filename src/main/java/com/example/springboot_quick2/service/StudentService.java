package com.example.springboot_quick2.service;

import com.example.springboot_quick2.mapper.ScoreMapper;
import com.example.springboot_quick2.mapper.StudentMapper;
import com.example.springboot_quick2.mapper.SubjectMapper;
import com.example.springboot_quick2.model.AllStudentInfo;
import com.example.springboot_quick2.model.StudentInfo;
import com.example.springboot_quick2.model.StudentScore;
import com.example.springboot_quick2.model.SubjectInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.binding.BindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class StudentService {
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ScoreMapper scoreMapper;

    public List<StudentInfo> queryStudentList() {
        List<StudentInfo> list = studentMapper.queryStudentList();
        return list;
    }

    public List<SubjectInfo> querySubjectList() {
        List<SubjectInfo> list = subjectMapper.querySubjectList();
        return list;
    }

    public StudentInfo findStudentById(int id) {
        StudentInfo studentInfo = studentMapper.findStudentById(id);
        return studentInfo;
    }

    public StudentInfo findStudentByStudentNo(String studentNo) {
        return studentMapper.findStudentByStudentNo(studentNo);
    }

    public String stuNoToStuName(String studentNo) {
        String name;
        try {
            name=studentMapper.stuNoToStuName(studentNo);

        } catch (BindingException e) {
           return "数据库错误";
        }
        return name;
    }


    public Map<String,Object> queryAllInfo(int pageNum){
        PageHelper.startPage(pageNum, 3);
        List<StudentScore> list = scoreMapper.queryScore();
        PageInfo<AllStudentInfo> pageInfo = new PageInfo(list, 3);
        List<AllStudentInfo> allStudentInfoList = new ArrayList<>();
        for (StudentScore ss : list) {
            // AllStudentInfo all=new AllStudentInfo(ss);
            int scoreid = ss.getScoreid();
            int studentid = ss.getStudentid();
            int subjectid = ss.getSubjectid();
            StudentInfo studentInfo = studentMapper.findStudentById(studentid);
            SubjectInfo subjectInfo = subjectMapper.querySubjectByid(subjectid);
            AllStudentInfo all = new AllStudentInfo(ss, studentInfo, subjectInfo);
            allStudentInfoList.add(all);


        }
        Map<String,Object> map=new HashMap<>();
        map.put("list",allStudentInfoList);//表本身
        long totalpage=0;
        if(pageInfo.getTotal()%3==0)
            totalpage=pageInfo.getTotal()/3;
        else
            totalpage=pageInfo.getTotal()/3+1;
        map.put("total",totalpage);//加入总页数
        map.put("PageNum",pageInfo.getPageNum());//当前页数



        return map;
    }

    public StudentScore queryScoreById(int scoreid) {
        StudentScore studentScore = scoreMapper.queryScoreById(scoreid);
        return studentScore;
    }

    public AllStudentInfo queryAllByScoreid(int scoreid) {
        return scoreMapper.queryAllStuInfoByScoreId(scoreid);
    }

    public List<AllStudentInfo> queryAllStuInfo() {
        return scoreMapper.queryAllStuInfo();
    }

    public int insertScore(int subjectid, String studentNo, float studentscore) {
        Integer studentid = null;
        try {
            studentid = studentMapper.stuNoToStuId(studentNo);
        } catch (org.apache.ibatis.binding.BindingException e) {
            return -1;
        }

        try {
            if(scoreMapper.querySubjectByStuidANDSubjectid(studentid,subjectid).isEmpty()){

            }else{
                return -2;
            }
        } catch (org.apache.ibatis.binding.BindingException e) {

        }
        return scoreMapper.insertScore(subjectid, studentid, studentscore);
    }

    public int updateScore(float studentscore, String studentNo, int subjectid) {
        Integer studentid = null;
        try {
            studentid = studentMapper.stuNoToStuId(studentNo);
        } catch (org.apache.ibatis.binding.BindingException e) {
            return -1;
        }
        return scoreMapper.updateScore(studentscore, studentid, subjectid);
    }

    public  int deleteScoreByScoreId(int scoreid){
        return scoreMapper.deleteScoreByScoreId(scoreid);
    }

}
