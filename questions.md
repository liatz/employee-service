# 1. How can you ensure High Availability for this application?
* Scaling up and down - high availability is achieved by scaling the servers up or down depending on the application server's load and availability. \
* Deploy application over multiple servers in different datacenters and geographical areas to keep the application running all the time.\
* Add Load Balancing - A load balancer is something that acts as a reverse proxy and distributes the application traffic across a number of servers.
* Databases - To achieve high availability on the DB side we will use the Replication strategies.\
* Hardware: highly available servers should be resilient to power outages and hardware failures, including hard disks and network interfaces.\
* Software: the whole software stack, including the operating system and the application itself, must be prepared for handling unexpected failure.\
* Data: data loss and inconsistency can be caused by several factors, and it’s not restricted to hard disk failures. Highly available systems must account for data safety in the event of a failure.\
* Integrate monitoring tool to provide insight into an application's performance and its current function\

# 2. How can you launch multiple containers of the same micro-service; what are the basic requirements? What are the best practices?
You can use docker-compose, use scale parameter to run multiple instances of the same image.\
Don't map them all to the same port on the host machine\
In order to be able to access the service without knowing the port of the specific container and to distribute the requests to a container with load balancing mechanisms, we need to add a load balancer to the system configuration.\
Example: In employee-service, we’ll use NGINX as the load balancer.\
configure NGINX to forward the request from port 4000 to http://employee-service:8000\
This will then be resolved by Docker’s embedded DNS server, which will use a round robin implementation to resolve the DNS requests based on the service name and distribute them to the Docker containers.\
command: docker-compose up --scale employee-service=3\
browse to : http://localhost:4000/employees\

# 3. How can you provide continuous integration and continuous deployments to your app? What are the best practices?
The technical goal of CI is to establish a consistent and automated way to build, package, and test applications.\
Continuous delivery picks up where continuous integration ends. CD automates the delivery of applications to selected infrastructure environments.\
The crucial part of CI/CD is the version control system to manage the source code. In addition, we need a repository hosting service that our build and deploy steps will tie into.\
Let's choose Git as the VCS and GitHub as our repository provider as they are the most popular at the moment and free to use.\
Another part of the CI/CD process is a service that will build and test our pushed code.\
After that, create a Docker image and pushed it to DockerHub.\
Lastly, deploy the application on any service and accessed it. \
For instance, we could deploy it on cloud-based PaaS or IaaS.

# 4. What is your preferred Containers Orchestration solution; why?
My preferred Containers Orchestration is Kubernetes Orchestration\
Container orchestration automates the scheduling, deployment, networking, scaling, health monitoring, and management of containers.\
* Kubernetes is an open-source Google initiative to automate deployment, scaling, and management of containerized applications, and is backed by the Cloud Native Computing Foundation. \
* Kubernetes helps you move faster.\
* Kubernetes is cloud agnostic. Kubernetes runs on Amazon Web Services (AWS), Microsoft Azure, and the Google Cloud Platform (GCP), and you can also run it on-premise.\
* Cloud providers will manage Kubernetes for you. Kubernetes is currently the clear standard for container orchestration tools.\