# ConsumingRest Application

This project demonstrates how to consume a RESTful service with a Java application packaged within a Docker container. The application makes calls to the Quoters RESTful service.

## Prerequisites

- Docker
- Kubernetes
- kubectl

## Setup and Run Quoters Service

1. **Run Quoters Service on Kubernetes**:
   Deploy the Quoters service using the following commands:

    ```bash
    kubectl run quoters --image=javajon/quoters:1.0.0 --port=8080
    kubectl expose pod quoters --name=quoters
    kubectl get all -l run=quoters
    ```

2. **Port Forwarding**:
   To access the Quoters service locally, use port-forwarding:

    ```bash
    kubectl port-forward service/quoters 8080:8080
    ```

   Keep this running, and use Ctrl-C to stop the port forwarding when done.

## Build the Application

To build the Docker image for the ConsumingRest application, run the following command from the root of this project:

  ```bash
    docker build -t yourname/consumingrest .
```
## Run locally 
After building the image, you can run it locally using:
    ```bash
    docker run -p 8080:8080 yourname/consumingrest
    ```
# test
Test the service by accessing:
    ```bash
     http://localhost:8080
      ```

## Deploy on Kubernetes

1. **Push to Docker Hub**:
   Ensure you are logged into your Docker Hub account and push the image:
   ```bash
   docker push yourname/consumingrest
     ```
2. **Run on Kubernetes**:
   Deploy your container in Kubernetes by running:
   ```bash
   kubectl run consumingrest --image=yourname/consumingrest --env="quoters_base_url=http://quoters:8080"
     ``` 
3. **Check Logs**:
   To ensure that the application is running as expected and making the REST calls successfully, check the logs:
   ```bash
   kubectl run consumingrest --image=yourname/consumingrest --env="quoters_base_url=http://quoters:8080"
     ``` 
Replace yourname with your Docker Hub username to correctly reference your Docker image in the commands.
