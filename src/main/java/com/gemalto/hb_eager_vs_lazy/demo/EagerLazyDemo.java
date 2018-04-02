package com.gemalto.hb_eager_vs_lazy.demo;


import com.gemalto.hb_eager_vs_lazy.entity.Course;
import com.gemalto.hb_eager_vs_lazy.entity.Instructor;
import com.gemalto.hb_eager_vs_lazy.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

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
            // start a transaction
            session.beginTransaction();

            // get instructor from db
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println("luv2code: Instrctor: " + instructor);

            /*// get courses for the instructor
            // also Solution:1 - call getter method while session is opened
            System.out.println("luv2code: Courses: " + instructor.getCourses());*/

            // commit the transaction
            session.getTransaction().commit();

            // close the session (purposely) - it will fail lazy loading below
            session.close();
            System.out.println("\nluv2code: The session is now closed!\n");

            // Solution:
            // 1. call getter method while session is opened
            // 2. HQL join fetch

            // it will fail because session is closed above before lazy loading below
            System.out.println("luv2code: Courses: " + instructor.getCourses());

            System.out.println("luv2code: Done!");
        } finally {
            // add clean up code
            session.close();
            factory.close();
        }
    }
}
