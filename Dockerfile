# using alpine-glibc instead of alpine  is mainly because JDK relies on glibc
FROM docker.io/jeanblanchard/alpine-glibc
# author
# A streamlined jre
ADD jre1.8.tar.gz /usr/java/jdk/
# set env
ENV JAVA_HOME /usr/java/jdk
ENV PATH ${PATH}:${JAVA_HOME}/bin
# run container with base path:/opt
WORKDIR /opt