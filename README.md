## jOOQ 개발 환경을 구성하고, 살펴보기 👀


### 목적
jOOQ는 `Java Object Oriented Querying`의 약자로 자바코드로 SQL을 작성할 수 있게 도와주는 프레임워크입니다.<br/> 
이는 QueryDSL과 같이 Compile 시점에서 구문 오류를 파악 가능(Type Safe)한 Native Query를 만들 수 있다는 이점이 있습니다.
> [!NOTE] 
> 이 프로젝트는 간단하게 jOOQ 개발 환경을 구성하고 실행시키는 것에 초점을 맞추어 H2 DB를 사용하였습니다.<br/>
> 하지만, jOOQ는 컴파일 시점에 DB 스키마를 기반으로 코드를 생성하기 때문에 In-memory 방식의 H2 DB 사용 시, DB 스키마가 생성되기도 전에 jOOQ가 DB 스키마를 스캔하여 jOOQ 코드 생성에 실패합니다.<br>
> 때문에, file 방식의 H2 DB를 사용합니다.


### 개발환경 
* Spring Boot 3.3.4
* Gradle 8.11
* H2 2.2.224
* jOOQ 3.19


### 참고문서
[Spring Boot: Application Properties](https://docs.spring.io/spring-boot/3.3/appendix/application-properties/index.html)<br/>
[jooq: Implement jOOQ with Spring Boot and Gradle](https://rashidi.github.io/spring-boot-tutorials/jooq/)<br/>
[jooq: Gradle-jooq-plugin](https://github.com/etiennestuder/gradle-jooq-plugin)<br/>
[jooq에 대해 좀 더 알아보자](https://sightstudio.tistory.com/68)<br/>
[jooq 개념과 Spring Boot에서의 사용법](https://blog.naver.com/clevekim/223037815613)<br/>
