**### Cwitter - A twitter clone ###**
 
 cwitter is a clone of social website twitter which has functionality like user can sign in, log in, also user can view posts on timeline and can post on timeline.
 Cwitter is implimented using Java Framework - Spring-MVC and MySQL database

### Prerequisites ###
* spring-mvc
* jdk8
* Apache Tomcat 7.0
* MySQL
* Git
* IDE(Eclipse)

### To Run The Application ###
* Import project in eclipse ide
     Goto files - import project - git - git project - choose either direct clone by providing url or by cloning in local repository and importing in eclipse
    provide url- https://saurabh_neo@bitbucket.org/saurabh_neo/cwitter.git

* Now open MySQL database cwitter.sql (provided in database folder) file in mysql workbench and execute it
* after opening project in Eclipse edit these two file with Mysql user name and password 
  1] src folder open CwitterController.java provide your MySQL username and password in String USER="" and String PASS=""
  2] open webcontents/WEB-INF open timeline.jsp search Sting username and passsword and change with your username and passwordd

* Run the project in eclipse using apache tomcat server
* open web browser and in addressbar enter:

http://localhost:8080/cwitter/index

