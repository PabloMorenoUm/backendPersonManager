FROM maven:3.9.5-amazoncorretto-8 as maven

COPY ./pom.xml ./pom.xml

COPY ./src ./src

RUN mvn dependency:go-offline -B

RUN mvn package

FROM jetty

COPY --from=maven target/backend.war /var/lib/jetty/webapps/
EXPOSE 8080

#CMD ["java", "-jar", "../../../$JETTY_HOME/start.jar"]