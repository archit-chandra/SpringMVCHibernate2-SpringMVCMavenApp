package com.gemalto.hibernate.demo;

import com.gemalto.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;

            // get new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student beased on the id: primary key
            System.out.println("\nGetting student with id: " + studentId);

            // will return null if no row found with the given id
            Student myStudent = session.get(Student.class, studentId);
            System.out.println("Updating student...");
            myStudent.setFirstName("Scoopy");

            // commit on transaction
            session.getTransaction().commit();
            System.out.println("Done!");

            // update email for all students
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Update email for all students");
            session.createQuery("update Student set email='foo@gmail.com'")
                    .executeUpdate();

            // commit on transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
