package fr.formation.itschool.domain.services;

import java.util.List;

import fr.formation.itschool.domain.dtos.AddressDto;
import fr.formation.itschool.domain.dtos.AddressCreateDto;

public interface AddressService {

    public void create(AddressCreateDto dto);

    public AddressCreateDto get(Long id);

    public List<AddressDto> findAll();
}
