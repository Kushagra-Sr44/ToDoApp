# ToDoApp

A Spring Boot-based ToDo List application with MongoDB integration, user authentication, and a web-based interface.

## Features

- **User Authentication**: Secure login and registration with Spring Security
- **MongoDB Database**: Persistent data storage for tasks and user information
- **Web Interface**: Interactive web-based UI for managing tasks
- **Task Management**: Create, read, update, and delete tasks
- **RESTful API**: Backend APIs for all CRUD operations
- **Development Tools**: Spring Boot DevTools for rapid development

## Tech Stack

- **Backend**: Java 17, Spring Boot 4.0.5
- **Database**: MongoDB
- **Security**: Spring Security
- **Build Tool**: Maven
- **Additional Libraries**: 
  - Lombok (for reducing boilerplate code)
  - Spring Data MongoDB (for database operations)

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- MongoDB instance running locally or accessible via connection string

## Project Structure

```
ToDoList App/
├── src/
│   ├── main/
│   │   ├── java/         # Java source code
│   │   └── resources/    # Configuration files
│   └── test/             # Test cases
├── pom.xml               # Maven configuration
├── mvnw                  # Maven wrapper (Linux/Mac)
└── mvnw.cmd              # Maven wrapper (Windows)
```

## Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/Kushagra-Sr44/ToDoApp.git
cd ToDoApp
```

### 2. Configure MongoDB
Update the MongoDB connection string in `application.properties` or `application.yml`:
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/todoapp
```

### 3. Build the Project
Using Maven wrapper:
```bash
./mvnw clean package
```

Or using installed Maven:
```bash
mvn clean package
```

### 4. Run the Application
```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

### Authentication
- `POST /api/auth/register` - Register a new user
- `POST /api/auth/login` - Login with credentials

### Tasks
- `GET /api/tasks` - Get all tasks
- `POST /api/tasks` - Create a new task
- `GET /api/tasks/{id}` - Get task by ID
- `PUT /api/tasks/{id}` - Update a task
- `DELETE /api/tasks/{id}` - Delete a task

## Development

### Using Spring Boot DevTools
The project includes Spring Boot DevTools for automatic restart and live reload during development.

### Running Tests
```bash
./mvnw test
```

## Dependencies

### Core
- `spring-boot-starter-webmvc` - Web MVC support
- `spring-boot-starter-data-mongodb` - MongoDB integration
- `spring-boot-starter-security` - Security features

### Development
- `spring-boot-devtools` - Development tools for faster iteration
- `lombok` - Annotation processor for boilerplate reduction

### Testing
- `spring-boot-starter-data-mongodb-test` - MongoDB test support
- `spring-boot-starter-webmvc-test` - Web MVC test support

## Contributing

Feel free to fork this repository and submit pull requests for improvements.

## License

This project is open source and available on GitHub.

## Support

For issues, questions, or suggestions, please open an issue on the GitHub repository.

---

**Created**: April 2026  
**Repository**: [Kushagra-Sr44/ToDoApp](https://github.com/Kushagra-Sr44/ToDoApp)