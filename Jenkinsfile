pipeline {
   environment {
        registry = "piyushr269/survey645"
        registryCredential = '99960e51-cea8-43f5-af12-78eedc62265a'
    }
   agent any

   stages {
      stage('Build') {
         steps {
            echo 'Building...'
            script{
               sh 'rm -rf *.war'
               sh 'jar -cvf StudentSurvey.war -C src/main/webapp/ .'
               docker.withRegistry('',registryCredential){
                  def customImage = docker.build("piyushr269/survey645:${env.BUILD_NUMBER}")
               }
            }
         }
      }

      stage('Push Image to Dockerhub') {
         steps {
            echo 'pushing to image to docker hub'
            script{
               docker.withRegistry('',registryCredential){
                  sh "docker push piyushr269/survey645:${env.BUILD_NUMBER}"
               }
            }
         }
      }

      stage('Deploying to Rancher to single node(deployed in 3 replicas)') {
         steps {
            echo 'deploying on kubernetes cluster'
            script{
               //sh "docker pull piyushr269/survey645:${env.BUILD_NUMBER}"
               sh "kubectl --kubeconfig /var/lib/jenkins/.kube/config set image deployment/survey container-0=piyushr269/survey645:${BUILD_NUMBER}"
            }
         }
      }

      stage('Deploying to Rancher using Load Balancer as a service') {
         steps {
            script{
               sh "kubectl --kubeconfig /var/lib/jenkins/.kube/config set image deployment/surveyl container-0=piyushr269/survey645:${BUILD_NUMBER}"
            }
         }
      }
   }
}
