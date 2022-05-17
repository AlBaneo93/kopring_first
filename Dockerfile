FROM openjdk:17-alpine

WORKDIR /app

ADD . /app

RUN chmod +x ./gradlew && \
 ./gradlew build && \
 cp ./build/libs/basic_crud.jar ./app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar", "app.jar"]