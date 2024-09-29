# Usar a imagem base do OpenJDK 17 ou versão compatível com seu projeto
FROM openjdk:17-jdk-alpine

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo JAR gerado pelo Spring Boot para o diretório de trabalho
COPY target/curriculo-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta 8080 (ou a porta que sua aplicação usa)
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
