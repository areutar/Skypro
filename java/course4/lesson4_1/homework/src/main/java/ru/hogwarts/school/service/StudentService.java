package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface StudentService {
    Student createStudent(Student student);

    Student findStudent(long id);

    Student editStudent(Student student);

    void deleteStudent(long id);

    Collection<Student> getAllStudents();

    Collection<Student> findByAge(int age);

    Collection<Student> findByAgeBetween(int age1, int age2);

    Integer getStudentsCount();

    Float getStudentsAgesAverage();

    Collection<Student> getLastFifeStudents();

}
