package pet.store.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreData;
import pet.store.controller.model.PetStoreEmployee;
import pet.store.service.PetStoreService;

@RestController
@RequestMapping("/pet_store")
@Slf4j
public class PetStoreController {
	
	@Autowired
	private PetStoreService petStoreService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreData insertPetStore(@RequestBody PetStoreData petStoreData) {
		
		log.info("Creating pet store with ", petStoreData);
		
		return petStoreService.savePetStore(petStoreData);
	}
	@PutMapping("/{petStoreId}")
	public PetStoreData modifyPetStore(@PathVariable Long petStoreId, @RequestBody PetStoreData petStoreData) {
		
		petStoreData.setPetStoreId(petStoreId);
		
		log.info("Modifying pet store with " + petStoreData);
		
		return petStoreService.savePetStore(petStoreData);
	}
	
	
	@PostMapping("/{petStoreId}/employee")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreEmployee insertEmployee(@RequestBody PetStoreEmployee petStoreEmployee, @PathVariable Long petStoreId) {
		
		log.info("Adding employee {} for pet store with ID= {}", petStoreEmployee, petStoreId);
		return petStoreService.saveEmployee(petStoreEmployee, petStoreId);
	}
	@GetMapping("/petStore")
	public List<PetStoreData>retrieveAllPetStores() {
		log.info("Retrieve all pet stores");
		return petStoreService.retrieveAllPetStores();
	}
	
	@GetMapping("/petStore/{petStoreId}")
	public PetStoreData retrievePetStoreById(@PathVariable Long petStoreId) {
		log.info("Retrieveing pet store with ID={} ", petStoreId);
		
		return petStoreService.retrievePetStoreById(petStoreId);
	}
	
	public Map<String, String> deletePetStoreById(@PathVariable Long petStoreId) {
		log.info("Deleting pet store by ID={}", petStoreId);
		petStoreService.deletePetStoreById(petStoreId);
		
		return Map.of("message", "Deletion of pet store with ID=" + petStoreId + " was successful.");
	}
}




