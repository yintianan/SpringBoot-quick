package com.example.springboot_quick2.model;

public class AllStudentInfo {
    private StudentInfo studentInfo;
    private StudentScore studentScore;
    private SubjectInfo subjectInfo;

    public AllStudentInfo(StudentInfo studentInfo, StudentScore studentScore, SubjectInfo subjectInfo) {
        this.studentInfo = studentInfo;
        this.studentScore = studentScore;
        this.subjectInfo = subjectInfo;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public StudentScore getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(StudentScore studentScore) {
        this.studentScore = studentScore;
    }

    public SubjectInfo getSubjectInfo() {
        return subjectInfo;
    }

    public void setSubjectInfo(SubjectInfo subjectInfo) {
        this.subjectInfo = subjectInfo;
    }
}
