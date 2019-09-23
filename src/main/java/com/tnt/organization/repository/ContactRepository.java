package com.tnt.organization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnt.organization.domain.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
