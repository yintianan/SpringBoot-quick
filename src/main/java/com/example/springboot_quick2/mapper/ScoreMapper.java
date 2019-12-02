package com.example.springboot_quick2.mapper;

import com.example.springboot_quick2.model.StudentScore;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ScoreMapper {
    @Select("select * from ScoreInfo")
    List<StudentScore> queryScore();

    @Select("select * from ScoreInfo where scoreid=#{scoreid}")
    StudentScore queryScoreById(int scoreid);

    @Insert("insert into ScoreInfo(subjectid,studentid,studentscore) values(#{subjectid},#{studentid},#{studentscore})")
    void insertScore(int subjectid,int studentid,int studentscore);

}
