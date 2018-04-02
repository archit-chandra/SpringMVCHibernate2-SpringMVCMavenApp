package com.gemalto.hb_04_one_to_many_uni.demo;


import com.gemalto.hb_04_one_to_many_uni.entity.Course;
import com.gemalto.hb_04_one_to_many_uni.entity.Instructor;
import com.gemalto.hb_04_one_to_many_uni.entity.InstructorDetail;
import com.gemalto.hb_04_one_to_many_uni.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseAndReviewDemo {

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

            // get the course
            int id = 10;
            Course course = session.get(Course.class, id);

            // delete the course
            System.out.println("luv2code: Deleting the course ...");
            System.out.println(course);

            // print the course reviews
            System.out.println(course.getReviews());

            // delete the course
            session.delete(course);

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
