package com.phone.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.phone.binding.Contact;
import com.phone.repository.PhoneBookRepository;

public class PhoneBookServiceImpl implements PhoneBookService {

//	@Override
//	public void svaeContacts(Contact contact) {
//	}
//	@Override
//	public List<Contact> getAllContacts() {
//		return null;
//	}
//	@Override
//	public Contact updateContact(Integer contactId) {
//		phoneRepo.findByContactId(contactId);
//		return null;
//	}
//	@Override
//	public void deleteContact(Integer contactId) {
//		phoneRepo.deleteByContactId(contactId);
//	}
//	@Override
//	public Contact getContactId(Integer contactId) {
//		return null;
//	}

	@Autowired
	private PhoneBookRepository phoneRepo;

	String contactName;
	String contactEmail;
	Long contactPhoneNumber;

	public void scannerClass() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name : ");
		contactName = sc.next();
		System.out.println("Enter your email : ");
		contactEmail = sc.next();
		System.out.println("Enter your number : ");
		contactPhoneNumber = sc.nextLong();
	}

	@Override
	public String saveContact(Contact contact) {

		scannerClass();

		contact.setContactName(contactName);
		contact.setContactEmail(contactEmail);
		contact.setContactPhoneNumber(contactPhoneNumber);

		phoneRepo.save(contact);
		String msg = "Record Saved successfully";

		return msg;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> list = phoneRepo.findAll();
		return list;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Contact byContactId = phoneRepo.findByContactId(contactId);
		if (byContactId != null) {
			return byContactId;
		} else {
			return null;
		}
	}

	@Override
	public String updateContact(Contact contact) {
		Integer contactId = contact.getContactId();
		Contact byContactId = getContactById(contactId);

		if (byContactId != null) {

			scannerClass();

			byContactId.setContactName(contactName);
			byContactId.setContactEmail(contactEmail);
			byContactId.setContactPhoneNumber(contactPhoneNumber);

			phoneRepo.save(byContactId);

			return "Update Successfully";
		} else {
			return "invalid Id";
		}
	}

	@Override
	public String deleteContactById(Integer contactId) {
		Contact byContactId = getContactById(contactId);
		if (byContactId!=null) {
			phoneRepo.deleteByContactId(contactId);
			return "deleteed Successfully";
		} else {
			return "Invalid Id";
		}
	}

}
