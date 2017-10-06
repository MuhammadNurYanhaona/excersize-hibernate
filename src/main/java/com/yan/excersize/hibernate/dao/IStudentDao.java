package com.yan.excersize.hibernate.dao;

import com.yan.excersize.hibernate.domain.Student;

/**
 * Created by Mohammad Nur on 10/6/2017.
 */
public interface IStudentDao {

    void saveStudent(Student student);
    Student getStudentInfo(int id);
    Student updateStudent(Student student);
}
