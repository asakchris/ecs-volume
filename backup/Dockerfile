FROM amazon/aws-cli:latest
RUN mkdir -p /data/scheduler && mkdir -p /data/backup
WORKDIR /opt/docker
COPY scripts bin
USER root
RUN addgroup -g 1001 -S ids_grp_rw && adduser -u 1001 -S ids_app_rw -G ids_grp_rw
RUN chown -R ids_app_rw:ids_grp_rw /opt/docker && chmod u+x /opt/docker/bin/*.sh
USER 1001
VOLUME /data/scheduler
VOLUME /data/backup
ENTRYPOINT ["/opt/docker/bin/backup.sh"]
