package com.quizapp.controller;


import com.quizapp.entity.StudentInfo;
import com.quizapp.service.StudentInfoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentInfoController {

    private final StudentInfoService service;

    public StudentInfoController(StudentInfoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StudentInfo> createStudent(@Valid @RequestBody StudentInfo student) {
        return new ResponseEntity<>(service.createStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentInfo> getStudentById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getStudentById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentInfo>> getAllStudents() {
        return new ResponseEntity<>(service.getAllStudents(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentInfo> updateStudent(@PathVariable Long id, @Valid @RequestBody StudentInfo student) {
        return new ResponseEntity<>(service.updateStudent(id, student), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
