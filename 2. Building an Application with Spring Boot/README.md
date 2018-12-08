# Building an Application with Spring Boot
[Building an Application with Spring Boot](https://spring.io/guides/gs/spring-boot/)

## Learn what you can do with Spring Boot
스프링부트는 애플리케이션을 빠르게 빌드할 방법을 제공하고 있다. 클래스 패스와 빈(Bean) 을 살펴보며, 합리적으로 추정하고 잃어버린 것들을 설정하고 추가한다. 스프링부트를 사용하게 된다면 인프라 쪽의 포커스를 줄이고, 비즈니스에 포커스를 맞출 수 있다.

__Example)__  
- 스프링 MVC 에 대해서 스프링부트는 이를 자동으로 추가하고, 스프링 MVC 는 서블릿 컨테이너를 필요로 하기 때문에 부트또한 임베디드 Tomcat 을 자동으로 구성한다.
- Jetty 를 원한다면, Jetty 를 임베디드 시킬 수 있다.
- Thymeleaf 를 원한다면, 추가시키면 된다.

> 스프링부트는 코드를 생성하거나 혹은 파일을 편집하지 않는다. 대신 애플리케이션이 시작할 때 스프링부트는 빈과 설정들을 동적으로 연결하여 application context 에 적용시킨다.

## Create a Simple Web Application
_src/main/java/hello/HelloController.java_
```java
package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
```
   
_src/main/java/hello/Application/java_
```java
package hello;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

}
```
__SpringBootApplication 은 다음을 추가하는 편리한 애노테이션이다.__   
1. @Configuration
2. @EnableAutoConfiguration
3. @EnableWebMvc
4. @ComponentScan

__main()__  
애플리케이션을 실행시킨다. 순수한 100% Java 이며, 인프라 구성에 대해서 처리할 필요가 없다.

## Run the application
```cmd
./gradlew build
```

```cmd
java -jar build/libs/gs-spring-boot-0.1.0.jar
```

위의 구문을 연속적으로 실행시키면, gradle build 이후에 실행시킬 수 있다. 그리고 아래와 같이 curl 명령어를 실행하면 결과를 받아볼 수 있다.
```cmd
C:\Users\PASUDO>curl localhost:8080
Greetings from Spring Boot!
```

## Add Unit Tests
우선적으로 build.gradle 에 아래와 같은 내용을 추가한다. 
```gradle
testCompile("org.springframework.boot:spring-boot-starter-test")
```
   
그리고 _src/test/java/_ 에 HelloControllerTest.java 파일을 만들어 아래와 같이 작성한다.
```java
package hello;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }
}
```
__MockMvc__  
Spring Test 에서 제공되며, Builder Class Set 을 통해 Http 요청을 DispatcherServlet 으로 보내고 이후에 결과에 대한 assertions 를 수행할 수 있도록 한다.   
   
__@AutoConfigureMockMvc & @SpringBootTest__   
MockMvc 인스턴스를 삽입하기 위해 사용된다.

__@SpringBootTest__   
전체 애플리케이션 컨텍스트가 생성되도록 요청한다. 혹은 __@WebMvcTest__ 를 사용하여 컨텍스트 웹 레이어를 생성할 수 있도록 SpringBoot 에 요청할 수 있다.
