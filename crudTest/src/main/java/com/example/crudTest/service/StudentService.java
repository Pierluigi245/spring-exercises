package com.example.crudTest.service;



import com.example.crudTest.model.Student;
import com.example.crudTest.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void updateIsWorking(Long id, boolean isWorking) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        student.setWorking(isWorking);
        studentRepository.save(student);
    }
}
