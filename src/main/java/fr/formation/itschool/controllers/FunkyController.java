package fr.formation.itschool.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.itschool.domain.dtos.FunkyDto;

@RequestMapping("/funky")
@RestController
public class FunkyController {

    private Map<String, FunkyDto> dd = new HashMap<>();

    public FunkyController() {
	dd.put("Frank", new FunkyDto("Marshall"));
	dd.put("Morgan", new FunkyDto("Laubier"));
	dd.put("Ion", new FunkyDto("Ardelean"));
    }

    @GetMapping("/whoIs/{name}")
    public FunkyDto whoIs(@PathVariable("name") String name) {
	return dd.get(name);
    }

    @GetMapping("/keys")
    public Set<String> keys() {
	return dd.keySet();
    }
}
