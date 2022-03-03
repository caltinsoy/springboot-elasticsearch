package com.altinsoy.elasticsearch.repository;

import com.altinsoy.elasticsearch.entity.Student;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends ElasticsearchRepository<Student, String> {
    List<Student> findByName(String search);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<Student> getByCustomQuery(String search);

    List<Student> findByNameLikeOrSurNameLike(String name, String surName);
}
