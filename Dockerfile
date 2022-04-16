FROM icr.io/appcafe/open-liberty-devfile-stack:21.0.0.12 as build

USER root
COPY src /src
COPY pom.xml /
RUN mvn -B package

USER 1001

# Stage 2: Place application on a liberty server
# TODO: Invest in using a kernel build and use the feature manager to install 
# needed Liberty features
FROM icr.io/appcafe/open-liberty:22.0.0.1-full-java8-openj9-ubi

#FROM icr.io/appcafe/open-liberty:22.0.0.1-full-java11-openj9-ubi

ARG VERSION=1.0
ARG REVISION=SNAPSHOT

COPY --from=build --chown=1001:0 /target/liberty-test-app.war /config/apps/
COPY --chown=1001:0 server.xml /config/

#EXPOSE 9080 9443
EXPOSE 9443

#LABEL io.openshift.expose-services 9080/http
LABEL io.openshift.expose-services 9443/https
