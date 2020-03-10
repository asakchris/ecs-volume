### Deploy Spring Boot Application in ECS Cluster with Volume
#### Build
Build images in local registry:
```
mvn package
```
Build images in local registry and push into remote registry:
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
Get into container:
```
docker exec -it ecsvolume_ecs-write_1 /bin/sh
docker exec -it ecsvolume_ecs-red_1 /bin/sh
```
Inspect volume:
```
docker volume inspect ecsvolume_ecs-shared
```