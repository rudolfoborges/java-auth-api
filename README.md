# java-auth-api
Projeto Java parte do processo seletivo da Concrete Solutions

### Java, Frameworks and Libs
* Java 8
* Spring Boot
* Gradle
* JWT
* BCrypt
* Mockito
* Travis CI on GITHUB

### Endpoints

* http://localhost:8080/api/v1/signup - POST
* http://localhost:8080/api/v1/auth/login - POST
* http://localhost:8080/api/v1/auth/perfil/{id} - GET

### Run with Docker (Commands)

./gradlew build

docker-compose build

docker-compose up -d

### Demo (Heroku)

* http://concrete.rudolfoborges.com.br/api/v1/signin - POST
* http://concrete.rudolfoborges.com.br/api/v1/auth/login - POST
* http://concrete.rudolfoborges.com.br/api/v1/auth/perfil/{id} - GET

OR

* http://sheltered-mesa-83429.herokuapp.com/api/v1/signin - POST
* http://sheltered-mesa-83429.herokuapp.com/api/v1/auth/login - POST
* http://sheltered-mesa-83429.herokuapp.com/api/v1/auth/perfil/{id} - GET
