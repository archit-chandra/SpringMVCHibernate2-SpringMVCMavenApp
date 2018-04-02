package com.gemalto.hb_05_many_to_many.demo;


import com.gemalto.hb_05_many_to_many.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForMaryDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // get the student mary from database
            int id = 4;
            Student student = session.get(Student.class, id);
            System.out.println("\nLoaded student: " + student);
            System.out.println("Current enrolled courses: " + student.getCourses());

            // create more courses
            Course course1 = new Course("Rubik's Cube - Puzzle game");
            Course course2 = new Course("Atari 2600 - Game development");

            // add student to courses
            course1.addStudent(student);
            course2.addStudent(student);

            // save the courses
            System.out.println("\nSaving the courses ...");
            session.save(course1);
            session.save(course2);

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            // add clean up code
            session.close();
            factory.close();
        }
    }
}
