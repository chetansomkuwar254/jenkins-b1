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
