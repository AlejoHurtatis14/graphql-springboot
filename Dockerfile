# Usar la imagen de OpenJDK como base
FROM openjdk:17-jdk-alpine

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado al contenedor
COPY target/projectgraphql-0.0.1-SNAPSHOT.jar app-project.jar

# Exponer el puerto en el que correrá la aplicación
EXPOSE 9095

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app-project.jar"]
