package com.agenda.demo.Interfaces;

import com.agenda.demo.Student;


import java.util.List;

public interface IStudentRepository {
    Student get(int id);
    List<Student> get();
    void create(Student st);
    void delete(Student st);
    void update(Student st);
}
