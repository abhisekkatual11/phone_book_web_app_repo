package com.phone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phone.binding.Contact;

@Repository
public interface PhoneBookRepository extends JpaRepository<Contact, Integer> {

	Contact findByContactId(Integer contactId);

	void deleteByContactId(Integer contactId);

//	Contact findByContactId(Integer contactId);
//	void deleteByContactId(Integer contactId);
	
	
	
}