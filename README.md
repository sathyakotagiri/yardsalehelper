# yard-sale-helper

### CS2340 Project
###### Note: Instead of pushing to master, please push to branch 'develop'. This is to prevent the master branch from being polluted when mistakes are made.

###### Important! Each time you want to run the app using 'activator run', do this first:  
###### rhc port-forward -a yardsalehelper
###### Then open a new console inside the command line to activator run the app

### Git Instruction 
Clone a specific branch (e.g. develop): git clone -b develop remote_repo_url **Don't omit -b**  
Check what branch you are on, and your progress: git status  
Create a new branch: git branch branch_name  
Switch to another branch: git checkout branch_name  
  
While working inside the folder cloned from openshift:
Push to specific branch on gt github(e.g. develop): git push -u gt develop  
  
Merge local feature branch with local develop branch:  
git checkout develop (switch to develop branch)  
git merge feature_branch  

### File structure

###### /project build.sbt
Contains info about the automated build process of the project and plugins  
Do not modify these unless library dependencies/plugins are added or software versions change  

###### /conf
Contains the configuration files.  
Application.conf and routes shall be updated with database access info and routing config

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
