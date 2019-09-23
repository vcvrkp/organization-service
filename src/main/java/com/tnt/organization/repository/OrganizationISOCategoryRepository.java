package com.tnt.organization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnt.organization.domain.OrganizationIsoCategory;

public interface OrganizationISOCategoryRepository extends JpaRepository<OrganizationIsoCategory, Integer> {

}
