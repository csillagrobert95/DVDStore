FlightsApp - Csillag Robert

A small demo web app built using Java Spring an RabbitMQ.

Functional requirements: 
 - The application is used by a DVD store administrator 
 - The administrator must send notification to its customers when a new DVD is available 
 - The information about the new DVD must be saved in a text file 
 - Each time new information about a DVD is introduced in the system, the application must send automatically notification e-mails to all the subscriber customers to notify them about the new item 
 - Each time new information about a DVD is introduced in the system the application must create automatically a text file and write the information about the DVD in it 

Used technology stack:
- Java
- Spring Boot
- RabbitMQ
- Thymeleaf
- HTML
- Bootstrap

Steps to install and run the application:
1. Configure RabbitMQ on local server
2. Import the projects in Eclipse/Intellij
3. Start RabbitMQ
4. Run the Server application
5. Run the Client application
6. Open the web browser (http://localhost:8090)