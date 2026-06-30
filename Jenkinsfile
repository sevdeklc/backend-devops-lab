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

        stage('Start CI Database') {
            steps {
                withCredentials([
                    string(credentialsId: 'ci-db-username', variable: 'CI_DB_USERNAME'),
                    string(credentialsId: 'ci-db-password', variable: 'CI_DB_PASSWORD')
                ]) {
                    sh '''
                        docker network create backend-devops-ci-network || true
                        docker rm -f backend-devops-ci-postgres || true

                        docker run -d \
                          --name backend-devops-ci-postgres \
                          --network backend-devops-ci-network \
                          -e POSTGRES_DB=task_manager_db \
                          -e POSTGRES_USER="$CI_DB_USERNAME" \
                          -e POSTGRES_PASSWORD="$CI_DB_PASSWORD" \
                          postgres:16-alpine

                        sleep 10
                    '''
                }
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

        stage('Run Container') {
            steps {
                withCredentials([
                    string(credentialsId: 'ci-db-url', variable: 'CI_DB_URL'),
                    string(credentialsId: 'ci-db-username', variable: 'CI_DB_USERNAME'),
                    string(credentialsId: 'ci-db-password', variable: 'CI_DB_PASSWORD')
                ]) {
                    sh '''
                        docker rm -f backend-devops-ci-test || true

                        docker run -d \
                          --name backend-devops-ci-test \
                          --network backend-devops-ci-network \
                          -p 8082:8080 \
                          -e SPRING_DATASOURCE_URL="$CI_DB_URL" \
                          -e SPRING_DATASOURCE_USERNAME="$CI_DB_USERNAME" \
                          -e SPRING_DATASOURCE_PASSWORD="$CI_DB_PASSWORD" \
                          backend-devops-task-manager-api:latest
                    '''
                }
            }
        }

        stage('Health Check') {
            steps {
                sh '''
                    sleep 20

                    echo "=== Container status ==="
                    docker ps -a --filter "name=backend-devops-ci-test"

                    echo "=== Container logs ==="
                    docker logs backend-devops-ci-test

                    echo "=== Health check ==="
                    curl --fail http://host.docker.internal:8082/actuator/health
                '''
            }
        }
    }

    post {
        always {
            sh '''
                docker rm -f backend-devops-ci-test || true
                docker rm -f backend-devops-ci-postgres || true
                docker network rm backend-devops-ci-network || true
            '''
            cleanWs()
        }
    }
}