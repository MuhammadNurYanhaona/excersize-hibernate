package com.yan.excersize.hibernate.service;

import com.yan.excersize.hibernate.domain.Student;

/**
 * Created by Mohammad Nur on 10/6/2017.
 */
public interface IStudentService {

    void addStudent(Student student);
    Student updateStudent(int studentId, String newSchool);
}
