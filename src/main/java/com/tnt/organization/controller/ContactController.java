package com.tnt.organization.controller;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tnt.organization.controller.forms.CreateContactForm;
import com.tnt.organization.domain.Contact;
import com.tnt.organization.domain.Contact;
import com.tnt.organization.repository.ContactRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/contacts")
@Api(value = "contacts", description = "This is a dataservice operation on Contacts", tags = "contact")
public class ContactController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);
	
    @Autowired
	ContactRepository contactRepository;

	@RequestMapping(value = "/{contactId}", method = RequestMethod.GET)
	@ApiOperation(value = "Get An organization by id ", nickname = "findAll")
	public List<Contact> getOne(@PathVariable(name = "contactId") Integer contactId) {
	    LOGGER.info("Fetching Contact Details with Id " + contactId);
		if (contactId != null && contactId > 0) {
			return Collections.singletonList(contactRepository.findById(contactId).orElse(null));
		}
		return null;
	}

	@GetMapping
	@ApiOperation(value = "Get All Contacts existing", nickname = "findAll")
	public List<Contact> findAll() {
	    LOGGER.info("Fetching All Contacts");
		return (List<Contact>) contactRepository.findAll();
	}

	@PostMapping
	@ApiOperation(value = "Save a new Contact", nickname = "createContact")
	public Contact createContact(@Valid @RequestBody CreateContactForm createContactForm) {
	    LOGGER.info("Creating Department with Name " + createContactForm.getName());
	    Contact org = new Contact();
		BeanUtils.copyProperties(createContactForm, org);
		contactRepository.save(org);
		LOGGER.info("Contact Created with Id " + org.getId());
		return org;
	}
}
