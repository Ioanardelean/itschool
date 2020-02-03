package fr.formation.itschool.domain.repositories.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.formation.itschool.domain.entities.Address;
import fr.formation.itschool.domain.repositories.custom.TestRepository;

@Repository
public class TestRepositoryImpl implements TestRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void save(Address address) {
	em.persist(address);
    }

    @Override
    @Transactional
    public void deleteAddress(Long id) {
	// repo.deleteAddress(id);
	String jpql = "delete Address where id = :id";
	Query query = em.createQuery(jpql);
	query.setParameter("id", id);
	int count = query.executeUpdate();
	System.out.println("#delete=" + count);
	em.close();
    }

    @Override
    public List<Address> allAddresses() {
	String jpql = "select a from Address a";
	Query query = em.createQuery(jpql);
	return query.getResultList();
    }
}
