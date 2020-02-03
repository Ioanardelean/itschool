package fr.formation.itschool.domain.repositories.jpa;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.itschool.domain.dtos.CreatePersonDto;
import fr.formation.itschool.domain.entities.Person;

/**
 * @author Administrateur
 */
public interface PersonJpaRepository extends JpaRepository<Person, Long> {

    void save(@Valid CreatePersonDto dto);

    public boolean existsBySocialSecNumber(String SocialSecNumber);
}
