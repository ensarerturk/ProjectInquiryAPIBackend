package com.ensarerturk.ProjectInquiryApplication.dto;

import com.ensarerturk.ProjectInquiryApplication.model.ProjectStatus;

import java.time.LocalDate;

public record ProjectDTO(
        Long id,
        String projectName,
        String projectTopic,
        LocalDate projectStartDate,
        LocalDate projectEndDate,
        String projectManager,
        ProjectStatus projectStatus
) {}
