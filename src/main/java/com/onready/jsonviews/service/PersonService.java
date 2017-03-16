package com.onready.jsonviews.service;

import com.onready.jsonviews.domain.Person;

public interface PersonService {

    Person findOne(Long id);
}
