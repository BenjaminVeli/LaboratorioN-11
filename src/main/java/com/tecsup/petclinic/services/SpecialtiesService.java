package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Specialties;
import com.tecsup.petclinic.exception.SpecialtiesNotFoundException;

import java.util.List;

public interface SpecialtiesService {

    Specialties create(Specialties specialties);

    Specialties findById(Integer id) throws SpecialtiesNotFoundException;

    void deleteById(Integer id) throws SpecialtiesNotFoundException;

    List<Specialties> findByName(String name);

    List<Specialties> findByOffice(String office);

    List<Specialties> findAll();
}