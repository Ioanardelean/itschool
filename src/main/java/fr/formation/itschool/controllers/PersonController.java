package fr.formation.itschool.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.itschool.domain.dtos.CreatePersonDto;
import fr.formation.itschool.domain.services.PersonService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.HEAD, RequestMethod.POST,
	RequestMethod.OPTIONS })
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/create")
    public void create(@Valid @RequestBody CreatePersonDto dto) {
	personService.create(dto);
    }
}
