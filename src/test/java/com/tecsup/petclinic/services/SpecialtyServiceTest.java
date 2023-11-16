package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class SpecialtyServiceTest {

	@Autowired
	private OwnerService ownerService;

	@Test
	public void testFindOwnerById() {
		String FIRST_NAME_EXPECTED = "George";
		Integer ID = 1;

		Owner owner = null;

		try {
			owner = ownerService.findById(ID);
		} catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}

		assertEquals(FIRST_NAME_EXPECTED, owner.getFirstName());
	}

	@Test
	public void testFindOwnerByFirstName() {
		String FIND_FIRST_NAME = "George";
		int SIZE_EXPECTED = 1;

		List<Owner> owners = ownerService.findByFirstName(FIND_FIRST_NAME);

		assertEquals(SIZE_EXPECTED, owners.size());
	}

	@Test
	public void testFindOwnerByLastName() {
		String FIND_LAST_NAME = "Davis";
		int SIZE_EXPECTED = 2;

		List<Owner> owners = ownerService.findByLastName(FIND_LAST_NAME);

		assertEquals(SIZE_EXPECTED, owners.size());
	}

	@Test
	public void testFindOwnerByCity() {
		String FIND_CITY = "Madison";
		int SIZE_EXPECTED = 4;

		List<Owner> owners = ownerService.findByCity(FIND_CITY);

		assertEquals(SIZE_EXPECTED, owners.size());
	}

	@Test
	public void testFindOwnerByTelephone() {
		String FIND_TELEPHONE = "6085553198";
		int SIZE_EXPECTED = 1;

		List<Owner> owners = ownerService.findByTelephone(FIND_TELEPHONE);

		assertEquals(SIZE_EXPECTED, owners.size());
	}

	@Test
	public void testCreateOwner() {
		String FIRST_NAME = "Benjamín Jhosep";
		String LAST_NAME = "Veli Mariano";
		String ADDRESS = "Miguel Grau";
		String CITY = "Lima";
		String TELEPHONE = "969128835";

		Owner owner = new Owner(FIRST_NAME, LAST_NAME, ADDRESS, CITY, TELEPHONE);

		Owner ownerCreated = ownerService.create(owner);

		log.info("OWNER CREATED: " + ownerCreated.toString());

		assertNotNull(ownerCreated.getId());
		assertEquals(FIRST_NAME, ownerCreated.getFirstName());
		assertEquals(LAST_NAME, ownerCreated.getLastName());
		assertEquals(ADDRESS, ownerCreated.getAddress());
		assertEquals(CITY, ownerCreated.getCity());
		assertEquals(TELEPHONE, ownerCreated.getTelephone());
	}

	@Test
	public void testDeleteOwner() {
		String FIRST_NAME = "Betty";
		String LAST_NAME = "Davis";
		String ADDRESS = "110 W. Liberty St.";
		String CITY = "Madison";
		String TELEPHONE = "6085551023";

		// Crear un nuevo propietario
		Owner owner = new Owner(FIRST_NAME, LAST_NAME, ADDRESS, CITY, TELEPHONE);
		Owner ownerCreated = ownerService.create(owner);

		// Obtener el ID del propietario creado
		Integer ownerId = ownerCreated.getId();

		// Verificar que el propietario se haya creado correctamente
		assertNotNull(ownerId);

		// Eliminar el propietario por ID
		try {
			ownerService.deleteById(ownerId);
		} catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}

		// Intentar obtener el propietario nuevamente debería lanzar una excepción
		assertThrows(OwnerNotFoundException.class, () -> ownerService.findById(ownerId));
	}

}
