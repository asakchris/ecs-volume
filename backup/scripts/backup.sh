#!/bin/bash

cd /data/backup

filename="asset_backup_$(date +%Y%m%dT%H%M).tar"
echo filename: $filename
echo BACKUP_S3_BUCKET: $BACKUP_S3_BUCKET

# take backup
tar -cvf $filename -C /data scheduler

# push backup into S3
aws s3 cp $filename s3://$BACKUP_S3_BUCKET

# delete backup
rm $filename
