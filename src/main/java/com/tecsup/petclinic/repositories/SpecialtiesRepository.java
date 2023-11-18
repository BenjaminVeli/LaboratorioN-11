package com.tecsup.petclinic.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tecsup.petclinic.entities.Specialties;

import java.util.List;

@Repository
public interface SpecialtiesRepository
        extends CrudRepository<Specialties, Integer> {

    List<Specialties> findByName(String name);

    List<Specialties> findByOffice(String office);

    @Override
    List<Specialties> findAll();
}
