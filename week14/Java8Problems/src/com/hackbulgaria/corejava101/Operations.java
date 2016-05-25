package com.hackbulgaria.corejava101;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Stream;

import org.omg.PortableServer.POAManager;

import com.hackbulgaria.corejava101.data.Gender;
import com.hackbulgaria.corejava101.data.Student;
import com.hackbulgaria.corejava101.data.StudentsDataFactory;

public class Operations implements StudentOperations {

	@Override
	public double getAverageMark() {
		OptionalDouble average = StudentsDataFactory.getAllStudents().stream().mapToDouble(Student::getGrade).average();
		return average.getAsDouble();
	}
	
	@Override
	public List<Student> getAllPassing() {
		Stream<Student> filteredStudents = StudentsDataFactory.getAllStudents().stream().filter(x -> x.getGrade() > 2.0f);
		List<Student> passingStudents = new LinkedList<>();
		filteredStudents.forEach(passingStudents::add);
		return passingStudents;
	}

	@Override
	public List<Student> getAllFailing() {
		Stream<Student> filteredStudents = StudentsDataFactory.getAllStudents().stream().filter(x -> x.getGrade() == 2.0f);
		List<Student> failingStudents = new LinkedList<>();
		filteredStudents.forEach(failingStudents::add);
		return failingStudents;
	}

	@Override
	public Map<Boolean, List<Student>> splitStudentsByMarks(float splitMark) {
		return null;
	}

	@Override
	public List<Student> orderByMarkDescending() {
		Stream<Student> sortedStream = StudentsDataFactory.getAllStudents().stream().sorted(new Comparator<Student>() {

			@Override
			public int compare(Student stud1, Student stud2) {
				if(stud1.getGrade() < stud2.getGrade()) {
					return 1;
				}
				if(stud1.getGrade() > stud2.getGrade()) {
					return -1;
				}
				return 0;
			}
		});
		List<Student> sortedStudents = new LinkedList<>();
		sortedStream.forEach(sortedStudents::add);
		return sortedStudents;
	}

	@Override
	public List<Student> orderByMarkAscending() {
		Stream<Student> sortedStream = StudentsDataFactory.getAllStudents().stream().sorted(new Comparator<Student>() {

			@Override
			public int compare(Student stud1, Student stud2) {
				if(stud1.getGrade() > stud2.getGrade()) {
					return 1;
				}
				if(stud1.getGrade() < stud2.getGrade()) {
					return -1;
				}
				return 0;
			}
		});
		List<Student> sortedStudents = new LinkedList<>();
		sortedStream.forEach(sortedStudents::add);
		return sortedStudents;
	}

	@Override
	public List<Student> getStudentsWithLowestMarks() {
		return null;
	}

	@Override
	public List<Student> getStudentsWithHighestMarks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, List<Double>> getMarksDistributionByAge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Gender, Double> getAverageMarkByGender() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Double, Integer> getMarksDistribution() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmailToHeader() {
		return null;
	}

	@Override
	public Map<Gender, Map<Integer, List<Student>>> splitStudentMarksByGenderAndThenByAge() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
	}
}
