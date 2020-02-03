package fr.formation.itschool.domain.services.impl;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.itschool.domain.dtos.AddressDto;
import fr.formation.itschool.domain.dtos.CreateContactDto;
import fr.formation.itschool.domain.entities.ContactInfo;
import fr.formation.itschool.domain.repositories.jpa.ContactJpaRepository;
import fr.formation.itschool.domain.services.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

    public final ContactJpaRepository contactJpaRepository;

    @Autowired
    private ModelMapper mapper;

    protected ContactServiceImpl(ContactJpaRepository contactJpaRepository) {
	this.contactJpaRepository = contactJpaRepository;
    }

    /**
     * @param dto
     */
    @Override
    public void create(@Valid CreateContactDto dto) {
	ContactInfo contactInfo = mapper.map(dto, ContactInfo.class);
	contactJpaRepository.save(contactInfo);
    }

    @Override
    public List<AddressDto> findAll() {
	return null;
    }

    /**
     * @param email
     * @return
     */
    @Override
    public boolean emailUnique(String email) {
	return !contactJpaRepository.existsByEmailIgnoreCase(email);
    }
}
