FROM tomcat:alpine

ADD ./context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml

RUN sed -i 's#</tomcat-users>#<role rolename="manager-gui"/>\n<user username="admin" password="admin" roles="manager-gui"/>\n</tomcat-users>#g' /usr/local/tomcat/conf/tomcat-users.xml

ENV JPDA_ADDRESS="8000"
ENV JPDA_TRANSPORT="dt_socket"

EXPOSE 8080 8000
ENTRYPOINT ["catalina.sh", "jpda", "run"]

