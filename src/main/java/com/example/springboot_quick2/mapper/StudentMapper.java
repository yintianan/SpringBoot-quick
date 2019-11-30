package com.example.springboot_quick2.mapper;

import com.example.springboot_quick2.model.StudentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from StudentInfo")
    public List<StudentInfo> queryStudentList();
    @Select("select * from StudentInfo where studentId=#{id}")
    public StudentInfo findStudentById(@Param("id") long id);
}
