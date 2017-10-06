package com.yan.excersize.hibernate.controller;

import com.yan.excersize.hibernate.domain.Student;
import com.yan.excersize.hibernate.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Mohammad Nur on 10/6/2017.
 */

@Controller
@RequestMapping("students")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @PostMapping("insert")
    public ResponseEntity<String> insert(@RequestBody Student student) {
        studentService.addStudent(student);
        return new ResponseEntity<String>("Student has been added to the system", HttpStatus.OK);
    }

    @GetMapping("updateSchool")
    public ResponseEntity<Student> updateSchool(@RequestParam int id, @RequestParam String school) {
        Student student = studentService.updateStudent(id, school);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }
}
