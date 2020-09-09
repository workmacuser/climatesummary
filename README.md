### Climate Summary Application
#### Summary
This application allows user to view partial climate details of various locations around the world.
The details which can be viewed includes temperature, mean temperature, highest and lowest monthly temperature.
This application allows filtering of dates based on Year and Month.  The application **DOES NOT** provide filtering
based on the day of the month and assumes day starts on **1st** of selected month and year.

#### Details
##### Frameworks Utilized
This application uses following following frameworks
* Java SDK 1.8
* Spring Mvc
* Spring Boot
* Logback
* CSS
* Bootstrap JS
* Thymeleaf
 
##### Logs
This application uses logback for logging and all the logs 
are stored under $HOME/.logs/climatesummary.log file

##### Prerequisites
Following software/frameworks should be installed before running this application.
* Java SDK 1.8
* Maven 3.6.3

##### Running the application
Climate Summary Application has been tested on ubuntu linux.
However, it can run on any linux kernel as long as pre-requisite software(s) are installed.
The application can be run by following the steps below:

* Clone the application 
git clone  https://github.com/workmacuser/climatesummary.git

* Execute the application 
./mvnw spring-boot:run


