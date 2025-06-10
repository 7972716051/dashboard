package com.party.dashboard;

import com.party.dashboard.model.Party;
import com.party.dashboard.model.User;

import com.party.dashboard.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Controller {

	@Autowired
	private PartyService partyService;
	@GetMapping("/test")
	ResponseEntity<User> testAPI() {
		User user = new User();
		
		return new ResponseEntity<>(user,HttpStatus.OK);
	}

	@GetMapping("/login")
	ResponseEntity<User> validateLogin(@RequestParam String username, @RequestParam String password){
		User response = partyService.validateUser(username, password);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/login/users")
	ResponseEntity<List<User>> getUserList(){
		List<User> response = partyService.getUsers();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/login")
	ResponseEntity<User> validateLogin(@RequestBody User user){
		User response = partyService.registerUser(user);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/party")
	ResponseEntity<Party> saveParty(@RequestBody Party party){
		Party response = partyService.saveParty(party);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("/party/{partyId}")
	ResponseEntity<Party> getParty(@PathVariable("partyId") String partyId){
		Party response = partyService.getParty(partyId);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@PutMapping("/party")
	ResponseEntity<Party> updatePerson(@RequestBody Party party){
		Party response = partyService.updateParty(party);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("/party")
	ResponseEntity<List<Party>> getParties(){
		return new ResponseEntity<>(partyService.getParties(), HttpStatus.OK);

	}

	@DeleteMapping("/party/{id}")
	ResponseEntity<String> deleteParties(@PathVariable("id") String id){
		partyService.deleteParty(id);
		return new ResponseEntity<>("Deleted successfully",HttpStatus.NO_CONTENT);
	}

}
