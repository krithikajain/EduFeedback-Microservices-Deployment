# SWE645-hw2
Team members



### 1. Creating EC2 Instances

- *Launch EC2 Instances:*
  - Navigate to the AWS Management Console and select EC2.
  - Click on "Launch Instance" and select an Ubuntu Server AMI.
  - Choose the t3.large instance type.
  - Configure the instance details, add storage, and add tags as needed.
  - Configure the security group to allow HTTP (port 80), HTTPS (port 443), and SSH (port 22) access.
  - Review and launch the instance. Repeat this process to create two instances, one named Rancher and the other named Jenkins.
  - Associate Elastic IPs with each instance for stable public IP addresses.

### 2. Containerizing the Web Application

- *Set Up Docker:*
  - SSH into the rancher instance.
  - Install Docker:
  ```bash
    sudo apt-get update
    sudo apt install docker.io
  ```

- *Create a Dockerfile:*
  - Navigate to the root directory of your web application.
  - Create a Dockerfile with the following content:
    
   FROM tomcat:9.0-jdk15
   
  COPY StudentSurvey.war /usr/local/tomcat/webapps/
    

- *Build the Docker Image:*
  - Build the Docker image using the following command:
  ```bash
    sudo docker build --tag survey645:0.1

- *Test the Docker Image Locally:*
  - Run the Docker image to ensure it works as expected:
   ```bash 
    sudo docker run -d -p 8182:8080 survey645:0.1
   ```
  - Access the application at http://localhost:8182/StudentSurvey to verify it's running.
- *Push on Dockerhub:*
  - Login to DockerHub using the command: ```bash docker login -u <your username>. ```
  - Use the docker tag command to change the name of your Docker image
 ```bash
    docker tag survey645:0.1 <your username on DockerHub>/survey645:0.1
 ```

### 3. Deploying the Application on Kubernetes

- *Install Kubernetes CLI (kubectl):*
  - Install kubectl on the rancher instance:
    
    sudo snap install kubectl --classic
    

- *Set Up Rancher:*
  - Run Rancher using Docker:
    
    sudo docker run -d --restart=unless-stopped -p 80:80 -p 443:443 rancher/rancher
    
  - Access the Rancher UI by navigating to https://<Elastic_IP_of_rancher_instance>/ in a web browser.
  - Follow the on-screen instructions to set up Rancher.

- *Create a Kubernetes Cluster:*
  - In the Rancher UI, click on "Clusters" in the top menu, then click "Add Cluster".
  - Choose "From existing nodes (Custom)" as the cluster type.
  - Enter a name for the cluster (e.g., "ass2") and proceed with the basic setup.
  - Click "Next", then "Save". Rancher will provide a command to run on the EC2 instance to join the cluster.
  - SSH into the rancher instance and run the command provided by Rancher to join the Kubernetes cluster.

- *Deploy the Application:*
  - In the Rancher UI, navigate to the "ass2" cluster and click "Workloads" in the top menu.
  - Click "Deploy" and enter a name for the workload (e.g., "ass2").
  - Select the namespace, and specify the number of replicas (e.g., 3) to ensure at least three pods are running all the time.
  - In the "Containers" section, click "Add Container" and configure the container with the image you pushed to Docker Hub (e.g., yourusername/swe645a2:latest).
  - Click "Launch" to deploy the application.
  - Verify that the application is running correctly on Kubernetes by accessing the service endpoint.

### 4. Establishing a CI/CD Pipeline with GitHub and Jenkins

- *Set Up GitHub Repository:*
  - Create a GitHub repository to host your web application code (e.g., https://github.com/yourusername/SWE645-2).

- *Install and Configure Jenkins:*
  - SSH into the jenkins instance.
  - Install Jenkins and start the service:
    ```
    sudo apt update
    sudo apt install openjdk-11-jdk
    wget -q -O - https://pkg.jenkins.io/debian/jenkins.io
[21:59, 18/03/2024] Ganesh Madarasu Gmu: Jenkins pipeline Setup
Create a job
Select free style project
Give a description
choose github project
add the github url https://github.com/hem1999/k8-automated-deployment
choose git as SCM
add repo url
choose credentials which are already stored in Jenkins Credentials
make branch to blank so that it will take the default as main.
choose github hook trigger.
then add the docker build job as a shell script
docker build -t hemu1999/surveyform:latest .
docker push hemu1999/surveyform:latest
docker image rm hemu1999/surveyform:latest
then next job is to deploy on kubernetes
