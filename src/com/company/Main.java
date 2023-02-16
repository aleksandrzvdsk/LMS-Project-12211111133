package com.company;

import repository.CourseRepository;
import repository.EnrollmentRepository;
import repository.StudentRepository;
import view.MainFrame;

public class Main {
    public static MainFrame mainFrame = new MainFrame();
    public static void main(String[] args) {
        StudentRepository.getAll();
        CourseRepository.getAll();
        EnrollmentRepository.getAll();
    }
}


