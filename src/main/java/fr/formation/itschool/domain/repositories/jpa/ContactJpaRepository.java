package fr.formation.itschool.domain.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.itschool.domain.entities.ContactInfo;

public interface ContactJpaRepository extends JpaRepository<ContactInfo, Long> {

    public boolean existsByEmailIgnoreCase(String email);
}
