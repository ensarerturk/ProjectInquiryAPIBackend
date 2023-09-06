package com.ensarerturk.ProjectInquiryApplication.mapper;

import com.ensarerturk.ProjectInquiryApplication.dto.ProjectDTO;
import com.ensarerturk.ProjectInquiryApplication.dto.ProjectUpdateDTO;
import com.ensarerturk.ProjectInquiryApplication.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ProjectMapper {
    // This method maps a Project object to a ProjectDTO object.
    ProjectDTO toDTO(Project project);

    // This method maps a ProjectDTO object to a Project object.
    @Mapping(target = "id", ignore = true)
    Project toEntity(ProjectDTO projectDTO);

    // This method updates an existing Project entity with information from a ProjectUpdateDTO.
    void updateProjectFromDTO(ProjectUpdateDTO ProjectUpdateDTO, @MappingTarget Project project);
}