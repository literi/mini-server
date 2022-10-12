# Set the base image to centos
FROM centos

###############################################################
# Dockerfile to build java container images
# Based on CentOS
# File Author / Maintainer
###############################################################

RUN mkdir /var/tmp/jdk
COPY jdk-8u221-linux-x64.tar.gz /var/tmp/jdk
RUN tar xzf /var/tmp/jdk/jdk-8u221-linux-x64.tar.gz -C /var/tmp/jdk
RUN rm -rf /var/tmp/jdk/jdk-8u221-linux-x64.tar.gz
# 将目录中的springboot_demo-1.0-SNAPSHOT.jar复制到容器中
ADD server-zuul-0.0.1-SNAPSHOT.jar server-zuul.jar

ENV JAVA_HOME=/var/tmp/jdk/jdk1.8.0_221
ENV PATH=$JAVA_HOME/bin:$PATH
ENV CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tool.jar

EXPOSE 8255

ENTRYPOINT ["java","-jar","/app.jar"]