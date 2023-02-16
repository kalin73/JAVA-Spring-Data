package entities;

import java.time.LocalDate;

import orm.annotations.Column;
import orm.annotations.Entity;
import orm.annotations.Id;

@Entity(name = "Accounts")
public class Account {
	@Id(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "createdOn")
	private LocalDate createdOn;

	@Column(name = "age")
	private Integer age;

	@Column(name = "nickname")
	private String nickname;

	public Account() {

	}

	public Account(String name, LocalDate createdOn, Integer age) {
		this.name = name;
		this.createdOn = createdOn;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
