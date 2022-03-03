package com.altinsoy.elasticsearch.service;

import com.altinsoy.elasticsearch.entity.Student;

import java.util.List;

public interface StudentService {

    Iterable<Student> getStudents();

    List<Student> findByName(String search);

    void save(Student student);

    List<Student> findByNameLikeOrSurNameLike(String name, String surName);
}
