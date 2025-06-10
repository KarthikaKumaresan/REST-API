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

* Get the connection string and replace it in application.properties:
  
       spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<cluster-url>/taskdb?retryWrites=true&w=majority





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



   
8. API Endpoints with Screenshots

* GET--------/tasks---------Get all tasks ![Screenshot (254)](https://github.com/user-attachments/assets/150e57d6-868f-46d3-9135-5c4868d89c0d)


* POST	/tasks	Create a new task  ![Screenshot (255)](https://github.com/user-attachments/assets/7b096c24-d40c-4ed3-972e-38f3494fd8da)


* GET	/tasks/{id}	Get a task by ID ![Screenshot (256)](https://github.com/user-attachments/assets/5ff5d9fa-c82b-4653-bef0-50e25ff65238)


* PUT	/tasks/{id}	Update a task ![Screenshot (258)](https://github.com/user-attachments/assets/061075cf-046b-4faf-9434-43541a2546bf)


* DELETE	/tasks/{id}	Delete a task ![Screenshot (259)](https://github.com/user-attachments/assets/f9b0a76d-299b-485e-92d9-ddd9810e0754) ![Screenshot (260)](https://github.com/user-attachments/assets/ab7738b1-86aa-47df-b774-4da53383e25b)



* GET	/tasks/search?name=keyword	Search tasks by name ![Screenshot (261)](https://github.com/user-attachments/assets/bf10e65d-25f4-4acf-a776-cf48a39da025)

  
* PUT	/tasks/{id}/execute	Execute a task and log output ![Screenshot 2025-06-08 210327](https://github.com/user-attachments/assets/2d9f2f9f-357b-41e8-b26c-9f44c243499d)
