# **java-auth-api**
Projeto Java parte do processo seletivo da Concrete Solutions

## **Java, Frameworks and Libs**
* Back
> * Java 8
> * Spring Boot
> * Gradle
> * JWT
> * BCrypt
> * Mockito

* CI
> * Travis CI on GITHUB (Automatic Deploy in Heroku Provider)

* Front
> * Angular
> * Sass
> * Gulp
> * Bower

* WebSocket (Load new users in index page)
> * SocketJS
> * Stomp

## **Front Angular**
* http://localhost:8080
* http://concrete.rudolfoborges.com.br/
* http://sheltered-mesa-83429.herokuapp.com

## **Endpoints**

* http://localhost:8080/api/v1/signup - POST
* http://localhost:8080/api/v1/auth/login - POST
* http://localhost:8080/api/v1/auth/perfil/{id} - GET

## **Run with Docker (Commands)**

./gradlew build

docker-compose build

docker-compose up -d

## **Demo (Heroku)**

* http://concrete.rudolfoborges.com.br/api/v1/signup - POST
* http://concrete.rudolfoborges.com.br/api/v1/auth/login - POST
* http://concrete.rudolfoborges.com.br/api/v1/auth/perfil/{id} - GET

OR

* http://sheltered-mesa-83429.herokuapp.com/api/v1/signup - POST
* http://sheltered-mesa-83429.herokuapp.com/api/v1/auth/login - POST
* http://sheltered-mesa-83429.herokuapp.com/api/v1/auth/perfil/{id} - GET

## **Extra**

### User Endpoint

* http://localhost:8080/api/v1/user - GET
* http://concrete.rudolfoborges.com.br/api/v1/user - GET (Demo)
* http://sheltered-mesa-83429.herokuapp.com/api/v1/user - GET (Demo)

## **Gulp**

* angular-src/*.js -> angular.app.js (cat) 
* angular-src/views/*.html -> angular.views.js (cat, min)
* assets/css/*.scss -> style.css (cat, min)
* images-src/* -> static/assets/images
* angular-src/index.html -> static/assets/index.html (min)