package com.example.studentmanagement.service;


import org.springframework.stereotype.Service;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student save(Student student) {
        return repo.save(student);
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) 
    {
        repo.deleteById(id);
    }

    public Student update(Long id, Student updated) {
        Student existing = repo.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setAge(updated.getAge());

        return repo.save(existing);
    }

    public Student patch(Long id, Student patch) {
        Student existing = repo.findById(id).orElse(null);
        if (existing == null) return null;

        if (patch.getName() != null) existing.setName(patch.getName());
        if (patch.getEmail() != null) existing.setEmail(patch.getEmail());
        if (patch.getAge() != null) existing.setAge(patch.getAge());

        return repo.save(existing);
    }
}
