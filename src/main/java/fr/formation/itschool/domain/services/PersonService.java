package fr.formation.itschool.domain.services;

import javax.validation.Valid;

import fr.formation.itschool.domain.dtos.CreatePersonDto;

public interface PersonService {

    void create(@Valid CreatePersonDto dto);

    public boolean SecNumberUnique(String socialSecNumber);
}
