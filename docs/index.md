Bookstore application
======================

Simple SpringBoot application that manage a bookstore. 
Instruction on how to build and run application on [`https://github.com/cmincu/bookstore#readme`](https://github.com/cmincu/bookstore#readme)

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