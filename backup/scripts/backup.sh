#!/bin/bash

cd /data/backup

filename="asset_backup_$(date +%Y%m%dT%H%M).tar.gz"
echo filename: $filename
echo BACKUP_S3_BUCKET: $BACKUP_S3_BUCKET

tar -cvzf $filename /data/scheduler

aws s3 cp $filename s3://$BACKUP_S3_BUCKET
