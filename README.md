# SWE645-hw2
### Team members
Ganesh Madarasu,
Piyush Rathod,
Mizba Chougle,
Krithika Jain

### 1. Setting up git
- Create an empty repository on Git
- Clone in to your local.
- Add the folders into the repo and use git add, commit.
- Push your code to Github using git push.
- Our GitHub --> https://github.com/krithikajain/SWE645-hw2

### 2. Creating EC2 Instances

- *Launch EC2 Instances:*
  - Navigate to the AWS Management Console and select EC2.
  - Click on "Launch Instance" and select an Ubuntu Server AMI.
  - Choose the t3.large instance type.
  - Configure the instance details, add storage, and add tags as needed.
  - Configure the security group to allow HTTP (port 80), HTTPS (port 443), and SSH (port 22) access.
  - Review and launch the instance. Repeat this process to create two instances, one named Rancher and the other named Jenkins.
  - Associate Elastic IPs with each instance for stable public IP addresses.

### 3. Creating and containerizing a Docker image and pushing it to DockerHub 
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

### 4. Deploying the Application on Rancher to set the Kubernetes cluster

- *Set Up Rancher:*
  - Run Rancher using Docker:
    ```bash
    sudo docker run -d --restart=unless-stopped -p 80:80 -p 443:443 rancher/rancher
    ```
  - Access the Rancher UI by navigating to https://<Elastic_IP_of_rancher_instance>/ in a web browser.
  - Our rancher url, http://3.220.78.159/dashboard/home
  - Follow the on-screen instructions to set up Rancher.

- *Create a Kubernetes Cluster:*
  - In the Rancher UI, click on "Clusters" in the top menu, then click "Add Cluster".
  - Choose "From existing nodes (Custom)" as the cluster type.
  - Enter a name for the cluster and proceed with the basic setup, check for etcd and control plane along with worker nodes that needs to be registered
  - Click "Next", then "Save". Rancher will provide a command to run on the EC2 instance to join the cluster.
  - This will be our worker node from where we will pull the image.
  - SSH into the rancher instance and run the command provided by Rancher to join the Kubernetes cluster.

- *Deploy the Application:*
  - In the Rancher UI, navigate to the Rancher cluster and click "Workloads" in the top menu.
  - Click "Deploy" and enter a name for the workload.
  - Select the namespace, and specify the number of replicas as 3 to ensure at least three pods are running all the time.
  - Create the deployment for node port and load balancer.
  - Click "Launch" to deploy the application.
  - Verify that the application is running correctly on Kubernetes by accessing the service endpoint.
  - Our Jenkins URL, http://44.218.2.166:8080/
    ![image](https://github.com/krithikajain/SWE645-hw2/assets/161773814/cf073640-21fb-458a-b60c-cf034e4c4188)

### 5. Establishing a CI/CD Pipeline with GitHub and Jenkins

- *Install and Configure Jenkins:*
  - SSH into the Jenkins instance.
  - Install Jenkins and start the service:
    ```
    sudo apt update
    sudo apt install openjdk-11-jdk
    wget -q -O - https://pkg.jenkins.io/debian/jenkins.io
    ```
- *Install kubectl on the Jenkins:*
```bash
sudo apt install snapd
sudo snap install kubectl --classic
sudo su jenkins
```

- *Setting up kubernetes configurations:*
  - Create and opening .kube Directory 
```bash
mkdir /var/lib/jenkins/.kube
vi /var/lib/jenkins/.kube/config
```
  - Copy the content of the Kubeconfig file provided by Rancher and paste it into the vi editor.

- *Create Credentials for Git and Docker:*
  - Go to Dashboard>> Manage Jenkins>> Manage Credentials
  - Click on System under Stores scopes to Jenkins
  - Click on Global credentials(unrestricted)
  - Add your credentials of GitHub and Docker here.

- *Building pipeline:*
  - Log in to the Jenkins UI, click on "new-item"
  - Enter a name for the pipeline and select "Pipeline" type to create
  - In the pipeline configuration, scroll down to the "Build Triggers" section.
  - Select "Build periodically" and set up a cron job to check for changes every minute. For example: * * * * *

- *Connect to git repository:*
  - Pipline>> Pipeline script from SCM
  - Choose git and enter repo url and add credentials.
  - Under Script Path field enter Jenkinsfile
 
- *Install Plugins and writing Jenkinsfile:*
  - Manage Jenkins>>Manage plugins
  - Install github and docker plugin without restart
  - Configure Environment variable for Dockerhub password
  - Writing Jenkinsfile and defining pipeline stages

![image](https://github.com/krithikajain/SWE645-hw2/assets/161773814/02af46f2-fc8b-446c-922f-c23d18d8f24f)

- *Running the pipeline:*
  - Make changes into the web app created and push to github
  - Jenkins pipeline will automatically trigger these changes
  - The pipeline will build the .war file, create a Docker image, push it to DockerHub, and deploy it to Rancher.
  - Finally, the changes are reflected.
    
  successful CI/CD pipleine
  ![image](https://github.com/krithikajain/SWE645-hw2/assets/161773814/162d5ce9-b08c-4882-9537-c7a22e9e56d4)

