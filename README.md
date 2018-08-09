Automation Architecture 
Tools used : Rest Assured, cucumber-jvm, org.skyscreamer, Maven 


Rest Assignment 

├── _skeleton
├   ├── JSONReader.java
├   └── RunCukesTest.java
├   └── Stepdefs.java
├   └── WithoutCucumber.java
├── _skeleton
├   ├── Test.feature- All feature files havings tests 
├── target
├   ├──Reports 
├── pom.xml
└── ReadMe.md
└── Response.json
└── SendData.json
 
JSON Reader file have methods to read JSON object from json file  
RunCukesTest.java is having test runner configuration 
Stepdefs.java-All Step definitions of test.feature are defined here 
WithoutCucumber.java covers the same test cases as test feature  
Test.feature-All Scenarios are written in test.feature 

How to run : 
Maven Run - It will download all project related dependencies jars and will perform all tests 
Maven test - It will run all tests 
