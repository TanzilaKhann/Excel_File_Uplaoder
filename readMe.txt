#1. Change the mysql databse properties in "application properties" file according to your database 


application property file is in (src/main/resources/application.properties)


#2. Change the upload files folder path in "application properties " file to the folder path you want. ( app.upload.dir=D:/ExcelUploadRepo app.upload.file=D:/ExcelUploadRepo/inspire.xlsx ) change the folder path here.

#3. if you are importing project on eclipse then run the project on 
"InternshipApplication.java " file as a  java application.



#4. it might happen that project shows error in pom.xml file then procecced the run with errors. and if it still don't run then download all the dependencies in pom.xml file again.
("<dependency>
    <groupId>exoscale</groupId>
    <artifactId>net-http</artifactId>
    <version>0.1.0-alpha6</version>
</dependency>") these dependency.

#5 after downloading the above mentioned dependency  run the app or procceed it with error the project will run fine