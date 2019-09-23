package com.tnt.organization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnt.organization.domain.OrganizationType;

public interface OrganizationTypeRepository extends JpaRepository<OrganizationType, Integer> {

}
