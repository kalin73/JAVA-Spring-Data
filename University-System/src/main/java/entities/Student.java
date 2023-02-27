package entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Student extends BasePerson {
	@Column(name = "average_grade")
	private double averageGrade;

	@Column
	private int attendence;
	
	@ManyToMany(mappedBy = "students")
	private Set<Course>courses;
	
	public Student() {
		courses = new HashSet<>();
	}

	public double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}

	public int getAttendence() {
		return attendence;
	}

	public void setAttendence(int attendence) {
		this.attendence = attendence;
	}
}
