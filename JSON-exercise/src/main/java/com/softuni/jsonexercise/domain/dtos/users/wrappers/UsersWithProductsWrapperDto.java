package com.softuni.jsonexercise.domain.dtos.users.wrappers;

import java.util.List;

import com.softuni.jsonexercise.domain.dtos.users.UsersWithProductsDto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersWithProductsWrapperDto {
	
	@XmlAttribute(name = "count")
	private Integer usersCount;

	@XmlElement(name = "user")
	private List<UsersWithProductsDto> users;

	public UsersWithProductsWrapperDto() {

	}

	public UsersWithProductsWrapperDto(List<UsersWithProductsDto> users) {
		this.users = users;
		this.usersCount = users.size();
	}

	public Integer getUsersCount() {
		return usersCount;
	}

	public void setUsersCount(Integer usersCount) {
		this.usersCount = usersCount;
	}

	public List<UsersWithProductsDto> getUsers() {
		return users;
	}

	public void setUsers(List<UsersWithProductsDto> users) {
		this.users = users;
	}

}
