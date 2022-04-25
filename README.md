# AspireChallenge

# Tech Stack
* Seenium with Java
* TestNG
* POM Design pattern

# What I did ?
* So I have implemented selenium + testNG in the framework alongside using POM design pattern. For every pages in the applicaation, there is 1 page file and 1 java file. With this also customised testNG defualt reporter with logs (Start, Success, Skip and Fail) and also attached screenshots when any xyz test fails.
* Also I did rerun functinalites which will try to retry test before failing.
* Values like browser name, base url, product name etc are been managed by properties.


# Folder Architecture.
* src/test/java - Pages : All selectors/elements along with bussiness logic.
* src/test/java - tests : All testcases.
* src/test/java - Utils : Browser Utilites, Common Functions, Retry Mechansium and Report Listensers.
* src/test/resources - Screenshots : Failure screenshots with timestamp.
* src/test/resources - Properties : Properties file containing required values.

# How to run it ?
* Just run testng.xml file as testNG suite and all tests will run. Make changes in properties file if needed.
