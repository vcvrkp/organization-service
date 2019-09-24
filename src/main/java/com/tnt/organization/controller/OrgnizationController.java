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

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.tnt.organization.controller.forms.CreateOrganizationForm;
import com.tnt.organization.domain.Organization;
import com.tnt.organization.repository.OrganizationRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/organizations")
@Api(value = "organizations", description = "This is a dataservice operation on Organizations", tags = "organization")
public class OrgnizationController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(OrgnizationController.class);
    
    @Autowired
	OrganizationRepository organizationRepository;

	@RequestMapping(value = "/{orgId}", method = RequestMethod.GET)
	@ApiOperation(value = "Get All Organizations existing, in case passed id ", nickname = "findOne")
	public List<Organization> findOne(@PathVariable(name = "orgId") Integer orgId) {
	    LOGGER.info("Fetching Organization Details with Id " + orgId);
		if (orgId != null && orgId > 0) {
			return Collections.singletonList(organizationRepository.findById(orgId).orElse(null));
		}
		return null;
	}

	@GetMapping
	@ApiOperation(value = "Get All Organizations existing, in case passed id ", nickname = "findAll")
	public List<Organization> findAll() {
	    LOGGER.info("Fetching All Orgnizations");
		return (List<Organization>) organizationRepository.findAll();
	}

	@PostMapping
	@ApiOperation(value = "Save a new Organization", nickname = "createOrganization")
	public Organization createOrganization(@Valid @RequestBody CreateOrganizationForm createOrganizationForm) {
	    LOGGER.info("Creating Organization with Name " + createOrganizationForm.getName());
		Organization org = new Organization();
		BeanUtils.copyProperties(createOrganizationForm, org);
		organizationRepository.save(org);
		LOGGER.info("Organization Created with Id " + org.getId());
		return org;
	}
}
