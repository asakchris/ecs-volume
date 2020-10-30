FROM amazon/aws-cli:latest
RUN mkdir -p /data/scheduler && mkdir -p /data/backup
WORKDIR /opt/docker
COPY scripts bin
USER root
RUN yum -y install shadow-utils tar \
        && yum clean all \
		&& groupadd -g 1000 ids_grp_rw \
		&& id -u ids_app_rw 2> /dev/null || useradd --system --create-home --uid 1000 --gid 1000 ids_app_rw \
		&& chown -R ids_app_rw:ids_grp_rw /opt/docker \
		&& chmod u+x /opt/docker/bin/*.sh
USER 1000
VOLUME /data/scheduler
VOLUME /data/backup
ENTRYPOINT ["/opt/docker/bin/backup.sh"]
