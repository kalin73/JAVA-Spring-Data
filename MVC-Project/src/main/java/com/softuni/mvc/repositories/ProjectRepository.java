package com.softuni.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softuni.mvc.models.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	Optional<Project> findFirstByName(String name);

	Optional<List<Project>> findAllByIsFinished(Boolean isFinished);
}
