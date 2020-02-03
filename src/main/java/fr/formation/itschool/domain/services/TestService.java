package fr.formation.itschool.domain.services;

import java.util.List;

import fr.formation.itschool.domain.entities.Address;

public interface TestService {

    public void save(Address address);

    public void deleteAddress(long id);;

    List<Address> allAddressByZipCode(String zipCode);

    List<Address> allAddressByCity(String city);

    List<Address> getAddressesByCriteria(String zipCode, String city);

    List<Address> allAddresses();
}
