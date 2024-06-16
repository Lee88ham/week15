package pet.store.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.PetStore;

@Data
@NoArgsConstructor
public class PetStoreData {

		private Long petStoreId;
		private String petStoreName;
		private String petStoreAddress;
		private String city;
		private String state;
		private String zip;
		private String petStorePhone;
		
		public PetStoreData (PetStore petStore)  {
			petStoreId = petStore.getPetStoreId();
			petStoreName = petStore.getPetStoreName();
			petStoreAddress = petStore.getPetStoreAddress();
			city= petStore.getCity();
			state = petStore.getState();
			zip = petStore.getZip();
			petStorePhone = petStore.getPetStorePhone();
		}
		
		private Set<PetStoreCustomer> customers = new HashSet<>();
			
		
		private Set<PetStoreEmployee> employees = new HashSet<>();
		
	}

