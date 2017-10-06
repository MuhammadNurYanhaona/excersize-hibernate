package com.yan.excersize.hibernate.service;

import com.yan.excersize.hibernate.dao.IStudentDao;
import com.yan.excersize.hibernate.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mohammad Nur on 10/6/2017.
 */
@Service
@Transactional
public class StudentService implements IStudentService {

    @Autowired
    IStudentDao studentDao;

    @Override
    public void addStudent(Student student) {
        studentDao.saveStudent(student);
    }

    @Override
    public Student updateStudent(int studentId, String newSchool) {
        Student student = studentDao.getStudentInfo(studentId);
        student.setSchool(newSchool);
        return studentDao.updateStudent(student);
    }
}
