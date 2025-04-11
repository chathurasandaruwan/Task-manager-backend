 📝 Task Manager Backend

Spring Boot backend application for Task Manager. Built with JDK 21, Gradle, and MySQL.

🚀 How to Run the Application (JDK 21 + Gradle + MySQL)

1. Install Required Tools

- ✅ JDK 21
- ✅ Gradle (or use the Gradle Wrapper `./gradlew`)
- ✅ MySQL (running locally)

2. Clone the Repository
```bash
git clone https://github.com/chathurasandaruwan/Task-manager-backend.git
cd Task-manager-backend
```

3. Configure the Database
```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/taskManagerDB?createDatabaseIfNotExist=true
   spring.datasource.username=your_mysql_username
   spring.datasource.password=your_mysql_password

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
```
4. Build the Application Using Gradle
   ```bash
   ./gradlew build
   ```
5. Run the Application
```bash
   java -jar build/libs/Task-manager-backend.jar
```
6. Access the Application
```bash
   http://localhost:5050
```
📂 Project Structure
src
├── main
│   ├── java
│   │   └── com.example.taskmanager
│   └── resources
│       └── application.properties
└── test

🛠 Technologies Used
```bash
    *Java 21

    *Spring Boot

    *Spring Data JPA

    *MySQL

    *Gradle
```