package com.example.springhw2.services;

import com.example.springhw2.domain.Student;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class StudentService implements iService<Student> {

    private final List<Student> students;

    public StudentService() {
        this.students = new ArrayList<>();
        students.add(new Student("Nik", 16));
    }

    @Override
    public List<Student> getAll() {
        return List.copyOf(students);
    }

    @Override
    public void add(Student o) {
        students.add((Student) o);
    }

    @Override
    public Student get(long id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Student> get(String name) {
        List<Student> res = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equals(name)) {
                res.add(student);
            }
        }
        return res;
    }

    @Override
    public void delete(long id) {
        students.removeIf(student -> student.getId() == id);
    }
}