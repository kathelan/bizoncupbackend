FROM gradle:latest AS BUILD
WORKDIR /usr/app/
COPY . .
RUN gradle build

FROM openjdk:17-jdk-buster
RUN apt-get update && apt-get install -y nginx
ENV JAR_NAME=bizoncup-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY --from=BUILD $APP_HOME .
COPY nginx.conf /etc/nginx/nginx.conf
EXPOSE 80
CMD ["sh", "-c", "nginx && exec java -Dserver.port=8080 -jar $APP_HOME/build/libs/$JAR_NAME"]
