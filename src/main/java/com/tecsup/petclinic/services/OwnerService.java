package com.tecsup.petclinic.services;

import java.util.List;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

public interface OwnerService {

    Owner create(Owner owner);




    Owner findById(Integer id) throws OwnerNotFoundException;

    List<Owner> findByFirstName(String firstName);

    List<Owner> findByLastName(String lastName);

    List<Owner> findByCity(String city);

    List<Owner> findByTelephone(String telephone);

    List<Owner> findAll();
}
