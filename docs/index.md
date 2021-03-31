Bookstore application
======================

Simple SpringBoot application that manage a bookstore. 

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

### CI on Raspberry PI

In order to set up a Raspberry PI machine for Continuous Integration you will need to follow next steps:
* Have Raspbian installed on Raspberry device. Check more docs on official page: [`https://www.raspberrypi.org/software/`](https://www.raspberrypi.org/software/)
* Install Java 11 (or others) as described here : [`https://phoenixnap.com/kb/install-java-raspberry-pi`](https://phoenixnap.com/kb/install-java-raspberry-pi)
* Install Maven :[`https://xianic.net/2015/02/21/installing-maven-on-the-raspberry-pi/`](https://xianic.net/2015/02/21/installing-maven-on-the-raspberry-pi/)
* Install Jenkins : [`https://pimylifeup.com/jenkins-raspberry-pi/`](https://pimylifeup.com/jenkins-raspberry-pi/)
* Install Docker : [`https://phoenixnap.com/kb/docker-on-raspberry-pi`](https://phoenixnap.com/kb/docker-on-raspberry-pi)

After installation is finished additional configuration steps can be done in order to preserve space on Raspberry main SD card. This assumes that you have an additional HDD drive mounted (See [`https://pimylifeup.com/raspberry-pi-mount-usb-drive/`](https://pimylifeup.com/raspberry-pi-mount-usb-drive/)).
* Docker container location can be changed as seen in [`https://stackoverflow.com/questions/32070113/how-do-i-change-the-default-docker-container-location`](https://stackoverflow.com/questions/32070113/how-do-i-change-the-default-docker-container-location)
* For Maven M2 repository you should edit file in  /opt/apache-maven-3.5.4/conf/settings.xml (**3.5.4** should be changed with you version) and change <localRepository> to point to your desired location
* Jenkins will run jobs on default installation path and this should be changed also [`https://dzone.com/articles/jenkins-02-changing-home-directory`](https://dzone.com/articles/jenkins-02-changing-home-directory) 