# Yard-Sale-Helper

# What is this project?
#### This is a web based project created using HTML, JavaScript, CSS, Scala, etc. The aim of this project is to create a website where a user can login to buy or sell items.  

### Summer 2016 Class Group Project
###### Note: Instead of pushing to master, please push to branch 'develop'. This is to prevent the master branch from being polluted when mistakes are made.

###### Important! Each time you want to run the app using 'activator run', do this first: (if rhc client tools were properly set up)  
###### rhc port-forward -a yardsalehelper
###### Then open a new console inside the command line to activator run the app
###### To see what's in the database, go to https://yardsalehelper-0042.rhcloud.com/phpmyadmin/, log in using the username and password found on openshift

### Git Instruction 
Clone a specific branch (e.g. develop): git clone -b develop remote_repo_url **Don't omit -b**  
Check what branch you are on, and your progress: git status  
Create a new branch: git branch branch_name  
Switch to another branch: git checkout branch_name  
  
###### Push to specific branch(e.g. develop): git push -u origin develop  
  
Merge local feature branch with local develop branch:  
git checkout develop (switch to develop branch)  
git merge feature_branch  

### File structure

###### /project build.sbt
Contains info about the automated build process of the project and plugins  
Do not modify these unless library dependencies/plugins are added or software versions change  

###### /conf
Contains the configuration files  
Application.conf and routes shall be updated  

###### /public
Contains static assets of the application such as images, stylesheets, and client-side javascript

###### /app
Contains application logic  
The application is structured using MVC architectural pattern  

**Folders we will modify under /app:**
###### /assets
Contains compilable assets. Sass files inside /style will be compile to css files in the public folder
http://sass-lang.com/  
###### /models /views /controllers
Contains MVC application logic  

**Folders we may modify under /app:**
###### /services
Note: files in the base folder come with the sample seed application  

**Folders and files we shall not have to modify under /app**
###### /filters Filters.java Module.java
These files come with the sample play-java-seed application  
