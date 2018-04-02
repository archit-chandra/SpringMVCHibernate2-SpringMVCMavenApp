package com.gemalto.hibernate.demo;

import com.gemalto.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create a student object
            System.out.println("Creating new student objects...");
            Student student = new Student("Daffy", "Duck", "daffy@gamil.com");
            // start a transaction
            session.beginTransaction();
            // save the student object
            session.save(student);
            System.out.println("Saving the student...");
            System.out.println(student);
            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");

            // find student primary key
            System.out.println("Saved student. Generated id: " + student.getId());

            // get new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student beased on the id: primary key
            System.out.println("\nGetting student with id: " + student.getId());

            // will return null if no row found with the given id
            Student myStudent = session.get(Student.class, student.getId());
            System.out.println("Get complete: " + myStudent);

            // commit on transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
