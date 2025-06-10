1. Task Management REST API

       This is a Java Spring Boot project that provides a RESTful API for managing task objects that represent shell commands executed inside Kubernetes pods. It uses MongoDB Atlas as the database and was initialized using Spring Initializr.


2. Technologies Used
   
* Java 17+

* Spring Boot

* Spring Web

* Spring Data MongoDB

* MongoDB Atlas (Cloud Database)

* Postman (API testing)

  
3. MongoDB Atlas Setup
* Create an account at MongoDB Atlas.

* Create a cluster and database.

* Create a database user.


4. Running the Application

* Open the project in Eclipse.

* Make sure all Maven dependencies are downloaded.

* Run the TaskApiApplication.java file. 

  The server will start on http://localhost:8080.


5. Sample JSON for Creating a Task

{
  "name": "Print Hello",
  "owner": "John Smith",
  "command": "cmd /c echo Hello World"
}


6. Postman Testing
   Test all API endpoints using Postman.

   
7. API Endpoints with Screenshots

* GET	/tasks	Get all tasks

* POST	/tasks	Create a new task

* GET	/tasks/{id}	Get a task by ID

* PUT	/tasks/{id}	Update a task

* DELETE	/tasks/{id}	Delete a task

* GET	/tasks/search?name=keyword	Search tasks by name
PUT	/tasks/{id}/execute	Execute a task and log output
