package com.onready.jsonviews.controller.rest;

import com.onready.jsonviews.config.RoleViewProperties;
import com.onready.jsonviews.domain.Person;
import com.onready.jsonviews.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/persons/")
public class PersonRestController {

    private final RoleViewProperties roleViewProperties;
    private final PersonService personService;

    public PersonRestController(RoleViewProperties roleViewProperties, PersonService personService) {
        this.roleViewProperties = roleViewProperties;
        this.personService = personService;
    }

    @GetMapping("{id}")
    public ResponseEntity<MappingJacksonValue> findOne(@PathVariable Long id, HttpServletRequest httpServletRequest) throws ClassNotFoundException {
        Person person = personService.findOne(id);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(person);
        String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().findFirst().get().getAuthority();
        mappingJacksonValue.setSerializationView(roleViewProperties.getView(role));

        return new ResponseEntity<>(mappingJacksonValue, HttpStatus.OK);
    }

}
