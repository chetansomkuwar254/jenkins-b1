pipeline {
    agent any

    stages {
        stage('Pull') {
            steps {
                git credentialsId: 'chetansomkuwar254', url: 'https://github.com/chetansomkuwar254/studentapp.ui.git'
                echo 'Hello World'
            }
        }
                stage('Build') {
            steps {
                sh '/opt/apache-maven-3.9.6/bin/mvn clean package'
                echo 'Here we are deploying the code'
            }
        }
                stage('Test') {
            steps {
                echo 'Testing the application'
            }
        }
                stage('Deploy') {
            steps {
                echo 'Deploy done'
            }
        }
    }
}
