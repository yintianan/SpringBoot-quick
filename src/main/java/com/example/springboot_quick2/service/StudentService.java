package com.example.springboot_quick2.service;

import com.example.springboot_quick2.mapper.StudentMapper;
import com.example.springboot_quick2.mapper.SubjectMapper;
import com.example.springboot_quick2.model.StudentInfo;
import com.example.springboot_quick2.model.SubjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class StudentService {
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private StudentMapper studentMapper;

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


}
