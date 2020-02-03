package fr.formation.itschool.domain.services.impl;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.itschool.domain.dtos.CreatePersonDto;
import fr.formation.itschool.domain.entities.Person;
import fr.formation.itschool.domain.repositories.jpa.PersonJpaRepository;
import fr.formation.itschool.domain.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonJpaRepository personJpaRepository;

    @Autowired
    private ModelMapper mapper;

    protected PersonServiceImpl(PersonJpaRepository personJpaRepository) {
	this.personJpaRepository = personJpaRepository;
    }

    @Override
    public void create(@Valid CreatePersonDto dto) {
	Person person = mapper.map(dto, Person.class);
	personJpaRepository.save(person);
    }

    @Override
    public boolean SecNumberUnique(String socialSecNumber) {
	return !personJpaRepository.existsBySocialSecNumber(socialSecNumber);
    }
}
