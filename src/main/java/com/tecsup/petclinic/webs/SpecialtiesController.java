package com.tecsup.petclinic.webs;

import com.tecsup.petclinic.entities.Specialties;
import com.tecsup.petclinic.mapper.SpecialtiesMapper;
import com.tecsup.petclinic.services.SpecialtiesService;
import com.tecsup.petclinic.exception.SpecialtiesNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
@RestController
@Slf4j
public class SpecialtiesController {

    //@Autowired
    private SpecialtiesService specialtiesService;

    //@Autowired
    private SpecialtiesMapper mapper;

    /**
     *  Change
     * @param specialtiesService
     * @param mapper
     */
    public SpecialtiesController(SpecialtiesService specialtiesService, SpecialtiesMapper mapper){
        this.specialtiesService = specialtiesService;
        this.mapper = mapper;
    }

    /**
     * Get all owners
     *
     * @return
     */
    @GetMapping(value = "/specialties")
    public ResponseEntity<List<Specialties>> findAllPets() {

        List<Specialties> specialties = (List<Specialties>) specialtiesService.findAll();
        log.info("specialties: " + specialties);
        specialties.forEach(item -> log.info("Specialties >>  {} ", item));

        List<Specialties> specialtiesTO = this.mapper.toSpecialtiesList(specialties);
        log.info("petsTO: " + specialtiesTO);
        specialtiesTO.forEach(item -> log.info("PetTO >>  {} ", item));

        return ResponseEntity.ok(specialtiesTO);

    }



    @DeleteMapping(value = "/specialties/{specialtiesId}")
    public ResponseEntity<Void> deleteSpecialties(@PathVariable Integer specialtiesId) {
        try {
            specialtiesService.deleteById(specialtiesId);
            return ResponseEntity.noContent().build();
        } catch (SpecialtiesNotFoundException e) {
            log.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * Búsqueda una especialidad por su ID
     *
     * @param specialtiesId El ID de la especialidad a buscar
     * @return
     */
    @GetMapping(value = "/specialties/{specialtiesId}")
    public ResponseEntity<Specialties> findSpecialtiesById(@PathVariable Integer specialtiesId) {
        try {
            Specialties specialties = specialtiesService.findById(specialtiesId);
            log.info("Specialties found by ID: {}", specialties);
            return ResponseEntity.ok(specialties);
        } catch (SpecialtiesNotFoundException e) {
            log.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
    /**
     * Crear una nueva especialidad
     *
     * @param specialties La especialidad a crear
     * @return
     */
    @PostMapping(value = "/specialties")
    public ResponseEntity<Specialties> createSpecialties(@RequestBody Specialties specialties) throws URISyntaxException {
        Specialties createdSpecialties = specialtiesService.create(specialties);
        log.info("Specialties created: {}", createdSpecialties);

        return ResponseEntity.created(new URI("/specialties/" + createdSpecialties.getId()))
                .body(createdSpecialties);
    }

    /**
     * Actualizar una especialidad por su ID
     *
     * @param specialtiesId El ID de la especialidad a actualizar
     * @param updatedSpecialties La información actualizada de la especialidad
     * @return
     */
    @PutMapping(value = "/specialties/{specialtiesId}")
    public ResponseEntity<Specialties> updateSpecialties(
            @PathVariable Integer specialtiesId,
            @RequestBody Specialties updatedSpecialties) {
        try {
            Specialties existingSpecialties = specialtiesService.findById(specialtiesId);
            existingSpecialties.setName(updatedSpecialties.getName());
            existingSpecialties.setOffice(updatedSpecialties.getOffice());
            existingSpecialties.setOpen(updatedSpecialties.getOpen());
            existingSpecialties.setClose(updatedSpecialties.getClose());

            Specialties updatedEntity = specialtiesService.create(existingSpecialties);

            log.info("Specialties updated: {}", updatedEntity);
            return ResponseEntity.ok(updatedEntity);
        } catch (SpecialtiesNotFoundException e) {
            log.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }


}