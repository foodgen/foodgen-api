# FoodGen-Back

This repository serves as back-end for the food generation application

# Tools
There are 2 major technologies that we used during the developpement of this app:
* Maven : used as dependency management
* Spring boot : used to create all the functionnalities of the actual app

But there are also some dependencies that helped making the app more easier and smoother :
* Lombok : used to generate known patterns allowingto reduce the boilerplate code
* Checkstyle : used for linting the source code
* Jacoco : used for tests and code coverage
* Junit : for integration tests of all the functionalities within the app
* Spring security : for security measures against unauthorized visitors
* Postgresql : mainly for storing datas and use them

# Requirements :
If you want to use this app, either change some functionnalities or add new ones, you will need to install java first
Go to this link [JDK 18](https://www.oracle.com/java/technologies/javase/jdk18-archive-downloads.html) and install it to run the code

# Installation :
We recommend using IDE like VsCode or IntelliJ Idea for better readibility if you want to use this app. </br>
All you need to do is to import the project directory to IntelliJ IDEA and it will download all the necessary dependencies
for the application, otherwise you will need to go the maven central repository and take everything dependencies there. </br>
Here is the link for the repository : [Maven](https://mvnrepository.com/)

# Utilisation :
If you want to run the application locally, you can run it manually using this command :
   ```sh
   mvn spring-boot:run
   ```
Or you can also just click the run button if you use IntelliJ IDEA as an IDE.

# Linter :
CheckStyle is used as a Linter for maintaining code quality and following coding standards in
the app. </br>

CheckStyle configuration file is an XML file in which contains all the rules
and modules to be used for checking the code. </br>

It is currently stored at `resources/checkstyle/checkstyle.xml`

It is, by default triggered when building the app but if you want to execute it manually, execute this command:
   ```sh
   mvn clean checkstyle:checkstyle
   ```

Once checking the code is completed, it will generate an HTML file report for checkstyle result
, `target/site/jacoco/index.html` contains all output.

### Tests :
Jacoco is used for testing code coverage in this application and should be always be above 80% 
otherwise the build will fail.

You can trigger tests manually by executing this command :
   ```sh
   mvn clean test
   ```

Once the test has been completed, `target/site/jacoco/index.html` contains all output.

