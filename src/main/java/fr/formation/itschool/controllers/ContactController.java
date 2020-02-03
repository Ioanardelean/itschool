package fr.formation.itschool.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.itschool.domain.dtos.CreateContactDto;
import fr.formation.itschool.domain.services.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    protected ContactController(ContactService contactService) {
	this.contactService = contactService;
    }

    @PostMapping("/create")
    public void create(@Valid @RequestBody CreateContactDto dto) {
	contactService.create(dto);
    }
}
