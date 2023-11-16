package com.tecsup.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tecsup.petclinic.entities.Owner;

import java.util.List;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Integer> {

    // Fetch owners by first name
    List<Owner> findByFirstName(String firstName);

    // Fetch owners by last name
    List<Owner> findByLastName(String lastName);

    // Fetch owners by city
    List<Owner> findByCity(String city);

    // Fetch owners by telephone
    List<Owner> findByTelephone(String telephone);

    @Override
    List<Owner> findAll();
}
