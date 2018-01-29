VESTNIC PARCER 

Vestnic-parcer is a application for transform Novosibirsk State University Press 
xml's scientific article metadata to DOAJ (https://doaj.org/) and  ICI World of Journals (https://journals.indexcopernicus.com)
import xml format.
 
 Installing
 For building application use Apache Maven 3.5.2 and java 1.8
    shell comand:  mvn package assembly:single

Running 
 After buildin, run application use vestnic-parcer-core-*.*-jar-with-dependencies.jar jar from ./target directories;
 shell comand: cd target
               java -jar vestnic-parcer-core-*.*-jar-with-dependencies.jar
    
 
