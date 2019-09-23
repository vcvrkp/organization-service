package com.tnt.organization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnt.organization.domain.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

}
