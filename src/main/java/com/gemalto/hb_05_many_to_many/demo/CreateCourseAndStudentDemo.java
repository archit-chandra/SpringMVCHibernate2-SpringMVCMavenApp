package com.gemalto.hb_05_many_to_many.demo;


import com.gemalto.hb_05_many_to_many.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentDemo {

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

            // create a course
            Course course = new Course("Pacman - 80s popular game");

            // save the course
            System.out.println("luv2code: Saving the course ...");
            session.save(course);
            System.out.println("luv2code: Saved the course ..." + course);

            // create the students
            Student student1 = new Student("John", "Doe", "john@gmail.com");
            Student student2 = new Student("Mary", "Public", "mary@gmail.com");

            //add students to the course
            course.addStudent(student1);
            course.addStudent(student2);

            // save the students
            System.out.println("\nSaving students ...");
            session.save(student1);
            session.save(student2);
            System.out.println("\nSaved students: " + course.getStudents());


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
