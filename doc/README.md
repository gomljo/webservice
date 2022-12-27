## 🎯 스프링 부트와 AWS로 혼자 구현하는 웹 서비스 
본 프로젝트는 이동욱님의 [스프링 부트와 AWS로 혼자 구현하는 웹 서비스](https://product.kyobobook.co.kr/detail/S000001019679)
를 직접 구현하며 공부하는 프로젝트입니다.  

### 📌 프로젝트 목적
스프링 부트와 AWS를 이용하여 게시판을 직접 구현해보면서 웹 서비스를 제작하는데<br> 
사용되는 스프링 부트에 대해 공부하고 AWS를 이용하여 배포해보며 웹 서비스에 대해 이해한다.

### 🏆 프로젝트 목표
책의 각 챕터를 정리하며 웹 서비스를 구현해보면서 얻은 지식을 통해 나만의 웹서비스를 구축해본다.

### 📝 챕터 별 공부 내용 정리
#### 🔍 CHAPTER 1
스프링 부트에 필요한 설정

책에서 나온 설정 방법은 두 가지가 있다.

첫째, build.gradle 파일을 직접 작성하는 방법은 사용되는 의존성을 명시적으로 작성한다.

#### 🎁 EXAMPLE
```
buildscript {
    ext {
        springBootVersion = '2.1.7.RELEASE'
    }
    repositories {
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
    }
}

apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'org.springframework.boot'
apply plugin: 'io.spring.dependency-management'

group 'org.example'
version '1.0-SNAPSHOT'
sourceCompatibility = 1.8

repositories {
    mavenCentral()
}

dependencies {
    implementation('org.springframework.boot:spring-boot-starter-web')
    compileOnly 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation('org.springframework.boot:spring-boot-starter-test')

}
```

둘째, 스프링 이니셜라이저(https://start.spring.io)를 통해 스프링 부트 프로젝트를 생성한다.

```

```

#### Chapter 2

#### Chapter 3