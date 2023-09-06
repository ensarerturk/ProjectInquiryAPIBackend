package com.ensarerturk.ProjectInquiryApplication.repository;

import com.ensarerturk.ProjectInquiryApplication.model.Project;
import com.ensarerturk.ProjectInquiryApplication.model.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // This query is used to filter projects in the database.
    // Selects projects based on various filtering criteria.
    @Query("SELECT p FROM Project p WHERE " +
            "(:projectName IS NULL OR p.projectName = :projectName) AND " +
            "(:projectTopic IS NULL OR p.projectTopic = :projectTopic) AND " +
            "(:startDate IS NULL OR p.projectStartDate = :startDate) AND " +
            "(:endDate IS NULL OR p.projectEndDate = :endDate) AND " +
            "(:projectManager IS NULL OR p.projectManager = :projectManager) AND " +
            "(:projectStatus IS NULL OR p.projectStatus = :projectStatus) AND " +
            "(:filterEndDate IS NULL OR p.projectEndDate <= :filterEndDate)")
    List<Project> searchProjects(@Param("projectName") String projectName,
                                 @Param("projectTopic") String projectTopic,
                                 @Param("startDate") LocalDate startDate,
                                 @Param("endDate") LocalDate endDate,
                                 @Param("projectManager") String projectManager,
                                 @Param("projectStatus") ProjectStatus projectStatus,
                                 @Param("filterEndDate") LocalDate filterEndDate);
}
