package com.gemalto.hb_01_one_to_one_uni.demo;

import com.gemalto.hb_01_one_to_one_uni.entity.Instructor;
import com.gemalto.hb_01_one_to_one_uni.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // get the instructor detail object
            int id = 2;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);                    // print the instructor detail
            // print associated instructor
            System.out.println("Instructor detail: " + instructorDetail);

            // delete instructoe detail
            System.out.println("Deleting instructor detail:" + instructorDetail);
            session.delete(instructorDetail);

            // commit the transaction
            System.out.println("Associated instructor:" + instructorDetail.getInstructor());
            session.getTransaction().commit();
            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // handle connection leak issue
            session.close();
            factory.close();
        }
    }
}
