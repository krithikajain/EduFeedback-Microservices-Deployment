pipeline {
    agent any
    
    environment {
        DOCKERHUB_PASS = credentials("99960e51-cea8-43f5-af12-78eedc62265a")
        BUILD_TIMESTAMP = sh(script: 'date +%Y%m%d%H%M%S', returnStdout: true).trim()

    }
    
    stages {
        stage("Building the Student Survey Image") {
            steps {
                script {
                    checkout scm
                    sh 'rm -rf var'
                    sh 'jar -cvf StudentSurvey.jar -C src/main/webapp/ .'
                    sh "docker login -u piyushr269 -p ${DOCKERHUB_PASS}"
                    def customImage = docker.build("piyushr269/survey645:${BUILD_TIMESTAMP}", ".")
                }
            }
        }
        
        stage("Pushing Image to Docker Hub") {
            steps {
                script {
                    sh "docker push piyushr269/survey645:${BUILD_TIMESTAMP}"
                }
            }
        }
        
        stage('Deploying to Rancher to single node(deployed in 3 replicas)') {
         steps {
            echo 'deploying on kubernetes cluster'
            script{
               //sh "docker pull piyushr269/survey645:${env.BUILD_NUMBER}"
               sh "kubectl --kubeconfig /var/lib/jenkins/.kube/config set image deployment/survey container-0=piyushr269/survey645:${BUILD_TIMESTAMP}"
            }
         }
      }

      stage('Deploying to Rancher using Load Balancer as a service') {
         steps {
            script{
               sh "kubectl --kubeconfig /var/lib/jenkins/.kube/config set image deployment/surveyl container-0=piyushr269/survey645:${BUILD_TIMESTAMP}"
            }
         }
      }
   }
}
