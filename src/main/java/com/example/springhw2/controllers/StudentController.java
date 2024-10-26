package com.example.springhw2.controllers;

import com.example.springhw2.domain.Student;
import com.example.springhw2.services.StudentService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add/{name}/{age}")
    public Student addStudent(@PathVariable String name, @PathVariable int age) {
        Student student = new Student(name, age);
        studentService.add(student);
        return student;
    }

    @DeleteMapping("/del/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.delete(id);
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return studentService.getAll();
    }

    @GetMapping(value = "/getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getStudent(@PathVariable long id) {
        Student student = studentService.get(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping(value = "/getByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getStudentByName(@PathVariable String name) {
        List<Student> students = studentService.get(name);
        return ResponseEntity.ok(students);
    }

}