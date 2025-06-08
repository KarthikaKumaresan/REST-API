Task Execution REST API
This project is a Spring Boot REST API to manage and execute shell tasks. Each task includes a command that can be run, and the output along with start and end times is recorded in MongoDB Atlas.

Tech stack
-Java 17
-Spring Boot (via Spring Initializr)
-Spring Web
-Spring Data MongoDB
-MongoDB Atlas
-Eclipse IDE
-Postman (for testing)

Project Structure
-Task.java – Defines the task entity.
-TaskExecution.java – Captures each command execution's start time, end time, and output.
-TaskController.java – REST endpoints to create, retrieve, update, delete, and execute tasks.
-TaskApplication.java – Main class to run the application.
-TaskRepository.java – Interface extending MongoRepository.

Steps to Run
1. Setup
-Open Spring Initializr
-Add dependencies: Spring Web, Spring Data MongoDB
-Download the zip and import it in Eclipse 

2. MongoDB Atlas Setup
-Create a free MongoDB cluster at MongoDB Atlas
-Create a database and collection
-Add your connection URI in application.properties:

3. Creating REST API
In Eclipse:
Create the following:
-Model/Task.java
-Model/TaskExecuion.java
-Controller/TaskController.java
-Repository/TaskRepository.java
-TaskApplication.java (with main method)

4.Running the Application
-Run the TaskApplication.java code file
-Server runs on: http://localhost:8080

5.Testing the API
-Test all API endpoints using Postman

1. GET    ------ `/tasks`                     | Get all tasks ![Screenshot (254)](https://github.com/user-attachments/assets/bd04a4a6-7e41-4d66-af89-a4f1cf2d21c1)
2. POST   ------ `/tasks`                     | Create a new task ![Screenshot 2025-06-08 210327](https://github.com/user-attachments/assets/1726cce1-ab83-48a3-b80b-30e0ada61908)            
3. GET    ------ `/tasks/{id}`                | Get a task by ID ![Screenshot (257)](https://github.com/user-attachments/assets/4cc13e93-fe11-4d4a-aa6c-a22ac1546339)
4. PUT    ------ `/tasks/{id}`                | Update a task ![Screenshot (258)](https://github.com/user-attachments/assets/84c98bab-ec45-4fd5-aaeb-b577963abd34)               
5. DELETE ------ `/tasks/{id}`                | Delete a task ![Screenshot (259)](https://github.com/user-attachments/assets/44a1d3f0-6320-45f2-9601-71a418386561) ![Screenshot (260)](https://github.com/user-attachments/assets/a3add01f-1b5e-4be6-9197-9303e129b031)
6. GET    ------ `/tasks/search?name=keyword` | Search tasks by name  ![Screenshot (261)](https://github.com/user-attachments/assets/5efe31f6-948d-4cce-b4f2-01ba41f06782)
7. PUT    ------ `/tasks/{id}/execute`        | Execute a task and log output ![Screenshot (252)](https://github.com/user-attachments/assets/e983f6fb-9a05-4be2-89ab-dd55bda1c49c)





