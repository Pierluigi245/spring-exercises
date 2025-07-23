package com.example.crudTest.controllers;


import com.example.crudTest.model.Student;
import com.example.crudTest.repository.StudentRepository;
import com.example.crudTest.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")

public class StudentController {
    @Autowired
    private  StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;

    // (1) Create a new Student
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentRepository.save(student);
        return ResponseEntity.ok(savedStudent);
    }

    // (2) Get all Students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return ResponseEntity.ok(students);
    }

    // (3) Get a specific Student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        return ResponseEntity.ok(student);
    }

    // (4) Update a Student by ID
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        student.setName(updatedStudent.getName());
        student.setSurname(updatedStudent.getSurname());
        student.setWorking(updatedStudent.isWorking());
        Student savedStudent = studentRepository.save(student);
        return ResponseEntity.ok(savedStudent);
    }

    // (5) Update isWorking value by ID
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateIsWorking(@PathVariable Long id, @RequestParam boolean working) {
        studentService.updateIsWorking(id, working);
        return ResponseEntity.ok().build();
    }

    // (6) Delete a Student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
