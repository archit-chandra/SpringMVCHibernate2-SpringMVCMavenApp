package com.gemalto.hb_05_many_to_many.demo;


import com.gemalto.hb_05_many_to_many.entity.Course;
import com.gemalto.hb_05_many_to_many.entity.Instructor;
import com.gemalto.hb_05_many_to_many.entity.InstructorDetail;
import com.gemalto.hb_05_many_to_many.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // create a course
            Course course = new Course("Pacman - 80s popular game");

            // add some reviews
            course.add(new Review("Great course... loved it!!!"));
            course.add(new Review("Cool course, job well done"));
            course.add(new Review("What a dumb course, you are an idiot!"));

            // save the course ... and leverage the cascade all :-)
            System.out.println("luv2code: Saving the course");
            System.out.println(course);
            System.out.println(course.getReviews());
            session.save(course);

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
