package com.softuni.jsonexercise.domain.dtos.users;

import java.util.List;

import com.google.gson.annotations.Expose;

public class UsersWithProductsWrapperDto {
	@Expose
	private Integer usersCount;

	@Expose
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
