package fr.formation.itschool.domain.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.itschool.domain.entities.Address;
import fr.formation.itschool.domain.repositories.jpa.AddressJpaRepository;
import fr.formation.itschool.domain.services.TestService;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private AddressJpaRepository repo;

    @Override
    public void save(Address address) {
	repo.save(address);
    }

    @Override
    public void deleteAddress(long id) {
	repo.deleteById(id);
    }

    @Override
    public List<Address> allAddresses() {
	return repo.findAll();
    }

    @Override
    public List<Address> allAddressByZipCode(String zipCode) {
	return repo.findByZipCode(zipCode);
    }

    @Override
    public List<Address> allAddressByCity(String city) {
	return repo.findByCityIgnoreCase(city);
    }

    @Override
    public List<Address> getAddressesByCriteria(String zipCode, String city) {
	return repo.getAddressesByCriteria(zipCode, city);
    }
}
