package fr.formation.itschool.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.itschool.domain.dtos.AddressDto;
import fr.formation.itschool.domain.dtos.AddressCreateDto;
import fr.formation.itschool.domain.services.AddressService;

@CrossOrigin(origins = "*", methods = { RequestMethod.HEAD, RequestMethod.POST,
	RequestMethod.OPTIONS })
@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    protected AddressController(AddressService addressService) {
	this.addressService = addressService;
    }

    @PostMapping("/create")
    protected void create(@Valid @RequestBody AddressCreateDto dto) {
	addressService.create(dto);
    }

    @GetMapping("/{id}")
    protected AddressCreateDto get(@PathVariable("id") Long id) {
	return addressService.get(id);
    }

    @GetMapping("/all")
    public List<AddressDto> findAll() {
	return addressService.findAll();
    }
}
