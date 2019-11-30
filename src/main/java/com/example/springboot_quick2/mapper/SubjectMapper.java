package com.example.springboot_quick2.mapper;

import com.example.springboot_quick2.model.SubjectInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface SubjectMapper {
    @Select("select subjectid,subjectname from SubjectInfo")
    public List<SubjectInfo> querySubjectList();
}
