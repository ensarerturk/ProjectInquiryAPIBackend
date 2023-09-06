package com.ensarerturk.ProjectInquiryApplication.service.impl;

import com.ensarerturk.ProjectInquiryApplication.dto.ProjectDTO;
import com.ensarerturk.ProjectInquiryApplication.mapper.ProjectMapper;
import com.ensarerturk.ProjectInquiryApplication.dto.ProjectUpdateDTO;
import com.ensarerturk.ProjectInquiryApplication.handle.ProjectNotFoundException;
import com.ensarerturk.ProjectInquiryApplication.model.Project;
import com.ensarerturk.ProjectInquiryApplication.model.ProjectStatus;
import com.ensarerturk.ProjectInquiryApplication.repository.ProjectRepository;
import com.ensarerturk.ProjectInquiryApplication.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public List<ProjectDTO> listProjects() {
        // Retrieves all projects from the database, converts them to ProjectDTO and returns a list.
        List<Project> projects = projectRepository.findAll();
        return projects.stream()
                .map(projectMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProjectDTO> searchProjects(String projectName, String projectTopic, LocalDate startDate,
                                           LocalDate endDate, String projectManager, ProjectStatus projectStatus,
                                           Integer weeksToEndDate) {
        // Searches for projects based on specified criteria, converts them to ProjectDTO and returns a list.
        LocalDate filterEndDate = null;
        if (weeksToEndDate != null) {
            filterEndDate = LocalDate.now().plusWeeks(weeksToEndDate);
        }

        List<Project> projects = projectRepository.searchProjects(projectName, projectTopic, startDate, endDate,
                projectManager, projectStatus, filterEndDate);
        return projects.stream()
                .map(projectMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        // Creates a new project, saves it to the database and returns the created project.
        Project project = projectRepository.save(projectMapper.toEntity(projectDTO));
        return projectMapper.toDTO(project);
    }

    @Override
    public ProjectDTO getProjectById(Long id) {
        // Finds and returns the project with the specified project ID.
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("No project found: " + id));
        return projectMapper.toDTO(project);
    }

    @Override
    public ProjectDTO updateProject(Long id, ProjectUpdateDTO ProjectUpdateDTO) {
        // Updates the project with the specified project ID, saves it to the database and returns the updated project.
        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("No project found: " + id));

        projectMapper.updateProjectFromDTO(ProjectUpdateDTO, existingProject);
        Project updatedProject = projectRepository.save(existingProject);

        return projectMapper.toDTO(updatedProject);
    }

    @Override
    public void deleteProject(Long id) {
        // Deletes the project with the specified project ID from the database.
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("No project found: " + id));

        projectRepository.delete(project);
    }
}