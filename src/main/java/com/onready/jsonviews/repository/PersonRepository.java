package com.onready.jsonviews.repository;

import com.onready.jsonviews.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
