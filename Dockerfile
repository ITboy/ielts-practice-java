FROM eclipse-temurin:17-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["sleep", "10", "&&", "java", "-jar", "/app.jar"]
ENTRYPOINT ["sh", "-c", "sleep 50 && java -jar /app.jar"]

