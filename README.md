### Deploy Spring Boot Application in ECS Fargate Cluster with EFS Volume
Refer [this](https://aws.amazon.com/blogs/aws/amazon-ecs-supports-efs/) link for more details.
#### Build
Build images in the local registry:
```
mvn package
```
Build images in the local registry and push into the remote registry:
```
mvn deploy
```
Verify application:
```
http://localhost:8000/api/v1/ecsvolume/read/log
```
#### Docker Compose
Bring up all services:
```
docker-compose up -d
```
Bring down all services:
```
docker-compose down
```
Status of all services:
```
docker-compose ps
```
Logs:
```
docker-compose logs -f --tail="all"
docker-compose logs -f --tail="all" ecs-write
docker-compose logs -f --tail="all" ecs-read
```
Get into the container:
```
docker exec -it ecsvolume_ecs-write_1 /bin/sh
docker exec -it ecsvolume_ecs-red_1 /bin/sh
```
Inspect volume:
```
docker volume inspect ecsvolume_ecs-shared
```