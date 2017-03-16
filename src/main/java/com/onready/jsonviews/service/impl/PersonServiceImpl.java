package com.onready.jsonviews.service.impl;

import com.onready.jsonviews.domain.Person;
import com.onready.jsonviews.repository.PersonRepository;
import com.onready.jsonviews.service.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person findOne(Long id) {
        return personRepository.findOne(id);
    }
}
