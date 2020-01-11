package com.solt.demo.demo.manytomanydemo.service;

import com.solt.demo.demo.manytomanydemo.domain.Student;
import com.solt.demo.demo.manytomanydemo.domain.Subject;
import com.solt.demo.demo.manytomanydemo.repository.StudentRepository;
import com.solt.demo.demo.manytomanydemo.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DatabaseImpl implements IDatabase{
    private  final SubjectRepository subjectRepository;
    private  final StudentRepository studentRepository;

    public DatabaseImpl(SubjectRepository subjectRepository, StudentRepository studentRepository) {
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public  void createTable(){

        Student s1 = new Student("Thaw Thaw",29,"Latha");
        Student s2 = new Student("Thaw Nyein",22,"Mdy");
        Student s3 = new Student("Nyein Nyein",23,"Ygn");

        Subject sub1= new Subject("Java",6);
        Subject sub2= new Subject("Python",1);
        Subject sub3= new Subject("PHP",3);

        sub1.getStudents().add(s1);
        sub1.getStudents().add(s2);
        sub1.getStudents().add(s3);
        sub2.getStudents().add(s2);
        sub3.getStudents().add(s3);

        subjectRepository.save(sub1);
        subjectRepository.save(sub2);
        subjectRepository.save(sub3);

    }
}
