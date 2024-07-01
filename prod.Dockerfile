FROM openjdk:22-bullseye
EXPOSE 8080
COPY app.jar /home/app.jar
CMD java -server -Dserver.tomcat.threads.max=200 -Duser.country=EC -Duser.language=es -Duser.timezone=America/Guayaquil -jar /home/app.jar