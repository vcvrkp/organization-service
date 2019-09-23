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

import com.tnt.organization.controller.forms.CreateDepartmentForm;
import com.tnt.organization.domain.Department;
import com.tnt.organization.repository.DepartmentRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/departments")
@Api(value = "departments", description = "This is a dataservice operation on Departments", tags = "department")
public class DepartmentController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
    @Autowired
	DepartmentRepository departmentRepository;

	@RequestMapping(value = "/{departmentId}", method = RequestMethod.GET)
	@ApiOperation(value = "Get An organization by id ", nickname = "findAll")
	public List<Department> getOne(@PathVariable(name = "orgId") Integer departmentId) {
	    LOGGER.info("Fetching Department Details with Id " + departmentId);
		if (departmentId != null && departmentId > 0) {
			return Collections.singletonList(departmentRepository.findById(departmentId).orElse(null));
		}
		return null;
	}

	@GetMapping
	@ApiOperation(value = "Get All Departments existing", nickname = "findAll")
	public List<Department> findAll() {
	    LOGGER.info("Fetching All Orgnizations");
		return (List<Department>) departmentRepository.findAll();
	}

	@PostMapping
	@ApiOperation(value = "Save a new Department", nickname = "createDepartment")
	public Department createDepartment(@Valid @RequestBody CreateDepartmentForm createDepartmentForm) {
	    LOGGER.info("Creating Department with Name " + createDepartmentForm.getName());
		Department org = new Department();
		BeanUtils.copyProperties(createDepartmentForm, org);
		departmentRepository.save(org);
		LOGGER.info("Department Created with Id " + org.getId());
		return org;
	}
}
