package fr.formation.itschool.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.itschool.domain.entities.Address;
import fr.formation.itschool.domain.services.TestService;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService service;

    @PostMapping("/createAddress")
    public void createAddress(@RequestBody Address address) {
	service.save(address);
    }

    @DeleteMapping("/deleteAddress/{id}")
    public void deleteAddress(@PathVariable Long id) {
	service.deleteAddress(id);
    }

    @GetMapping("/allAddresses")
    public List<Address> allAddresses() {
	return service.allAddresses();
    }

    @GetMapping("/allAddressByZipCode/{zipCode}")
    public List<Address> allAddressByZipCode(@PathVariable String zipCode) {
	return service.allAddressByZipCode(zipCode);
    }

    @GetMapping("/allAddressByCity/{city}")
    public List<Address> allAddressByCity(@PathVariable String city) {
	return service.allAddressByCity(city);
    }

    @GetMapping("/allAddressesByCity/{zipCode}/{city}")
    public List<Address> getAddressesByCriteria(@PathVariable String zipCode,
	    @PathVariable String city) {
	return service.getAddressesByCriteria(zipCode, city);
    }
}
