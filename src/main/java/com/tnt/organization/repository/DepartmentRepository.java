package com.tnt.organization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnt.organization.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
