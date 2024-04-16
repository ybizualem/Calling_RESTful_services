# ConsumingRest Application

This project demonstrates how to consume a RESTful service with a Java application packaged within a Docker container. The application makes calls to the Quoters RESTful service.

## Prerequisites

- Docker installed on your machine and docker hub account.
- Make sure you enable Kubernetes on the docker app setting if you want to run a kubernetes 
  cluster.
- JDK 17 for running locally without Docker.
  
## Features

This application demonstrates the ability to interact with a RESTful service by making HTTP requests to the Quoters service. Key features include:

- **Consume RESTful API**: The application makes calls to multiple endpoints on the Quoters RESTful service, retrieving data from each endpoint.
- **Docker Containerization**: The Java application is containerized using Docker, ensuring that it can be easily deployed and run in any environment that supports Docker.
- **Kubernetes Integration**: Deployment scripts and instructions are provided for Kubernetes, allowing the application to scale and be managed within a Kubernetes cluster.
- **Logging and Monitoring**: The application logs all RESTful responses, which can be viewed directly via Kubernetes logs to monitor the behavior and output of the application in real time.


## Setup and Run Quoters Service

1. **Run Quoters Service on Kubernetes**:
   Deploy the Quoters service using the following commands:

    ```bash
    kubectl run quoters --image=javajon/quoters:1.0.0 --port=8080
    kubectl expose pod quoters --name=quoters
    kubectl get all -l run=quoters
    ```

2. ** Build gradle **:
     ```bash
    # For macOS/Linux
    ./gradlew build
    # For Windows
    gradlew.bat build
    ```
4.  **Port Forwarding**:
   To access the Quoters service locally, use port-forwarding:

    ```bash
    kubectl port-forward service/quoters 8080:8080
    ```

   Keep this running, and use Ctrl-C to stop the port forwarding when done.

## Run locally 

1. First, clone the repository and navigate to the project root directory. Use the appropriate build command based on your operating system:
   ```bash
   git clone https://github.com/ybizualem/Calling_RESTful_services
   ```
2. To build the Docker image for the ConsumingRest application, run the following command from the root of this project:

   ```bash
    docker build -t your_dockerhub_username/consumingrest .
    ```
2. After building the image, you can run it locally using:
    ```bash
    docker run -p 8080:8080 your_dockerhub_usernam/consumingrest
    ```
3. Test
Test the service by accessing:
    ```bash
     http://localhost:8080
      ```

## Deploy on Kubernetes

1. **Push to Docker Hub**:
   Ensure you are logged into your Docker Hub account and push the image:
   ```bash
   docker push your_dockerhub_username/consumingrest
     ```
2. **Run on Kubernetes**:
   Deploy your container in Kubernetes by running:
   ```bash
   kubectl run consumingrest --image=yourname/consumingrest --env="quoters_base_url=http://quoters:8080"
     ``` 
3. **Check Logs**:
   To ensure that the application is running as expected and making the REST calls successfully, check the logs:
   ```bash
   kubectl logs consumingrest
     ``` 
Replace yourname with your Docker Hub username to correctly reference your Docker image in the commands.
