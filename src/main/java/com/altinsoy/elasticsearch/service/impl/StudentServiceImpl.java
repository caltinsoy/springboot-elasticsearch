package com.altinsoy.elasticsearch.service.impl;

import com.altinsoy.elasticsearch.entity.Student;
import com.altinsoy.elasticsearch.repository.StudentRepository;
import com.altinsoy.elasticsearch.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findByName(String search) {
        return studentRepository.findByName(search);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findByNameLikeOrSurNameLike(String name, String surName) {
        return studentRepository.findByNameLikeOrSurNameLike(name, surName);
    }

}
