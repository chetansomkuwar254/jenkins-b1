# SonarQube Installation

## Prerequisites
- SonarQube server will require 3GB+ RAM to work effeciently

### Install Database
```shell
rpm -ivh http://repo.mysql.com/mysql57-community-release-el7.rpm
ls /etc/yum.repos.d/
rpm --import https://repo.mysql.com/RPM-GPG-KEY-mysql-2022
yum install mysql-server -y
systemctl start mysqld
systemctl enable mysqld
grep 'temporary password' /var/log/mysqld.log
mysql_secure_installation -p <password>  -------------------------------> Temperory password  (Admin@123)
mysql_secure_installation                -------------------------------> Set New Password
```
# Now, our Database server is ready #

### Install Java
```shell
yum install wget epel-release -y
yum install java -y
wget https://download.bell-sw.com/java/11.0.4/bellsoft-jdk11.0.4-linux-amd64.rpm
rpm -ivh bellsoft-jdk11.0.4-linux-amd64.rpm
#alternatives --config java
```

### Configure Linux System for Sonarqube
```shell
echo 'vm.max_map_count=262144' >/etc/sysctl.conf
sysctl -p
echo '* - nofile 80000' >>/etc/security/limits.conf
sed -i -e '/query_cache_size/ d' -e '$ a query_cache_size = 15M' /etc/my.cnf
systemctl restart mysqld
```
### Configure Database for Sonarqube
```shell
mysql -u root -p
mysql>
    create database sonarqube;
    show databases;
    create user 'sonarqube'@'localhost' identified by 'Redhat@123';
    grant all privileges on sonarqube.* to 'sonarqube'@'localhost';
    flush privileges;
```
### Install Sonarqube
```shell
yum install unzip -y
wget https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-7.9.1.zip
cd /opt
unzip ~/sonarqube-7.9.1.zip
mv sonarqube-7.9.1 sonar
```
### Configure Sonarqube
```shell
sed -i -e '/^sonar.jdbc.username/ d' -e '/^sonar.jdbc.password/ d' -e '/^sonar.jdbc.url/ d' -e '/^sonar.web.host/ d' -e '/^sonar.web.port/ d' /opt/sonar/conf/sonar.properties
sed -i -e '/#sonar.jdbc.username/ a sonar.jdbc.username=sonarqube' -e '/#sonar.jdbc.password/ a sonar.jdbc.password=Redhat@123' -e '/InnoDB/ a sonar.jdbc.url=jdbc.mysql://localhost:3306/sonarqube?useUnicode=true&characterEncoding=utf&rewriteBatchedStatements=true&useConfigs=maxPerformance' -e '/#sonar.web.host/ a sonar.web.host=0.0.0.0' /opt/sonar/conf/sonar.properties
useradd sonar
chown sonar:sonar /opt/sonar/ -R
sed -i -e '/^#RUN_AS_USER/ c RUN_AS_USER=sonar' /opt/sonar/bin/linux-x86-64/sonar.sh
```
### Start Sonarqube
```shell
/opt/sonar/bin/linux*/sonar.sh start
/opt/sonar/bin/linux*/sonar.sh status
/opt/sonar/logs
```

## Whitelist the ports
```shell
    - Sonarqube = 9000
```

## Try to access the Sonarqube application
```shell
Public IP:9000
```

## Default ID and Password
```shell
username = admin
```
## Understand the Sonarqube console

## Setup the project in sonarqube
1. Project Name: studentapp-ui
2. Genrate the token: save to token, it's only one time visible.
3. Set-up the required java enviorment
4. Setup the build tool (maven)
then we got the scanner maven commands, to run on jenkins server.

5. First of all clone the studentapp-ui repository in jenkins server
6. Run te 4th no's all maven commands in maven project's home directory, where pom.xml file is present.
```shell
git clone https://github.com/chetansomkuwar254/studentapp.ui.git
cd /studentapp.ui
mvn clean package
# run mvn sonar:sonar <commands>
```
7. Now this project has 



