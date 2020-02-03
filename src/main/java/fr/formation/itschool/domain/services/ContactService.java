package fr.formation.itschool.domain.services;

import java.util.List;

import javax.validation.Valid;

import fr.formation.itschool.domain.dtos.AddressDto;
import fr.formation.itschool.domain.dtos.CreateContactDto;

public interface ContactService {

    void create(@Valid CreateContactDto dto);

    List<AddressDto> findAll();

    boolean emailUnique(String email);
}
