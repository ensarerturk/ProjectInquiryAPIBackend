package com.ensarerturk.ProjectInquiryApplication.controller;

import com.ensarerturk.ProjectInquiryApplication.dto.ProjectDTO;
import com.ensarerturk.ProjectInquiryApplication.dto.ProjectUpdateDTO;
import com.ensarerturk.ProjectInquiryApplication.model.ProjectStatus;
import com.ensarerturk.ProjectInquiryApplication.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/listAll")
    public List<ProjectDTO> listAllProjects() {
        // Endpoint for listing all projects.
        return projectService.listProjects();
    }

    @GetMapping("/filter")
    public List<ProjectDTO> searchProjects(
            @RequestParam(required = false) String projectName,
            @RequestParam(required = false) String projectTopic,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate,
            @RequestParam(required = false) String projectManager,
            @RequestParam(required = false) ProjectStatus projectStatus,
            @RequestParam(required = false) Integer weeksToEndDate) {
        // Endpoint for searching projects with optional query parameters.
        return projectService.searchProjects(projectName, projectTopic, startDate, endDate, projectManager, projectStatus, weeksToEndDate);
    }

    @PostMapping("/create")
    public ProjectDTO createProject(@RequestBody ProjectDTO projectDTO) {
        // Endpoint for creating a new project.
        return projectService.createProject(projectDTO);
    }

    @GetMapping("/project-details/{id}")
    public ProjectDTO getProjectById(@PathVariable Long id) {
        // Endpoint for retrieving project details by its ID.
        return projectService.getProjectById(id);
    }

    @PutMapping("/update/{id}")
    public ProjectDTO updateProject(@PathVariable Long id, @RequestBody ProjectUpdateDTO ProjectUpdateDTO) {
        // Endpoint for updating an existing project by its ID.
        return projectService.updateProject(id, ProjectUpdateDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable Long id) {
        // Endpoint for deleting a project by its ID.
        projectService.deleteProject(id);
    }
}