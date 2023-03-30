package com.softuni.jsonexercise.domain.dtos.users.wrappers;

import java.util.List;

import com.softuni.jsonexercise.domain.dtos.users.UserImportDto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersImportWrapperDto {
	@XmlElement(name = "user")
	private List<UserImportDto> users;

}
