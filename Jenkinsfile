pipeline {
    agent any

    options {
        timestamps()
        timeout(time: 10, unit: 'MINUTES')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                dir('task-manager-api') {
                    sh './mvnw clean test'
                }
            }
        }

        stage('Package') {
            steps {
                dir('task-manager-api') {
                    sh './mvnw clean package -DskipTests'
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}