# Bookstore application

Simple SpringBoot application that manage list of books in a library. Data is stored into a H2 in memory database.

Assure you have Java 11 and Maven installed.

### Building jar
mvn clean package

### Running app
java -jar  bookstore.jar

## Building docker image
mvn clean package docker:build

### Start docker container
mvn docker:start

### Stop docker container
mvn docker:stop
