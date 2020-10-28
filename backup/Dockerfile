FROM amazon/aws-cli:latest
RUN mkdir -p /data/scheduler && mkdir -p /data/backup
WORKDIR /opt/docker
COPY scripts bin
USER root
RUN yum -y install shadow-utils \
        && yum clean all \
		&& groupadd -g 1001 ids_grp_rw \
		&& id -u ids_app_rw 2> /dev/null || useradd --system --create-home --uid 1001 --gid 1001 ids_app_rw \
		&& chown -R ids_app_rw:ids_grp_rw /opt/docker \
		&& chmod u+x /opt/docker/bin/*.sh
USER 1001
VOLUME /data/scheduler
VOLUME /data/backup
ENTRYPOINT ["/opt/docker/bin/backup.sh"]
