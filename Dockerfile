FROM eclipse-temurin:21.0.5_11-jdk

EXPOSE 8080

WORKDIR /app

COPY pom.xml .

COPY .mvn ./.mvn

COPY mvnw .

RUN ./mvnw dependency:go-offline

COPY src ./src

RUN ./mvnw clean install -DskipTests

ENTRYPOINT [ "java","-jar","/app/target/blog-0.0.1-SNAPSHOT.jar" ]

