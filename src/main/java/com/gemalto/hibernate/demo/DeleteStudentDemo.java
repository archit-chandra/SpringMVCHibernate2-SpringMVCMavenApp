package com.gemalto.hibernate.demo;

import com.gemalto.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 3;

            // get new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student beased on the id: primary key
            System.out.println("\nGetting student with id: " + studentId);

            // will return null if no row found with the given id
            Student myStudent = session.get(Student.class, studentId);

            // deleting object
            /*System.out.println("Deleting student..." + myStudent);
            session.delete(myStudent);*/

            // alternate approach of deleting object
            System.out.println("Deleting student with id=4");
            session.createQuery("delete from Student where id='4'").executeUpdate();

            // commit on transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
