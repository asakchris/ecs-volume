FROM openjdk:8 as stage0
WORKDIR /opt/docker
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib app/lib
COPY ${DEPENDENCY}/META-INF app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes app
USER root
RUN ["chmod", "-R", "u=rX,g=rX", "/opt/docker"]

FROM openjdk:8
VOLUME /tmp
RUN mkdir -p /data/scheduler
USER root
RUN groupadd -g 1002 ids_grp_ro
RUN id -u ids_app 2> /dev/null || useradd --system --create-home --uid 1002 --gid 1002 ids_app_ro
WORKDIR /opt/docker
COPY --from=stage0 --chown=ids_app_ro:ids_grp_ro /opt/docker /opt/docker
#RUN chown -R ids_app:ids_grp /data/scheduler
USER 1002
VOLUME /data/scheduler
ENTRYPOINT java ${JAVA_OPTS} -cp /opt/docker/app:/opt/docker/app/lib/* com.example.Application
