package com.example.cruddemo3;

import com.example.cruddemo3.dao.InstructorDao;
import com.example.cruddemo3.entity.Course;
import com.example.cruddemo3.entity.Instructor;
import com.example.cruddemo3.entity.InstructorDetail;
import com.example.cruddemo3.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Cruddemo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Cruddemo3Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorDao instructorDao){
		return runner ->{

//			saveCourseWithReview(instructorDao);

			deleteCourseById(instructorDao);
		};
	}

	private void saveCourseWithReview(InstructorDao instructorDao) {
		System.out.println("Saving Course with review...........");

		Course course = new Course("Gym Pro Tips");

		course.addReview( new Review("Good Course!!"));
		course.addReview( new Review("Value for money!!"));
		course.addReview( new Review("Don't but it!"));

		instructorDao.saveCourseWithReview(course);

		System.out.println("Done!!");

	}

	private void deleteCourseById(InstructorDao instructorDao) {
		System.out.println("Deleting 1 course....");
		instructorDao.deleteCourse(10);
		System.out.println("Done!!");
	}

	private void updateCourse(InstructorDao instructorDao) {

		System.out.println("Updating Course......");
		Course course = instructorDao.findCourseById(10);
		course.setTitle("Gymnastic Pro");

		instructorDao.updateCourse(course);
		System.out.println("Done!!");
	}

	private void updateInstructor(InstructorDao instructorDao) {

		System.out.println("Updating Instructor email......");
		Instructor instructor = instructorDao.findById(1);
		instructor.setEmail("Cj@gamil.com");

		instructorDao.updateInstructor(instructor);
		System.out.println("Done!!");
	}

	private void fetchInstructorJoinFetch(InstructorDao instructorDao) {
		System.out.println("Instructor fetching with JOIN FETCH............");
		Instructor instructor = instructorDao.findInstructorByIdJoinFetch(1);
		System.out.println(instructor);
		System.out.println(instructor.getCourseList());
		System.out.println("Done!!");

	}

	private void fetchCourseByInstructorId(InstructorDao instructorDao) {

		System.out.println("Fetching courses by Instructor id(1) ......");
		Instructor instructor = instructorDao.findById(1);
		System.out.println(instructor);
		System.out.println("Calling seprate function.....");
		List<Course> courseList = instructorDao.findCoursesByInstructorId(1);
		instructor.setCourseList(courseList);
		System.out.println(instructor.getCourseList());
		System.out.println("Done!!");

	}

	private void fetchInstructorWithCourses(InstructorDao instructorDao) {

		System.out.println("Fetching Instructor by id :1");

		Instructor instructor = instructorDao.findById(1);

		System.out.println(instructor);
		System.out.println(instructor.getCourseList());
	}

	private void saveInstructorWithCourses(InstructorDao instructorDao) {

		Instructor instructor = new Instructor("Chunnu","Ji","chunnu@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://javacoding.com","coding");
		instructor.setInstructorDetail(instructorDetail);

		Course c1 = new Course("Maths");
		Course c2 = new Course("Paining");

//		List<Course> courseList = new ArrayList<>();
//		courseList.add(c1);
//		courseList.add(c2);

		instructor.add(c1);
		instructor.add(c2);

		System.out.println("Saving record................");
		instructorDao.save(instructor);
		System.out.println("Done!!");
	}

	private void deleteInstructorDetailById(InstructorDao instructorDao) {

		System.out.println("Deleting Instructor detail by id.......");
		instructorDao.deleteInstructorDetailById(4);
		System.out.println("Done!!");
	}

	private void findInstructorDetail(InstructorDao instructorDao) {

		System.out.println("Instructor details by id.............");
		InstructorDetail instructorDetail = instructorDao.findInstructorDetailById(1);
		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor());
	}

	private void deleteInstructor(InstructorDao instructorDao) {
		System.out.println("Deleting by id......");
		instructorDao.deleteById(1);
		System.out.println("Done...");
	}

	private void findInstructor(InstructorDao instructorDao) {

		System.out.println("Find by id.........");
		Instructor instructor = instructorDao.findById(1);
		System.out.println(instructor);
	}

	private void saveInstructor(InstructorDao instructorDao) {

		Instructor instructor = new Instructor("Chunnu","Ji","chunnu@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://javacoding.com","coding");

//		Instructor instructor = new Instructor("Rohan","Kumar","rohan@gmail.com");
//		InstructorDetail instructorDetail = new InstructorDetail("http://singing.com","music");

		instructor.setInstructorDetail(instructorDetail);
		System.out.println("Saving record................");
		instructorDao.save(instructor);
	}

}
