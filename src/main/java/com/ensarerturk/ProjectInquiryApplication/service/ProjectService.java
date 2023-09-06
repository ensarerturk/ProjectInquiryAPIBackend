package com.ensarerturk.ProjectInquiryApplication.service;

import com.ensarerturk.ProjectInquiryApplication.dto.ProjectDTO;
import com.ensarerturk.ProjectInquiryApplication.dto.ProjectUpdateDTO;
import com.ensarerturk.ProjectInquiryApplication.model.Project;
import com.ensarerturk.ProjectInquiryApplication.model.ProjectStatus;
import com.ensarerturk.ProjectInquiryApplication.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface ProjectService {
    // Defines the method for listing all projects.
    List<ProjectDTO> listProjects();

    // Defines the method for searching projects based on specific criteria.
    List<ProjectDTO> searchProjects(String projectName, String projectTopic, LocalDate startDate, LocalDate endDate, String projectManager, ProjectStatus projectStatus, Integer weeksToEndDate);

    // Defines the method for creating a new project.
    ProjectDTO createProject(ProjectDTO projectDTO);

    // Defines the method for getting project information by its ID.
    ProjectDTO getProjectById(Long id);

    // Defines the method for updating a project.
    ProjectDTO updateProject(Long id, ProjectUpdateDTO ProjectUpdateDTO);

    // Defines the method for deleting a project.
    void deleteProject(Long id);
}