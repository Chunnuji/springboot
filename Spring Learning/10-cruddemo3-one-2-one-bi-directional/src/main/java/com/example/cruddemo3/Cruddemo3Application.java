package com.example.cruddemo3;

import com.example.cruddemo3.dao.InstructorDao;
import com.example.cruddemo3.entity.Instructor;
import com.example.cruddemo3.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Cruddemo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Cruddemo3Application.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(String[] args){
//		return runner ->{
//			System.out.println("Hello!!!!!!!!!!!!");
//		};
//	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorDao instructorDao){
		return runner ->{
//			saveInstructor(instructorDao);

//			findInstructor(instructorDao);

//			deleteInstructor(instructorDao);

//			findInstructorDetail(instructorDao);

			deleteInstructorDetailById(instructorDao);


		};
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
		instructorDao.deleteById(2);
		System.out.println("Done...");
	}

	private void findInstructor(InstructorDao instructorDao) {

		System.out.println("Find by id.........");

		Instructor instructor = instructorDao.findById(1);

		System.out.println(instructor);
	}

	private void saveInstructor(InstructorDao instructorDao) {

//		Instructor instructor = new Instructor("Chunnu","Ji","chunnu@gmail.com");
//
//		InstructorDetail instructorDetail = new InstructorDetail("http://javacoding.com","coding");

		Instructor instructor = new Instructor("Rohan","Kumar","rohan@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail("http://singing.com","music");

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving record................");
		instructorDao.save(instructor);
	}

}
