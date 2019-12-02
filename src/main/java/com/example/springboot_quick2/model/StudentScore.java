package com.example.springboot_quick2.model;

public class StudentScore {
    private int scoreid;
    private int subjectid;
    private int studentid;
    private float studentscore;


    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public float getStudentscore() {
        return studentscore;
    }

    public void setStudentscore(float studentscore) {
        this.studentscore = studentscore;
    }


    public int getScoreid() {
        return scoreid;
    }

    public void setScoreid(int scoreid) {
        this.scoreid = scoreid;
    }
}
