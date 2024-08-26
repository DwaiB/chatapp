FROM openjdk:17
EXPOSE 8080
ADD target/chatapp.jar chatapp.jar
ENTRYPOINT [ "java","-jar","/chatapp.jar" ]