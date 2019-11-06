package com.tnt.organization.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tnt.organization.controller.forms.CreateOrganizationForm;
import com.tnt.organization.controller.vo.OrganizationVO;
import com.tnt.organization.controller.vo.Project;
import com.tnt.organization.domain.Organization;
import com.tnt.organization.repository.OrganizationRepository;
import com.tnt.organization.service.ProjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/organizations")
@Api(value = "organizations", description = "This is a dataservice operation on Organizations", tags = "organization")
public class OrganizationController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);
    
    @Autowired
	OrganizationRepository organizationRepository;

    @Autowired
    private ProjectService projectService;
    
    @Autowired
    DiscoveryClient discoveryClient;

	@RequestMapping(value = "/{orgId}", method = RequestMethod.GET)
	@ApiOperation(value = "Get All Organizations existing, in case passed id ", nickname = "findOne")
    public OrganizationVO findOne(@PathVariable(name = "orgId") Integer orgId,
            @RequestParam(required = false) boolean loadProjects) {
        LOGGER.info("Fetching Organization Details with Id " + orgId);
        OrganizationVO organizationVO = new OrganizationVO();
        if (orgId != null && orgId > 0) {
            Organization org = organizationRepository.findById(orgId).orElse(null);
            if (loadProjects && org != null && org.getId() != null) {
                BeanUtils.copyProperties(org, organizationVO);
                organizationVO.setProjects(getAllProjects(org.getId()));
            }
        }
        return organizationVO;
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
	
	@GetMapping(value="/{orgId}/projects")
	public List<Project> getAllProjects(@PathVariable Integer orgId) {
	    List<Project> projects = projectService.getProjects(orgId);
	    List<ServiceInstance> instances = discoveryClient.getInstances("PROJECTSERVICE");
	    instances.forEach(i -> System.out.println(i.getUri()));
        return projects;
	}
}
