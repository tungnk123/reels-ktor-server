# ---------- Build stage ----------
FROM gradle:8.7-jdk21 AS build
WORKDIR /src

# copy toàn bộ code vào container
COPY . .

# build fat jar bằng shadowJar
RUN gradle shadowJar --no-daemon

# ---------- Runtime stage ----------
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# copy jar từ stage build sang
COPY --from=build /src/build/libs/*-all.jar /app/app.jar

# Koyeb sẽ set PORT env, default 8000
ENV PORT=8000
EXPOSE 8000

# run app với JVM, bind port do Koyeb cung cấp
CMD ["sh", "-c", "java -Dio.ktor.deployment.watch=false -Dport=$PORT -jar /app/app.jar"]
