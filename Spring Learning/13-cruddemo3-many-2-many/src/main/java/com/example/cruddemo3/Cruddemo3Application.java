package com.example.cruddemo3;

import com.example.cruddemo3.dao.InstructorDao;
import com.example.cruddemo3.entity.*;
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
//			addCourseWithStudents(instructorDao);
//			deleteStudent(instructorDao);
//			findCourseAndStudent(instructorDao);
//			findStudentAndCourse(instructorDao);
//			addStudentOnly(instructorDao);
//			addCourseOnly(instructorDao);
			studentPickCourse(instructorDao);
//			deleteCourseById(instructorDao);
		};
	}

	private void studentPickCourse(InstructorDao instructorDao) {
		System.out.println("Student picking courses.........");
		Student student = instructorDao.findStudentOnlyById(6);

		Course course = instructorDao.findCourseById(13);
		Course course2 = instructorDao.findCourseById(14);

		student.addCourse(course);
		student.addCourse(course2);

		instructorDao.studentPickCourse(student);
		System.out.println("Done!!");
	}

	private void addCourseOnly(InstructorDao instructorDao) {
		instructorDao.saveCourseWithReview(new Course("Basic Maths."));
		instructorDao.saveCourseWithReview(new Course("PQY of UPSC"));
		instructorDao.saveCourseWithReview(new Course("AWS Cloud."));
	}

	private void addStudentOnly(InstructorDao instructorDao) {
		instructorDao.saveStudent(new Student("Tom","Cruise","tom@gmail.com"));
		instructorDao.saveStudent(new Student("Rajan","Mishra","rajan@gmail.com"));
	}

	private void findStudentAndCourse(InstructorDao instructorDao) {
		System.out.println("Finding student and their courses.....");

		Student s = instructorDao.findStudentCourseById(1);
		System.out.println(s);
		System.out.println(s.getCourseList());
		System.out.println("Done!!");
	}

	private void findCourseAndStudent(InstructorDao instructorDao) {
		System.out.println("Finding Course and their Students.....");

		Course c =instructorDao.findCourseStudentById(10);
		System.out.println(c);
		System.out.println(c.getStudentList());
		System.out.println("Done!!");
	}

	private void deleteStudent(InstructorDao instructorDao) {
		System.out.println("Deleting student by id........");
		instructorDao.deleteStudentById(5);
		System.out.println("Done!!");
	}

	private void addCourseWithStudents(InstructorDao instructorDao) {

		Course c1 = new Course("Java Coding");

		c1.addStudents(new Student("Mahesh","Kumar","mahesh@udemy.com"));
		c1.addStudents(new Student("Shivani","Kumari","shivani@udemy.com"));
		c1.addStudents(new Student("Ram","Rao","rao@udemy.com"));

		instructorDao.saveCourseWithReview(c1);//same function can be used for any course saving

		Course c2 = new Course("Spring Advance Learning");

		c2.addStudents(new Student("Mahesh","Kumar","mahesh@udemy.com"));
		c2.addStudents(new Student("Shivani","Kumari","shivani@udemy.com"));

		instructorDao.saveCourseWithReview(c2);


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
