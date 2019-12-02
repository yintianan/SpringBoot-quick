package com.example.springboot_quick2.mapper;

import com.example.springboot_quick2.model.StudentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from StudentInfo")
    List<StudentInfo> queryStudentList();
    @Select("select * from StudentInfo where studentId=#{id}")
    StudentInfo findStudentById( long id);
    @Select("select * from StudentInfo where studentNo=#{studentNo}")
    StudentInfo findStudentByStudentNo(String studentNo);
    @Select("Select studentid from StudentInfo where studentNo=#{studentNo}")
    int stuNoToStuId(String studentNo);
}
