Bookstore application
======================

Simple SpringBoot application that manage list of books in a library. Data is stored into H2 in memory database.

Assure you have Java 11 and Maven installed.

### Building jar
mvn clean package

### Running app
java -jar  bookstore.jar

### Running tests
mvn clean:verify 

Will run default test plus JMeter tests as defined in module test folder src/test/jmeter.

### Building docker image
mvn clean package docker:build

### Start docker container
mvn docker:start

### Stop docker container
mvn docker:stop
