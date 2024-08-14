package com.example.cruddemo1;

import com.example.cruddemo1.dao.StudentDao;
import com.example.cruddemo1.domain.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Cruddemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Cruddemo1Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner->{
//			createStudent(studentDao);
//			multipleStudentSave(studentDao);

//			findStudent(studentDao);

//			findAllStudent(studentDao);

//			findStudentByLastName(studentDao);

//			updateStudent(studentDao);

//			deleteStudentById1(studentDao);

			deleteAllStudent(studentDao);
		};
	}

	private void deleteAllStudent(StudentDao studentDao) {

		System.out.println("Deleting all records..........");
		System.out.println(studentDao.deleteAllStudents());
	}

	private void deleteStudentById1(StudentDao studentDao) {

		System.out.println("Deleting by ID.............");

		studentDao.deleteStudentById(7);
	}

	private void updateStudent(StudentDao studentDao) {

		Student s1 = studentDao.findById(7);

		s1.setFirstName("Kush");
		s1.setLastName("PK");

		studentDao.updateStudent(s1);
	}

	private void findStudentByLastName(StudentDao studentDao) {
		System.out.println("Students by Last Name..........");

		List<Student>studentList = studentDao.findByLastName("Tiwari");

		for (Student s:
			 studentList) {
			System.out.println(s);

		}
	}

	private void findAllStudent(StudentDao studentDao) {

		System.out.println("All records in table ......");
		List<Student> studentList = studentDao.findAll();

		for (Student s:studentList) {
			System.out.println(s);
		}

	}

	private void findStudent(StudentDao studentDao) {
		System.out.println("Creating student ...............");
		Student s1 = new Student("Lav","TP","Lav@spring.com");

		System.out.println("Saving student .................");
		studentDao.save(s1);

		System.out.println("Student id ...................");
		System.out.println(s1.getId());

		Integer id = s1.getId();

		System.out.println("Reading from db...................");
		Student temp = studentDao.findById(id);
		System.out.println(temp);

	}

	private void multipleStudentSave(StudentDao studentDao) {

		System.out.println("Creating student ...............");
		Student s1 = new Student("Pk","Singh","Pk@spring.com");
		Student s2 = new Student("Vk","Roy","Vk@spring.com");

		System.out.println("Saving student .................");
		studentDao.save(s1);
		studentDao.save(s2);
	}

	private void createStudent(StudentDao studentDao) {

		System.out.println("Creating student ...............");
		Student s1 = new Student("Cj","Tiwari","Cj@spring.com");

		System.out.println("Saving student .................");
		studentDao.save(s1);

		System.out.println("Student id ...................");
		System.out.println(s1.getId());
	}
}
