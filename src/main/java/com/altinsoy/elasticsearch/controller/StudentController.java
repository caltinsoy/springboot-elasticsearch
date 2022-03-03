package com.altinsoy.elasticsearch.controller;

import com.altinsoy.elasticsearch.entity.Student;
import com.altinsoy.elasticsearch.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class StudentController {

    private final StudentService studentService;


    @PostConstruct
    private void init() {
        Student student = new Student();
        student.setAge("27");
        student.setBirthLocation("Ankara");
        student.setName("marcus");
        student.setSurName("greenbelt");
        studentService.save(student);
    }


    @GetMapping
    public ResponseEntity<Iterable<Student>> getStudents() {
        Iterable<Student> students = studentService.getStudents();
        return ResponseEntity.ok(students);
    }


    @GetMapping(params = "search")
    public ResponseEntity<List<Student>> getStudent(@RequestParam(name = "search") String search) {
        List<Student> students = studentService.findByName(search);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{pattern}")
    public ResponseEntity<List<Student>> getStudentLike(@PathVariable String pattern) {
        List<Student> student = studentService.findByNameLikeOrSurNameLike(pattern, pattern);
        return ResponseEntity.ok(student);
    }


}
