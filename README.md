# Project Inquriy APP

This README file contains a detailed description of the Project Review Application. The application is a project management application developed using Spring Boot and includes the following components:

- **Project** : Class representing the project data model.
- **ProjectStatus**: An enum class that determines the project status.
- **ProjectRepository**: A JPA (Java Persistence API) data access layer for storing and querying project data.
- **ProjectDTO**: A data transfer object (DTO) used to transmit project data.
- **ProjectUpdateDTO**: DTO used to communicate project updates.
- **ProjectService**: A service class that implements project business logic.
- **ProjectServiceImpl**: The actual implementation of the service class that implements the project business logic.
- **ProjectMapper**: A Mapper interface and implementation that transforms project objects into DTOs and DTOs into projects.
- **ProjectController**: A controller class that routes HTTP requests related to the project.
- **CorsConfig**: A class that configures CORS (Cross-Origin Resource Sharing) settings.
- **pom.xml**: File containing Maven project dependencies and settings.

  ### Addictions
The project includes the following important dependencies:

- **Spring Boot Starter Data JPA**: Used for database operations.
- **Spring Boot Starter Web**: Spring Boot Starter required for web applications.
- **PostgreSQL**: Used for PostgreSQL database connection.
- **Lombok**: Used to make Java classes simpler.
- **MapStruct**: Used for object transformations.
- **Spring Boot Starter Test**: Used for testing purposes.

## API Endpoints
The application offers the following API endpoints:
1. **List All Projects**:

**Endpoint**: /api/projects/listAll
**HTTP Method**: GET
**Description**: Lists all projects.
**Example Use**: http://localhost:8080/api/projects/listAll

2. **Filtering Projects**:

**Endpoint**: /api/projects/filter
**HTTP Method**: GET
**Description**: Filters projects according to the desired criteria.
**Example Use**: http://localhost:8080/api/projects/filter?projectName=Proje1&projectStatus=IN_PROGRESS

3. **Project Creation**:

**Endpoint**: /api/projects/create
**HTTP Method**: POST
**Description**: Creates a new project.
**Data Body**: ProjectDTO data in JSON format.
**Example Usage**: Send JSON data with a POST request.

4. **Fetching Project Details**:

**Endpoint**: /api/projects/project-details/{id}
**HTTP Method**: GET
**Description**: Gets project details with project ID.
**Example Usage**: http://localhost:8080/api/projects/project-details/1

5. **Project Update**:

**Endpoint**: /api/projects/update/{id}
**HTTP Method**: PUT
**Description**: Updates an existing project.
**Data Body**: ProjectUpdateDTO data in JSON format.
**Example Usage**: JSON data is sent with a PUT request.

6. **Project Delete**:

**Endpoint**: /api/projects/delete/{id}
**HTTP Method**: DELETE
**Description**: Deletes an existing project.
**Example Use**: http://localhost:8080/api/projects/delete/1

### CORS Settings
The app only allows requests from the origin http://localhost:4200. This ensures that the app only accepts requests from a specific origin and is important for security. CORS settings are configured in the CorsConfig class.

### Database Connection
The project works with a PostgreSQL database. You can configure your database connection settings in the application.properties or application.yml file.

Example application.properties file:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/project_database
spring.datasource.username=username
spring.datasource.password=password
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

