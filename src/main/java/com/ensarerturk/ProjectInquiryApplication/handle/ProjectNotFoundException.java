package com.ensarerturk.ProjectInquiryApplication.handle;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(String message) {
        super(message);
    }
}
