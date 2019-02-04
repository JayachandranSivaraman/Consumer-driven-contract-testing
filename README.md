starting the spring boot application
RUN ./gradlew build in the provider.

RUN java -jar build/libs/gs-actuator-service-0.1.0.jar --service.port=8181


try hitting
http://localhost:8181/get-employees
http://localhost:8181/get-salery


build the consumer(in another terminal)
RUN ./gradlew build in the consumer

RUN ./gradlew test (or) sh gradlew in consumer

RUN ./gradlew pactVerify in the provider.
