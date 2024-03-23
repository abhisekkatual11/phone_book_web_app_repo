package com.phone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.phone.binding.Contact;

@Service
public interface PhoneBookService {
//	void svaeContacts(Contact contact);
//	List<Contact> getAllContacts();
//	Contact getContactId(Integer contactId);
//	Contact updateContact(Integer contactId);
//	void deleteContact(Integer contactId);
	
	public String saveContact(Contact contact);
	public List<Contact> getAllContacts();
	public Contact getContactById(Integer contactId);
	public String updateContact(Contact contact);
	public String deleteContactById(Integer contactId);
}
