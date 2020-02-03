package fr.formation.itschool.domain.repositories.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.itschool.domain.entities.Address;

public interface AddressJpaRepository extends JpaRepository<Address, Long> {

    List<Address> findByZipCode(String zipCode);

    List<Address> findByCityIgnoreCase(String city);

    @Query("select a from Address a where a.zipCode = ?1 and a.city = ?2")
    List<Address> getAddressesByCriteria(String zipCode, String city);
}
