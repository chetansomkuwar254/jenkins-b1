Maven command Syntax : mvn goal <argument>
                       aws sub-command  extra parameter
=======================================================================================================

==> Create a Maven project for Example purpose
-----------------------------------------------

Syntax: mvn archetype:generate
        command (libreary):(The actual goal need to download from liabrary)

mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
Delete !!

# mvn archetype:generate -DgroupId=com.studentapp-ui.app -DartifactId=studentapp-ui-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
# cd studentapp-ui-app
# tree

Note: Developer decide the build tool, here directory structre is created for java based application from here we started the Applicaiton development lifecycle

1. First directory has define
2. Then we write the application/code
eg. we can check studentapp also

## our-project has created Example completed
==============================================================================================================================================================================================================

Maven Lifecycle for our project:
-----------------------------
Basically it a process collection of maven phases

Mven lifecycle Type:
1. Default - by default behavior of lifecycle
2. Clean - It discard old build
3. Site - It helps of documentation
-------------------------------------------------------

Maven Phases: --> Collection of goals/libreary
Default Phases
------------------------------------------
1. validate: validate the project is correct and all necessary information is available
2. compile: compile the source code of the project (Syntax checks, Human redable lamgaue convert m/c readable)
3. test: test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed (test)
4. package: take the compiled code and package it in its distributable format, such as a JAR. (Pkg created)
5. integration-test: process and deploy the package if necessary into an environment where integration tests can be run (integration of enviorment)
6. verify: run any checks to verify the package is valid and meets quality criteria (all criteria meet or not ?)
7. install: install the package into the local repository, for use as a dependency in other projects locally (artifact install, webapp/student.war)
8. deploy: done in an integration or release environment, copies the final package to the remote repository for sharing with other developers and projects. (Applciaiotn run/deploy in some platform)


Clean Phase:
-------------------
1. cleans up artifacts created by prior builds

Site Phase:
-------------------
1. site: generates site documentation for this project

============================================================================================================================



# Maven Installation and Setup Enviorment 

```shell
java --version
wget https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz
sudo tar -xvzf apache-maven-3.9.6-bin.tar.gz
sudo mv apache-maven-3.9.6 /opt/
cd /opt/apache-maven-3.9.6/bin/
sudo vim /etc/profile
  export PATH=$PATH:'/opt/apache-maven-3.9.6/bin/'
source /etc/profile
bash
mvn --version
```
# Clone the Developer App repository

```shell
sudo -i
cd /opt
sudo git clone https://github.com/chetansomkuwar254/studentapp.ui.git
cd studentapp.ui
mvn package
# mvn clean package
```

## Error:
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-war-plugin:2.6:war (default-war)
on project studentapp: Execution default-war of goal org.apache.maven.plugins:maven-war-plugin:2.6:war
failed: Unable to load the mojo 'war' in the plugin 'org.apache.maven.plugins:maven-war-plugin:2.6' 
due to an API incompatibility: org.codehaus.plexus.component.repository.exception.ComponentLookupException: null

==> .mojo is not supported by Java-17, so we need to install java-11 or below.

``` shell 
java --version
sudo apt update
sudo apt install openjdk-11-jdk
```
## To check diffrent version of java or which Java version is curretnly in used. To ensure that use below command.
```shell
sudo update-alternatives --config java
# now to select the exact Java 11 version and Enter.
java --version   ... It should be java 11 running
```
Now, Build it again.


## Note: mvn command always run from the pwd where our pom.xml file is avialable

# Jenkins-App: Global Tool configuration
----------------------------------------
here we are adding the maven executable command path to provide the maven enviorment in pipeline
---------------------------------------
# Add Maven installation
    Name = mvn
    Home_Directory =  /opt/apache-maven-3.9.6

# Pipeline syntax generator
1. Snippet Generator
2. Sample step- sh:Shell Script
   shell script- mvn clean package
3. Generate the pipeline script

# Declarative Pipeline Stage Build

```shell
        stage('Pull') {
            steps {
                echo 'Jarvis Pull the Developer repository'
                sh '/opt/apache-maven-3.9.6/bin/mvn clean package
            }
        }
```