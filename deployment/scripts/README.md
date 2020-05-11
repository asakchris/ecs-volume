##### Execute Cloudformation template using scripts
This script should be executed from repository root directory
###### Create/update all stacks
```commandline
./deployStack.sh <ENV> <ImageVersion> <IsActive>

ENV - DEV
ImageVersion - 1.0.0-SNAPSHOT
IsActive - true
```
Cloudformation doesn't support EFS volumes, run below AWS CLI commands to update it:
```
aws efs create-access-point --cli-input-json file://deployment/aws-cli/efs-access-point.json

aws ecs register-task-definition --cli-input-json file://deployment/aws-cli/write-task-definition.json
aws ecs update-service --cli-input-json file://deployment/aws-cli/write-ecs-service.json

aws ecs register-task-definition --cli-input-json file://deployment/aws-cli/read-task-definition.json
aws ecs update-service --cli-input-json file://deployment/aws-cli/read-ecs-service.json
```