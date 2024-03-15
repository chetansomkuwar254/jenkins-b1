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
                echo 'Hello World'
            }
        }
                stage('Test') {
            steps {
                echo 'Hello World'
            }
        }
                stage('Deploy') {
            steps {
                echo 'Hello World'
            }
        }
    }
}
