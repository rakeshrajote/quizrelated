package com.quizapp.service;




import com.quizapp.entity.StudentInfo;
import com.quizapp.exception.ResourceNotFoundException;
import com.quizapp.repository.StudentInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInfoService {

    private final StudentInfoRepository repository;

    public StudentInfoService(StudentInfoRepository repository) {
        this.repository = repository;
    }

    public StudentInfo createStudent(StudentInfo student) {
        return repository.save(student);
    }

    public StudentInfo getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
    }

    public List<StudentInfo> getAllStudents() {
        return repository.findAll();
    }

    public StudentInfo updateStudent(Long id, StudentInfo updatedStudent) {
        StudentInfo existingStudent = getStudentById(id);
        updatedStudent.setId(existingStudent.getId());
        return repository.save(updatedStudent);
    }

    public void deleteStudent(Long id) {
        StudentInfo student = getStudentById(id);
        repository.delete(student);
    }
}

