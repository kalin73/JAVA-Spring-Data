package entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Teacher extends BasePerson {
	@Column
	private String email;

	@Column(name = "salary_per_hour")
	private BigDecimal salaryPerhour;

	@OneToMany
	@JoinTable(name = "teachers_students",
			joinColumns = @JoinColumn(name = "teacher_id",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "course_id",referencedColumnName = "id"))
	private Set<Course> courses;

	public Teacher() {
		courses = new HashSet<>();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getSalaryPerhour() {
		return salaryPerhour;
	}

	public void setSalaryPerhour(BigDecimal salaryPerhour) {
		this.salaryPerhour = salaryPerhour;
	}
}
