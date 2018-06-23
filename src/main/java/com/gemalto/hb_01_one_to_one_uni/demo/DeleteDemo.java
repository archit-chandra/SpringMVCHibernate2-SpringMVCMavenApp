package com.gemalto.hb_01_one_to_one_uni.demo;

import com.gemalto.hb_01_one_to_one_uni.entity.Instructor;
import com.gemalto.hb_01_one_to_one_uni.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

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

            //get instructor by id = primary key
            int id = 1;

            // will return null, if no data was found for this id
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println("Found instructor: " + instructor);

            //delete that instructor
            if (instructor != null) {
                System.out.println("Deleting: " + instructor);
                // Note: will also delete instructor detail because of CascadeType.ALL
                session.delete(instructor);
            } else {
                System.out.println("No instructor was found");
            }

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
