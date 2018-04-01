package com.gemalto.hb_01_one_to_one_uni.demo;

import com.gemalto.hb_01_one_to_one_uni.entity.Instructor;
import com.gemalto.hb_01_one_to_one_uni.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

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
            //create the objects
            /*Instructor instructor =
                    new Instructor("Chad", "Darby", "darby@gmail.com");

            InstructorDetail instructorDetail =
                    new InstructorDetail("http://www.luv2code.com",
                            "Love to code");*/

            Instructor instructor =
                    new Instructor("Madhu", "Patel", "madhu@gmail.com");

            InstructorDetail instructorDetail =
                    new InstructorDetail("http://www.youtube.com",
                            "Guitar");

            // associate the objects
            instructor.setInstructorDetail(instructorDetail);

            // start a transaction
            session.beginTransaction();

            // save the instructor.
            // By cascading effect, instructor detail will also be saved
            System.out.println("Saving instructor:" + instructor);
            session.save(instructor);

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
