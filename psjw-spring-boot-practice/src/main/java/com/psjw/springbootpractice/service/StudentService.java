package com.psjw.springbootpractice.service;


import com.psjw.springbootpractice.domain.Student;
import com.psjw.springbootpractice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public void printStudent(String name) {
        Student student = studentRepository.getStudent(name);
        System.out.println("μ°Ύλ νμ: " + student);
    }

    @PostConstruct
    public void init() {
        studentRepository.enroll("jack", 15, Student.Grade.B);
        studentRepository.enroll("cassie", 18, Student.Grade.A);
        studentRepository.enroll("fred", 14, Student.Grade.C);
    }
}