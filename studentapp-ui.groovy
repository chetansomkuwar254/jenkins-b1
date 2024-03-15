pipeline {
    agent any

    stages {
        stage('Pull') {
            steps {
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
