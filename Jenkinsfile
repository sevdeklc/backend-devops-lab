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
                    sh './mvnw package -DskipTests'
                }
            }
        }

        stage('Docker Build') {
            steps {
                dir('task-manager-api') {
                    sh 'docker build -t backend-devops-task-manager-api:latest .'
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