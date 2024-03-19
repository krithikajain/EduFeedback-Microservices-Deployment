pipeline {
    agent any
    
    environment {
        DOCKERHUB_PASS = credentials("dockerpass")
    }
    
    stages {
        stage("Building the Student Survey Image") {
            steps {
                script {
                    checkout scm
                    sh 'rm -rf var'
                    sh 'jar -cvf StudentSurvey.jar -C src/main/webapp/ .'
                    def BUILD_TIMESTAMP = sh(script: 'date +%Y%m%d%H%M%S', returnStdout: true).trim()
                    sh "docker login -u piyushr269 -p ${DOCKERHUB_PASS}"
                    sh "docker build -t piyushr269/webapp-spring-boot:${BUILD_TIMESTAMP} ."
                    sh 'docker push piyushr269/webapp-spring-boot:${BUILD_TIMESTAMP}'
                }
            }
        }
        
        stage("Pushing Image to Docker Hub") {
            steps {
                script {
                    def BUILD_TIMESTAMP = sh(script: 'date +%Y%m%d%H%M%S', returnStdout: true).trim()
                    sh "docker push piyushr269/survey645:${BUILD_TIMESTAMP}"
                }
            }
        }
        
        stage("Deploying to Rancher as single pod") {
            steps {
                script {
                    def BUILD_TIMESTAMP = sh(script: 'date +%Y%m%d%H%M%S', returnStdout: true).trim()
                    sh "kubectl set image deployment/survey survey=piyushr269/survey645:${BUILD_TIMESTAMP}"
                }
            }
        }
        
        stage("Deploying to Rancher with load balancer") {
            steps {
                script {
                    def BUILD_TIMESTAMP = sh(script: 'date +%Y%m%d%H%M%S', returnStdout: true).trim()
                    sh "kubectl set image deployment/surveyl surveyl=piyushr269/survey645:${BUILD_TIMESTAMP}"
                }
            }
        }
    }
}
