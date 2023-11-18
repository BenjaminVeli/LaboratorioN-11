package com.tecsup.petclinic.services;

import java.util.List;
import java.util.Optional;

import com.tecsup.petclinic.entities.Specialties;

import com.tecsup.petclinic.exception.SpecialtiesNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.entities.Owner;

import com.tecsup.petclinic.repositories.SpecialtiesRepository;

@Service
@Slf4j
public class SpecialtiesServiceImpl implements SpecialtiesService {

    private final SpecialtiesRepository specialtiesRepository;

    public SpecialtiesServiceImpl(SpecialtiesRepository specialtiesRepository) {
        this.specialtiesRepository = specialtiesRepository;
    }

    @Override
    public Specialties create(Specialties specialties) {
        return specialtiesRepository.save(specialties);
    }

    @Override
    public Specialties findById(Integer id) throws SpecialtiesNotFoundException {
        Optional<Specialties> specialties = specialtiesRepository.findById(id);
        if (!specialties.isPresent()) {
            throw new SpecialtiesNotFoundException("Specialties not found with id: " + id);
        }
        return specialties.get();
    }

    @Override
    public void deleteById(Integer id) throws SpecialtiesNotFoundException {
        if (!specialtiesRepository.existsById(id)) {
            throw new SpecialtiesNotFoundException("Specialties not found with id: " + id);
        }
        specialtiesRepository.deleteById(id);
    }

    @Override
    public List<Specialties> findByName(String name) {
        return specialtiesRepository.findByName(name);
    }

    @Override
    public List<Specialties> findByOffice(String office) {
        return specialtiesRepository.findByOffice(office);
    }

    @Override
    public List<Specialties> findAll() {
        return (List<Specialties>) specialtiesRepository.findAll();
    }
}
