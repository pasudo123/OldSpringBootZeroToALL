# Building Java Projects With Gradle
- [Building Java Projects With Gradle](https://spring.io/guides/gs/gradle/#initial)

## Gradle 이란,
Build Tool 이다. Build 란 자바로 프로그램을 작성한다고 하면 자바코드가 존재하고, 그 안에서 사용되는 코드들은 어느 외부의 라이브러리에 의존하고 있을 것이다. 이를 __컴파일하고 패키징하는 과정을 Build(빌드) 라고 한다.__ Build Tool 에는 Ant, Apache Ivy, Maven, Gradle 등 존재한다.
   
Ant의 가장 큰 장점은 개발자가 자유롭게 빌드 단위를 지정하고 빌드 단위 간의 의존관계를 자유롭게 설정할 수 있다는 점이 있다. 하지만 자유도가 높다는 것은 잘 활용이 되면 좋지만 잘 활용이 되지 않을 경우에는 무용지물이 된다. 그리고 Maven 의 가장 큰 장점은 Convention Over Configuration 전략에 따라 프로젝트 빌드 과정에 대한 많은 부분이 이미 관례로 정해져 있다는 것이다. 하지만 관례가 항상 좋은 것만은 아니다.

Gradle 은 Ant의 자유도와 Maven의 관례의 장점을 모두 흡수하고, 이것들을 대체할 수 있는 빌드, 프로젝트 구성 및 관리, 테스트, 배포에 관한 툴이다. 메이븐이 정적인 형태의 XML 기반으로 작성되어 있어, 동적인 빌드인 경우에는 어려움이 많다. Gradle 은 AntBuilder 와 Groovy Script 를 통해 Ant 의 역할, 배포 스크립트의 역할까지도 가능하며, 기존 메이븐으로 작성한 빌드코드를 간략하게 줄여준다. 그리고 필요에 따라서 쉽게 프로그래밍적으로 빌드 스크립트를 작성할 수 있다.
   
Gradle 은 위에서 언급한 것처럼 Groovy 기반 DSL (Domain Specific Language) 를 사용하고 의존성 기반 프로그래밍 언어를 위한 툴로써, 빌드, 멀티빌드, 의존성 관리의 다양한 방법을 제공하며 Gradle Wrapper 를 이용하여 Gradle 이 설치되지 않은 곳에서 빌드가 가능하다.


## Gradle 설치 (windows 10 기준)
1. https://gradle.org/ 에 접속
2. Install Gradle 을 클릭하여 Complete 를 다운받는다. (2018 12 01 기준, gradle-5.0-all.zip 다운)
3. 드라이브에 옮기고 압축을 해제한다.
4. 압축을 해제한 디렉토리 명을 gradle 로 변경한다.
5. 이후에 환경 변수 패스에 D:/gradle/bin 까지의 경로를 설정한다.
6. CMD 로 "gradle -v" 를 입력해서 결과를 확인한다.
```cmd
C:\Users\PASUDO>gradle -v

------------------------------------------------------------
Gradle 5.0
------------------------------------------------------------

Build time:   2018-11-26 11:48:43 UTC
Revision:     7fc6e5abf2fc5fe0824aec8a0f5462664dbcd987

Kotlin DSL:   1.0.4
Kotlin:       1.3.10
Groovy:       2.5.4
Ant:          Apache Ant(TM) version 1.9.13 compiled on July 10 2018
JVM:          1.8.0_131 (Oracle Corporation 25.131-b11)
OS:           Windows 10 10.0 amd64
```
7. CMD 로 gradle 설치 "gradle" 입력
```cmd
C:\Users\PASUDO>gradle

> Task :help

Welcome to Gradle 5.0.

To run a build, run gradle <task> ...

To see a list of available tasks, run gradle tasks

To see a list of command-line options, run gradle --help

To see more detail about a task, run gradle help --task <task>

For troubleshooting, visit https://help.gradle.org

BUILD SUCCESSFUL in 2s
1 actionable task: 1 executed
```

## Gradle 관련 추가 설명
### Declare Dependencies (의존성 선언)
빌드에 컴파일 종속성으로 외부 라이브러리를 이용한다면, 컴파일 종속성에 의해 빌드가 실패하게 된다. 따라서 build.gradle 코드에 외부 라이브러리에 대한 소스를 추가해주어야 한다.
```gradle
repositories {
    mavenCentral()
}

sourceCompatibility = 1.8
targetCompatibility = 1.8

dependencies {
    compile "joda-time:joda-time:2.2"
    testCompile "junit:junit:4.12"
}

jar {
    baseName = 'gs-gradle'
    version =  '0.1.0'
}
```
- __repositories__ 블록은 빌드가 Maven Central 레파지토리의 종속성을 해결해야 함을 의미한다. Gradle 은 사실 Maven 빌드 도구에 의해 설정된 많은 규약과 시설에 크게 의존하게 된다. 여기서 외부 라이브러리 종속성 소스로 Maven Central 을 사용하는 옵션이 포함되는 것이다.   
- __dependencies__ 블록은 joda-time:joda-time:2.2 의 라이브러리를 요구하고 있음을 선언하는 구문이다.   
- __compile__ 은 컴파일 타임때 사용할 수 있어야 함을 이야기 하는 종속성이다. 결과적으로 컴파일 타임에 의존성을 받아오는 것을 의미한다.
- __testCompile__ 은 테스트 컴파일 및 실행에 사용되지만 실제 프로젝트 런타임 코드를 작성하거나 실행하는 경우에는 필요하지 않다.
- __jar__ 블록은 JAR 파일의 이름을 지정하는 것이다.   

Gradle Build 를 하게되면 Gradle 이 Maven Central 에서 joda-time 의 종속성을 해결하여 빌드가 완료된다.

## Gradle Wrapper
Gradle Build 를 시작할 때 선호되는 방법이다. 윈도우즈용 배치 스크립트와 OS X 및 리눅스 Shell Script 를 사용하면 __시스템에 Gradle 을 설치하지 않고 Gradle 을 빌드 실행할 수 있다.__ 로컬에 설치된 Gradle 또는 Java 의 버전도 신경쓸 필요가 없기 때문에 항상 Wrapper 를 사용할 것을 권장하고 있다. [참고](https://medium.com/@goinhacker/%EC%9A%B4%EC%98%81-%EC%9E%90%EB%8F%99%ED%99%94-1-%EB%B9%8C%EB%93%9C-%EC%9E%90%EB%8F%99%ED%99%94-by-gradle-7630c0993d09)   


