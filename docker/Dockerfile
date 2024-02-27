# Utilisez l'image eclipse-temurin 17 comme image de base pour la construction
FROM eclipse-temurin:17 as builder
#Définissez le répertoire de travail dans le conteneur
WORKDIR application
#Définnissez une variable d'argument pour le nom de l'interfact
ARG ARTIFACT_NAME
# copiez le ficjier .jar de l'artefact dans le conteneur
COPY ${ARTIFACT_NAME}.jar application.jar
#Executez la commande java pour extraire les couches du .jar
RUN java -Djarmode=layertools -jar application.jar extract


FROM eclipse-temurin:17

WORKDIR application

ARG EXPOSED_PORT
EXPOSE ${EXPOSED_PORT}

ENV SPRING_PROFILES_ACTIVE docker

COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
