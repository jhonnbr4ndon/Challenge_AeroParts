# Use a imagem base do Java 17
FROM openjdk:17-jdk-slim-buster

# Copie o arquivo JAR do seu projeto para dentro do contêiner
COPY target/AeroParts-0.0.1-SNAPSHOT.jar app.jar

# Defina o comando a ser executado quando o contêiner for iniciado
CMD ["java", "-jar", "app.jar"]

