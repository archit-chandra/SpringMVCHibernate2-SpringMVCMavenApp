package com.gemalto.hibernate.demo;

import com.gemalto.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create 3 student objects
            System.out.println("Creating 3 student objects...");
            Student student1 = new Student("John", "Doe", "john@gamil.com");
            Student student2 = new Student("Mary", "Public", "mary@gamil.com");
            Student student3 = new Student("Bonita", "Applebum", "bonita@gamil.com");
            // start a transaction
            session.beginTransaction();
            // save the student object
            session.save(student1);
            session.save(student2);
            session.save(student3);
            System.out.println("Saving the student...");
            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
