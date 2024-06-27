#Application type - downloads the image 
FROM openjdk:8-jdk-alpine

#Add jar to docker container
ADD target/SpringConversionFactor-0.0.2-SNAPSHOT.jar springconversionfactor.jar

#Expose the container on a port
EXPOSE 8061

#Command whith which docker container will run 
ENTRYPOINT ["java","-jar","springconversionfactor.jar"]