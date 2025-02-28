package com.example.cruddemo3;

import com.example.cruddemo3.dao.StudentDao;
import com.example.cruddemo3.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Cruddemo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Cruddemo3Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner ->{
//				saveStudents(studentDao);
//				findStudentById(studentDao);
//			findStudentByFirstName(studentDao);
			findStudentRecordsLike(studentDao);

		};
	}

	private void findStudentRecordsLike(StudentDao studentDao) {
		System.out.println("Students by first name..........");

		studentDao.findStudentRecords("abc");
	}

	private void findStudentByFirstName(StudentDao studentDao) {
		System.out.println("Students by first name..........");

		studentDao.findStudentByFirstName("Ramesh");
	}

	private void findStudentById(StudentDao studentDao) {
		System.out.println("Student.....");
		studentDao.findStudent(1);
	}

	private void saveStudents(StudentDao studentDao) {
		System.out.println("Saving some students records..........");
		studentDao.saveStudent(new Student("Jaabcck","Marshal","jack@gamil.com"));
		studentDao.saveStudent(new Student("Ramesh","Ram","ramesh@gamil.com"));
		studentDao.saveStudent(new Student("Vijay","Seabctu","vijay@gamil.com"));
		studentDao.saveStudent(new Student("Ramesh","Ram","ramesh@gamil.com"));
		studentDao.saveStudent(new Student("Vijay","Seabctu","vijay@gamil.com"));
		studentDao.saveStudent(new Student("Ramesh","Ram","rameabcsh@gamil.com"));
		studentDao.saveStudent(new Student("Vijay","abcSeabctu","vijay@gamil.com"));
		System.out.println("Done!!");
	}
}
