Bookstore application
======================

Simple SpringBoot application that manage a bookstore.
More docs on [`https://cmincu.github.io/bookstore/`](https://cmincu.github.io/bookstore/)

Assure you have Java 11 and Maven installed.

### Building jar
mvn clean package

### Running app
java -jar  bookstore.jar

### Building docker image
mvn clean package docker:build

### Start docker container
mvn docker:start

### Stop docker container
mvn docker:stop


### Running tests
mvn clean:verify

Will run default test plus JMeter tests as defined in module test folder src/test/jmeter.

It's possible that Jenkins will show empty HTML reports. This is caused by: [`https://www.jenkins.io/doc/book/system-administration/security/configuring-content-security-policy/`](https://www.jenkins.io/doc/book/system-administration/security/configuring-content-security-policy/).

Solution is described in :
[`https://stackoverflow.com/questions/36446279/jenkins-html-publisher-plugin-allow-script-permission-issue`](https://stackoverflow.com/questions/36446279/jenkins-html-publisher-plugin-allow-script-permission-issue).

Steps:

* Go to the Jenkins Admin page (login as admin).
* Go to Manage Jenkins -> Script Console
* Then in the script console copy/paste run following snippet

Snippet:

     System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "sandbox allow-scripts; default-src *; style-src * http://* 'unsafe-inline' 'unsafe-eval'; script-src 'self' http://* 'unsafe-inline' 'unsafe-eval'");
