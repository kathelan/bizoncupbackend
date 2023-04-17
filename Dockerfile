FROM gradle:latest AS BUILD
WORKDIR /usr/app/
COPY . .
RUN gradle build

FROM openjdk:17
ENV JAR_NAME=bizoncup-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY --from=BUILD $APP_HOME .
EXPOSE 80
ENTRYPOINT exec java -jar $APP_HOME/build/libs/$JAR_NAME