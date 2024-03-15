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
                stage('Pull') {
            steps {
                echo 'Hello World'
            }
        }
                stage('Pull') {
            steps {
                echo 'Hello World'
            }
        }
    }
}
