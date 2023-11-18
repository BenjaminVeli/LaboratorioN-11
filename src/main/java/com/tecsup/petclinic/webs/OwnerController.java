package com.tecsup.petclinic.webs;

import com.tecsup.petclinic.domain.OwnerTO;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.mapper.OwnerMapper;
import com.tecsup.petclinic.services.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class OwnerController {

    //@Autowired
    private OwnerService ownerService;

    //@Autowired
    private OwnerMapper mapper;

    /**
     *  Change
     * @param ownerService
     * @param mapper
     */
    public OwnerController(OwnerService ownerService, OwnerMapper mapper){
        this.ownerService = ownerService;
        this.mapper = mapper;
    }

    /**
     * Get all owners
     *
     * @return
     */
    @GetMapping(value = "/owners")
    public ResponseEntity<List<OwnerTO>> findAllPets() {

        List<Owner> owners = (List<Owner>) ownerService.findAll();
        log.info("owners: " + owners);
        owners.forEach(item -> log.info("Owner >>  {} ", item));

        List<OwnerTO> ownersTO = this.mapper.toOwnerTOList(owners);
        log.info("petsTO: " + ownersTO);
        ownersTO.forEach(item -> log.info("PetTO >>  {} ", item));

        return ResponseEntity.ok(ownersTO);

    }




}
