package com.gemalto.hb_03_one_to_many.demo;


import com.gemalto.hb_03_one_to_many.entity.Course;
import com.gemalto.hb_03_one_to_many.entity.Instructor;
import com.gemalto.hb_03_one_to_many.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            //create the objects
            Instructor instructor =
                    new Instructor("Susan", "Public", "susan@gmail.com");

            InstructorDetail instructorDetail =
                    new InstructorDetail("http://www.youtube.com",
                            "Video Games");

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
            // add clean up code
            session.close();
            factory.close();
        }
    }
}
