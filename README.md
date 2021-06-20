# league-ranking-service

    #SpringBoot Microservice
    #Postman testing collection
    #Postman DEV and QA environments
    
    #NOTE: 
    DEV - The "dev" profile  will run out of the box without any config changes or setup required. It uses an h2 embedded database with schema that runs at runtime. This will       only be available in the 'dev" env for development.
    
    QA - "qa" profile requires a MySQL database and the inserted scripts needs to be ran to create the tables and the datasource config in the application-qa.properties need                to be changed where necesary.
    
    PROD - "prod" profile requires prod environment setup and config to be made in the application-prod.properties file.

The league-ranking-service is a springboot microservice that exposes two enpoints:

    1: Capture Results
    2: View Ranking Table
    
NOTE:

    The client and service package builds must correspond to map to the basepaths of the environments.
    i.e -P dev or -P qa or -P prod
  
  dev profile:
  
    Note: to run the dev profile, build using the following command:
      mvn clean install -P dev or,
      specify dev in the run configuration "Active Profiles"
    
  API:
  
      basepath: localhost:9009/api/fixtures
      capture result: /result/{result} - the path variable takes a string i.e "Lions 3, Snakes 3"
      view ranking: /ranking
      
  Web security:
  
        There are two users allowed to access these endpoints:
        
        Admin user: Can access both api calls.
          Username: admin
          Password: p@55w0rd
          
          Guest user: Can only access view api call.
          Username: guest
          Password: p@55w0rd1
    
  Database:
  
      Embedded h2 database - Annotated with @Profile("dev") in order to only run in dev environment and not i.e qa or prod.
      basepath: http://localhost:9009/api/console
      Login with admin or guest 
      JDBC Url: jdbc:h2:mem:testdb
      Connect
      
  Swagger Documentation:
  
      basepath: http://localhost:9009/api/swagger-ui.html
      Login with admin or guest
      
  JSON Code:
  
      Used to generate yaml contract - generate yaml from JSON - use swagger codegen in client application to generate Java code for API access.
      basepath: http://localhost:9009/api/v2/api-docs
      Login with admin or guest
      
  qa profile:
  
    Note: to run the qa profile, build using the following command:
      mvn clean install -P qa or,
      specify qa in the run configuration "Active Profiles"
    
  API:
  
      basepath: localhost:9090/api/fixtures
      capture result: /result/{result} - the path variable take a string i.e "Lions 3, Snakes 3"
      view ranking: /ranking
      
  Web security:
  
        There are two users allowed to access these endpoints:
        
        Admin user: Can access both api calls.
          Username: admin
          Password: p@55w0rd
          
          Guest user: Can only access view api call.
          Username: guest
          Password: p@55w0rd1
    
  Database:
  
      MySQL - To use this data source you will have to create a MySQL Instance conforming to the below config or replace the current valuse with your current MySQL data source.
      #MySQL Data Source
      spring.jpa.generate-ddl=false
      spring.datasource.url=jdbc:mysql://localhost:3306/league_ranking_qa
      spring.datasource.username=root
      spring.datasource.password=p@55w0rd
      
  Scripts to create Tables:
  
      CREATE DATABASE `league_ranking_qa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

  -- league_ranking_qa.fixtures definition

      CREATE TABLE `fixtures` (
        `id` int NOT NULL AUTO_INCREMENT,
        `team_1_name` varchar(255) DEFAULT NULL,
        `team_1_score` varchar(255) DEFAULT NULL,
        `team_2_name` varchar(255) DEFAULT NULL,
        `team_2_score` varchar(255) DEFAULT NULL,
        PRIMARY KEY (`id`)
      ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

  -- league_ranking_qa.points definition

      CREATE TABLE `points` (
        `id` int NOT NULL AUTO_INCREMENT,
        `team_1_name` varchar(255) DEFAULT NULL,
        `team_1_points` varchar(255) DEFAULT NULL,
        `team_2_name` varchar(255) DEFAULT NULL,
        `team_2_points` varchar(255) DEFAULT NULL,
        PRIMARY KEY (`id`)
      ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

  -- league_ranking_qa.ranking definition

      CREATE TABLE `ranking` (
        `id` int NOT NULL AUTO_INCREMENT,
        `team` varchar(255) DEFAULT NULL,
        `points` varchar(255) DEFAULT NULL,
        PRIMARY KEY (`id`)
      ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
      
  Swagger Documentation:
  
      basepath: http://localhost:9090/api/swagger-ui.html
      Login with admin or guest
      
  JSON Code:
  
      Used to generate yaml contract - generate yaml from JSON - use swagger codegen in client application to generate Java code for API access.
      basepath: http://localhost:9090/api/v2/api-docs
      Login with admin or guest
      
  prod profile:
  
    Note: Incomplete config as AWS setup not done, but Jenkins should have a maven build step
      clean install -P prod
      to run the prod profile, build using the following command:
      mvn package -P prod or,
      specify prod in the run configuration "Active Profiles"
    
  API:
  
    basepath: /api/fixtures
    capture result: /result/{result} - the path variable take a string i.e "Lions 3, Snakes 3"
    view ranking: /ranking
      
  Web security:
  
        There are two users allowed to access these endpoints:
        
        Admin user:
          Username: 
          Password:
          
          Guest user:
          Username: 
          Password: 
    
  Database:
  
      MySQL
      #MySQL Data Source
      spring.jpa.generate-ddl=false
      spring.datasource.url=
      spring.datasource.username=
      spring.datasource.password=
      
  Swagger Documentation:
  
      basepath:
      Login with
      
  JSON Code:
  
      Used to generate yaml contract - generate yaml from JSON - use swagger codegen in client application to generate Java code for API access.
      basepath:
      Login with
      
      
