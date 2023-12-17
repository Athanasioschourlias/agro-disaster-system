# Read Me First

Here are the steps necessary to get you up and running, with the rest API and maven.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#web)

### From Zero to Hero

Here we have the steps needed for you to be able to fire up the project if you just have a blank, brand new pc.

1. **First and foremost** you will need a java JDK, this can be downloaded
   from the integrated java versioning manager the IntelliJ IDEA has,
   or from a vendor of your choice. **THIS PROJECT IS BUILD WITH THE LATEST VERSION AMAZON USES AND SUPPORTS FOR LONG TERM USE,
   THIS IS THE VERSION 11**
2. Next step (Optional) would be for you to download the maven this can be done following this tutorial, https://www.digitalocean.com/community/tutorials/install-maven-mac-os (On mac)
   https://www.digitalocean.com/community/tutorials/install-maven-linux-ubuntu (Linux Ubuntu)
3. There is also an other way to run the project, this is to use the maven wrapper that we have already build and included in the app for the end
   user to be abe to use. (mvnw for linux and mac, mvnw.cmd for windows)


### Executing the app with Docker(Suggested)
In order to run the app with docker-compose you will need the following:

1. Have docker & docker compose installed in your pc.
2. Create a copy of the file `example.env` with the name `.env` and fill the variables
3. Run the following command `docker compose -p agro-disaster-app up -d --build` when you are at the root directory of the project.
4. Now to stop the application and clean up the containers you need to run, `docker compose -p agro-disaster-app down`.

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

