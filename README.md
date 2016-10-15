# java-auth-api
Projeto Java parte do processo seletivo da Concrete Solutions

### Java, Frameworks and Libs
* Java 8
* Spring Boot
* Gradle
* JWT
* BCrypt
* Mockito

### Endpoints

* http://localhost:8080/api/v1/signup - POST
* http://localhost:8080/api/v1/auth/login - POST
* http://localhost:8080/api/v1/auth/perfil/{id} - GET

### Run with Docker (Commands)

./gradlew build

docker-compose build

docker-compose up -d

### Demo (Heroku)

* http://sheltered-mesa-83429.herokuapp.com/api/v1/signin - POST
* http://sheltered-mesa-83429.herokuapp.com/api/v1/auth/login - POST
* http://sheltered-mesa-83429.herokuapp.com/api/v1/auth/perfil/{id} - GET
