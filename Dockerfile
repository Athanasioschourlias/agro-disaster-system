FROM maven

WORKDIR /usr/app
COPY . .
EXPOSE 8081

CMD mvn spring-boot:run