package fr.formation.itschool.domain.services.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.itschool.domain.dtos.AddressDto;
import fr.formation.itschool.domain.dtos.AddressCreateDto;
import fr.formation.itschool.domain.entities.Address;
import fr.formation.itschool.domain.repositories.jpa.AddressJpaRepository;
import fr.formation.itschool.domain.services.AddressService;

/**
 * @author Administrateur
 */
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressJpaRepository addressJpaRepository;

    @Autowired
    private ModelMapper mapper;

    protected AddressServiceImpl(AddressJpaRepository addressJpaRepository) {
	this.addressJpaRepository = addressJpaRepository;
    }

    /**
     * @param dto
     */
    @Override
    public void create(AddressCreateDto dto) {
	Address address = mapper.map(dto, Address.class);
	addressJpaRepository.save(address);
    }

    @Override
    public AddressCreateDto get(Long id) {
	Address address = addressJpaRepository.findById(id).get();
	AddressCreateDto createAddressDto = mapper.map(address,
		AddressCreateDto.class);
	return createAddressDto;
    }

    @Override
    public List<AddressDto> findAll() {
	List<Address> addresses = addressJpaRepository.findAll();
	Type type = new TypeToken<List<AddressDto>>() {//
	}.getType();
	List<AddressDto> addressDto = mapper.map(addresses, type);
	return addressDto;
    }
}
