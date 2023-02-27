package entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;


@Entity
public class Course extends BaseEntity {
	@Column
	private String name;

	@Column
	private String description;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column
	private int credits;

	@ManyToMany
	@JoinTable(name = "students_courses",
			joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
	private Set<Student> students;

	@OneToOne
	private Teacher teacher;

	public Course() {
		students = new HashSet<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}
}
