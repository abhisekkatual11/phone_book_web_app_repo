package com.phone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phone.binding.Contact;
import com.phone.service.PhoneBookService;

@RestController
public class PhoneBookRestController {

//	private static final Logger logger= LoggerFactory.getLogger(PhoneBookRestController.class);
//	
//	@PostMapping(value = "/save")
//	public ResponseEntity<String> createContact(@RequestBody Contact contact ) {
//		phoneSer.svaeContacts(contact);
//		return new ResponseEntity<String>("Contact Saved Successfully", HttpStatus.CREATED);
//	}
//	
//	@GetMapping(value = "/fetch")
//	public ResponseEntity<List<Contact>> displayAllContact() {
//		return new ResponseEntity<List<Contact>>(phoneSer.getAllContacts(), HttpStatus.OK);
//	}
//	
//	@PutMapping(value = "/update/{contactId}")
//	public ResponseEntity<Contact> updateContactDetails(Integer contactId) {
//		return new ResponseEntity<Contact>(phoneSer.updateContact(contactId), HttpStatus.OK);
//	}
//	
//	@DeleteMapping(value = "/delete/{contactId}")
//	public ResponseEntity<String> deleteContactDetails(Integer contactId) {
//		phoneSer.deleteContact(contactId);
//		return new ResponseEntity<String>("Delete Contact Contact", HttpStatus.OK);
//	}

	@Autowired
	private PhoneBookService phoneSer;
	
	@PostMapping(value = "/save")
	public ResponseEntity<String> saveContact(@RequestBody Contact contact){
		return new ResponseEntity<String>(phoneSer.saveContact(contact), HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<Contact>> getAllContactsss(){
		return new ResponseEntity<List<Contact>>(phoneSer.getAllContacts(), HttpStatus.OK);
	}
	
	@GetMapping("/update")
	public ResponseEntity<String> updateContact(@RequestBody Contact contact){
		return new ResponseEntity<String>(phoneSer.updateContact(contact), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{contactId}")
	public ResponseEntity<String> deleteContact(Integer contactId){
		return new ResponseEntity<String>(phoneSer.deleteContactById(contactId), HttpStatus.OK);
	}
}
