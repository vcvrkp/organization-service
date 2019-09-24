package com.tnt.organization.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tnt.organization.controller.vo.Project;

@FeignClient(name = "PROJECTSERVICE", fallback = DummyProjectService.class)
public interface ProjectService {

    @RequestMapping(method = RequestMethod.GET, value = "/projects")
    List<Project> getProjects(@RequestParam(required = false) Integer orgId);

}

@Component
class DummyProjectService implements ProjectService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DummyProjectService.class);

    @Override
    public List<Project> getProjects(Integer orgId) {
        final String METHOD_NAME = "getProjects() ->";
        LOGGER.debug(METHOD_NAME + "Entering");
        Project proj = new Project();
        proj.setId(0);
        proj.setName("fallbackName");
        List<Project> projects = new ArrayList<Project>();
        projects.add(proj);
        LOGGER.debug(METHOD_NAME + "Exiting");
        return projects;
    }

}