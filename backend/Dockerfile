FROM eclipse-temurin:23-jre-alpine

LABEL maintainer="calculator-team"
LABEL description="Calculator Application Backend"

WORKDIR /app

COPY target/calculator-backend-1.0.0.jar app.jar

EXPOSE 8080

ENV JAVA_OPTS=""
ENV SPRING_PROFILES_ACTIVE=prod

HEALTHCHECK --interval=30s --timeout=3s --start-period=40s --retries=3 \
  CMD wget --no-verbose --tries=1 --spider http://localhost:8080/api/calculate/health || exit 1

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
