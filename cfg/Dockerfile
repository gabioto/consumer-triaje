FROM mcr.microsoft.com/java/jdk:8u265-zulu-alpine
LABEL mantainer="Everis Peru" \
      build="docker build --build-arg nombreArtefacto=artefacto -t microservicio:1.0 -f Dockerfile ." \
      run="docker run -dit --restart on-failure:5 --name microservicio -p 8080:8080 microservicio:1.0"
ARG nombreArtefacto=artefacto.jar
ENV nombreArtefacto ${nombreArtefacto}
RUN apk update && apk upgrade \
	&& apk add ca-certificates \
	&& update-ca-certificates \
# Change TimeZone
	&& apk add --update tzdata
ENV TZ=America/Lima
RUN echo '10.4.88.109  lnxsrpfli0009.gp.inet' >> /etc/hosts
# Copy *.jar and resources files
COPY ${nombreArtefacto} /opt/
WORKDIR /opt/
# Run service java
#CMD ["sh","-c","java -jar ${nombreArtefacto}"]
CMD ["sh","-c","echo 10.4.88.109 lnxsrpfli0009.gp.inet >> /etc/hosts && echo 10.4.88.119 lnxsrpfli0019.gp.inet >> /etc/hosts && echo 10.4.88.138 lnxsrpfli0038.gp.inet >> /etc/hosts && echo 10.4.88.144 lnxsrpfli0044.gp.inet >> /etc/hosts && java -jar ${nombreArtefacto}"]
# Clean APK cache
RUN rm -rf /var/cache/apk/*