# Spring Boot Email Verification and Profile Activation Using a Link

**Brief Description:** Welcome to Spring Boot Email verification! This web application streamlines user registration and enhances security through email verification. Key features include an efficient registration process, secure email verification, and profile activation. Technologies used include Spring Boot for development efficiency, JSP for dynamic content, and MySQL for reliable data storage. This is a valuable solution for secure user authentication and registration in Java web applications.


## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Folder Structure](#folder-structure)
- [Database Setup](#database-setup)
- [Configuration](#configuration)

## Introduction

Welcome to Spring Boot Email verification and profile activation using the link! This web application aims to provide a seamless and secure user registration experience with email verification.


## Features

- **User Registration:** Allow users to create accounts with necessary information.
- **Email Verification:** Send a verification email to users with a link to activate their account.
- **Profile Activation:** Activate user profiles upon successful email verification.


## Technologies Used

- **Spring Boot:** Spring Boot was chosen for its simplicity and convention over configuration approach. It provides a robust and efficient framework for building Java-based web applications.

- **JSP:** JavaServer Pages (JSP) is used for dynamic content generation on the server side. It allows for embedding Java code in HTML pages, providing a seamless integration of Java and HTML for building dynamic web pages.

- **MySQL:** MySQL was selected as the relational database management system due to its widespread usage, reliability, and compatibility with Spring Boot.

## Getting Started

To get started with This app, follow these steps:

1. **Clone the Repository:**
   - Fork or clone this repository to your local machine using the following command:
     ```bash
     git clone https://github.com/your-username/your-repository.git
     ```


2. **Update the Project with Maven:**
   - Navigate to the project directory using the command line:
     ```bash
     cd your-repository
     ```
   - Update the project dependencies and build the project using Maven:
     ```bash
     mvn clean install
     ```
   This will download the required dependencies and build the project.

3. **Start Working:**
   - Open the project in your preferred integrated development environment (IDE).
   - Make any necessary configuration changes (if applicable).
   - Start working on your features or improvements.

4. **Run the Application:**
   - Run the application locally using your IDE or Maven:
     ```bash
     mvn spring-boot:run
     ```
   The application should now be accessible at [http://localhost:8080](http://localhost:8080).


## Folder Structure
<pre>
E:.
|   .classpath
|   .factorypath
|   .gitignore
|   .project
|   HELP.md
|   mvnw
|   mvnw.cmd
|   pom.xml
|
+---.mvn
|   \---wrapper
|           maven-wrapper.jar
|           maven-wrapper.properties
|
+---.settings
|       org.eclipse.core.resources.prefs
|       org.eclipse.jdt.apt.core.prefs
|       org.eclipse.jdt.core.prefs
|       org.eclipse.m2e.core.prefs
|       org.springframework.ide.eclipse.prefs
|
+---src
|   +---main
|   |   +---java
|   |   |   \---com
|   |   |       \---kksg
|   |   |           \---email
|   |   |               |   SpringbootEmailConfirmationApplication.java
|   |   |               |
|   |   |               +---controller
|   |   |               |       UserAccountController.java
|   |   |               |
|   |   |               +---entity
|   |   |               |       ConfirmationToken.java
|   |   |               |       User.java
|   |   |               |
|   |   |               +---repo
|   |   |               |       ConfirmationTokenRepository.java
|   |   |               |       UserRepository.java
|   |   |               |
|   |   |               +---security
|   |   |               |       SecurityConfiguration.java
|   |   |               |
|   |   |               \---service
|   |   |                       EmailService.java
|   |   |
|   |   \---resources
|   |       |   application.properties
|   |       |
|   |       +---static
|   |       \---templates
|   |               accountVerified.html
|   |               error.html
|   |               register.html
|   |               successfulRegisteration.html
|   |
|   \---test
|       \---java
|           \---com
|               \---kksg
|                   \---email
|                           SpringbootEmailConfirmationApplicationTests.java
|
\---target
    +---classes
    |   |   application.properties
    |   |
    |   +---com
    |   |   \---kksg
    |   |       \---email
    |   |           |   SpringbootEmailConfirmationApplication.class
    |   |           |
    |   |           +---controller
    |   |           |       UserAccountController.class
    |   |           |
    |   |           +---entity
    |   |           |       ConfirmationToken.class
    |   |           |       User.class
    |   |           |
    |   |           +---repo
    |   |           |       ConfirmationTokenRepository.class
    |   |           |       UserRepository.class
    |   |           |
    |   |           +---security
    |   |           |       SecurityConfiguration.class
    |   |           |
    |   |           \---service
    |   |                   EmailService.class
    |   |
    |   \---templates
    |           accountVerified.html
    |           error.html
    |           register.html
    |           successfulRegisteration.html
    |
    +---generated-sources
    |   \---annotations
    +---generated-test-sources
    |   \---test-annotations
    \---test-classes
        \---com
            \---kksg
                \---email
                        SpringbootEmailConfirmationApplicationTests.class
</pre>
## Database Setup

```
spring.datasource.url =jdbc:mysql://localhost:3306/links
spring.datasource.username =root
spring.datasource.password =root
spring.datasource.driver-class-name =com.mysql.cj.jdbc.Driver

###### JPA Properties ######
spring.jpa.properties.hibernate.dialect =org.hibernate.dialect.MySQLDialect
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.show-sql =true
```

## Configuration

Dependencies:

```

<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-mail</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.thymeleaf.extras</groupId>
			<artifactId>thymeleaf-extras-springsecurity6</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>


```


