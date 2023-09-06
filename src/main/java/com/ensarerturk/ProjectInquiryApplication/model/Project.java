package com.ensarerturk.ProjectInquiryApplication.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String projectName;

    @Column
    private String projectTopic;

    @Column
    private LocalDate projectStartDate;

    @Column
    private LocalDate projectEndDate;

    @Column
    private String projectManager;

    @Enumerated(EnumType.STRING)
    @Column
    private ProjectStatus projectStatus;
}
