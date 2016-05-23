# drawcanvas
This app is created as a test app as asked by the Springer Nature team to test the programming and designing abilities

## Downloading the application
The application can be downloaded from the github website using below link:
https://github.com/rishigogia/drawcanvas

## Description of the application
This is a java based thick client used to create a canvas and use some drawing tools on it

The application uses third party tools as below:
* JUnit (v4.12) (for unit testing)
* Hamcrest core (v1.3) (for using assertThat and related tools)
* Apache Maven

## Running the application
To compile the application, please use below steps:
* Pre-requisite
1. Java 1.8 (JAVA_HOME must be set)
2. Apache Maven (M2_HOME must be set and M2_HOME\bin should be in path)

* Compilation
1. download the application from github site
2. go to application root in shell/command prompt
3. type 'mvn clean install' (without the quotes) to compile the application (this runs the test cases)

* Run only test cases
1. Test cases can be run using maven command 'mvn test'

* Executing the main application
1. Main application can be run using the command:  mvn exec:java -Dexec.mainClass="com.springer.test.Draw"

## Valid commands that can be used:
* C width height
1. (where width and height are numbers) - This creates a canvas. Nothing can be printed on screen if there's no canvas (Eg. C 20 15)
* L x1 y1 x2 y2
1. x1, y1, x2 and y2 are numeric (Eg. L 5 5 10 5) - This creates a line
* R x1 y1 x2 y2
1. x1, y1, x2 and y2 are numeric (Eg. L 5 5 10 12) - This creates a rectangle
* B x1 y1 char
1. x1 and y1 are numeric, char is a single character (A-Z or a-z) (Eg. B 4 5 x) - This does a bucket fill
* Q
1. This quits the application

Please contact rishi_gogia@hotmail.com in case of any queries or concerns.

========================================== Thank you ===========================================
