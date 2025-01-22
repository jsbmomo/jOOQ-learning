## jOOQ 개발 환경을 구성하고, 살펴보기 👀


### 목적
jOOQ는 `Java Object Oriented Querying`의 약자로 자바코드로 SQL을 작성할 수 있게 도와주는 프레임워크입니다.<br/> 
이는 QueryDSL과 같이 Compile 시점에서 구문 오류를 파악 가능(Type Safe)한 Native Query를 만들 수 있다는 이점이 있습니다.<br/>
또한, 
> [!NOTE] 
> 이 프로젝트는 간단하게 jOOQ 개발 환경을 구성하고 실행시키는 것에 초점을 맞추어 H2 DB를 사용하였습니다.<br/>
> 하지만, jOOQ는 컴파일 시점에 DB 스키마를 기반으로 코드를 생성합니다,<br/>
> 이로 인해 In-memory 방식의 H2 사용하면 테이블이 생성되기전 jOOQ가 DB 스키마를 스캔하여 jOOQ의 코드 생성에 실패하는 문제가 발생합니다.<br>
> 이 문제를 해결하기 위해 file 방식의 H2 DB를 사용합니다.<br/>
> 만약 MariaDB, Postgresql과 같이 따로 사용하는 DB가 있다면 H2, flyway 등의 설정이 필요하지 않습니다.
<br/>

### 개발환경 
* Intellij 2024.01
* Spring Boot 3.3.4
* Gradle 8.11
* H2 2.2.224
* jOOQ 3.19
* flyway 10.10.0
<br/>

### 실행순서

- 터미널에서 `./gradlew flywayMigrate` 명령 또는 Intellij 우측 Gradle > Tasks > flyway > flywayMigrate로 DB 정보를 생성해줍니다.
  
  ![gradle-tasks-flyway-migration](https://github.com/user-attachments/assets/364a550c-7bc8-45c5-8582-c210c5b8f442)
  
  <details>
    
    <summary>$\bf{\color{#DD6565}flyway\ 주의사항}$</summary> 
    
      flyway는 기본적으로 `src/main/resources/db/migration` 경로에서 파일을 읽으며,
      application.yml에서 `spring.flyway.locations`을 통해 경로를 변경할 수 있습니다.
      또한, flyway가 .sql 파일을 읽도록 하기 위해서는 아래와 같은 파일명 규칙을 지켜줘야 합니다.
    
      - prefix: V, U, R 중 하나
      - Version: 버전정보 (정수, 소수, 날짜 가능)
      - Separator: `__` (two underscore)
      - Description: 파일설명

      ex) V1__init_table.sql
  
  </details>

  특별한 문제가 없다면 build > data 폴더에 DB 정보가 담긴 파일이 생성됩니다.

  ![gradle-tasks-flyway-info-result](https://github.com/user-attachments/assets/c7e2dd88-b09d-40d0-965c-8dfcf87babe5)
  

- `./gradlew flywayInfo` 명령 또는 Intellij 우측 Gradle > Tasks > flyway > flywayInfo로 flyway가 정상 동작했는지 확인합니다. <br/>
  .sql 파일을 제대로 읽었다면 아래와 같이 출력됩니다.

  ![image](https://github.com/user-attachments/assets/42d5004a-1c14-4457-b5c2-acf77c83ebdf)
  

- Gradle build(`./gradlew build`)를 실행시키고, `build > generated-src > jooq` 폴더 안에 jOOQ 객체가 아래와 같이 생성됐는지 확인합니다.

  ![jOOQ-code-generate](https://github.com/user-attachments/assets/bf01f01f-722e-4fee-a08f-71cdfffda036)
  

- 이후, Spring Boot 애플리케이션을 실행시키면 정상동작하는 것을 확인할 수 있습니다.
  
  ![application_run_success](https://github.com/user-attachments/assets/6162a102-1489-4db6-aad3-f60963b4dc6a)


<br/>

## 참고문서
[Spring Boot: Application Properties](https://docs.spring.io/spring-boot/3.3/appendix/application-properties/index.html)<br/>
[jooq: Implement jOOQ with Spring Boot and Gradle](https://rashidi.github.io/spring-boot-tutorials/jooq/)<br/>
[jooq: Gradle-jooq-plugin](https://github.com/etiennestuder/gradle-jooq-plugin)<br/>
[jooq에 대해 좀 더 알아보자](https://sightstudio.tistory.com/68)<br/>
[jooq 개념과 Spring Boot에서의 사용법](https://blog.naver.com/clevekim/223037815613)<br/>
[How to Use Flyway for Database Migrations in Spring Boot](https://blog.jetbrains.com/idea/2024/11/how-to-use-flyway-for-database-migrations-in-spring-boot-applications/)<br/>
