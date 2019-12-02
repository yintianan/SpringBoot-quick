package com.example.springboot_quick2.mapper;

import com.example.springboot_quick2.model.SubjectInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface SubjectMapper {
    @Select("select * from SubjectInfo")
    List<SubjectInfo> querySubjectList();
    @Select("select * from SubjectInfo where subjectid=#{subjectid}")
    SubjectInfo querySubjectByid(int subjectid);
}
