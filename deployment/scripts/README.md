##### Execute Cloudformation template using scripts
This script should be executed from repository root directory
###### Create/update all stacks
```commandline
./deployStack.sh <ENV>

ENV - DEV

aws ecs register-task-definition --cli-input-json file://deployment/aws-cli/write-task-definition.json
```