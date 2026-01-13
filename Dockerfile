# imagem base com Java
FROM eclipse-temurin:17-jre

# diretório de trabalho no container
WORKDIR /app

# copia o jar
COPY target/*.jar app.jar

# porta que a API expõe
EXPOSE 8082

# comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]