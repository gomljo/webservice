## π― μ€νλ§ λΆνΈμ AWSλ‘ νΌμ κ΅¬ννλ μΉ μλΉμ€ 
λ³Έ νλ‘μ νΈλ μ΄λμ±λμ [μ€νλ§ λΆνΈμ AWSλ‘ νΌμ κ΅¬ννλ μΉ μλΉμ€](https://product.kyobobook.co.kr/detail/S000001019679)
λ₯Ό μ§μ  κ΅¬ννλ©° κ³΅λΆνλ νλ‘μ νΈμλλ€.  

### π νλ‘μ νΈ λͺ©μ 
μ€νλ§ λΆνΈμ AWSλ₯Ό μ΄μ©νμ¬ κ²μνμ μ§μ  κ΅¬νν΄λ³΄λ©΄μ μΉ μλΉμ€λ₯Ό μ μνλλ°<br> 
μ¬μ©λλ μ€νλ§ λΆνΈμ λν΄ κ³΅λΆνκ³  AWSλ₯Ό μ΄μ©νμ¬ λ°°ν¬ν΄λ³΄λ©° μΉ μλΉμ€μ λν΄ μ΄ν΄νλ€.

### π νλ‘μ νΈ λͺ©ν
μ±μ κ° μ±ν°λ₯Ό μ λ¦¬νλ©° μΉ μλΉμ€λ₯Ό κ΅¬νν΄λ³΄λ©΄μ μ»μ μ§μμ ν΅ν΄ λλ§μ μΉμλΉμ€λ₯Ό κ΅¬μΆν΄λ³Έλ€.

### π μ±ν° λ³ κ³΅λΆ λ΄μ© μ λ¦¬
#### π CHAPTER 1
μ€νλ§ λΆνΈμ νμν μ€μ 

μ±μμ λμ¨ μ€μ  λ°©λ²μ λ κ°μ§κ° μλ€.

μ²«μ§Έ, build.gradle νμΌμ μ§μ  μμ±νλ λ°©λ²μ μ¬μ©λλ μμ‘΄μ±μ λͺμμ μΌλ‘ μμ±νλ€.

#### π EXAMPLE
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

λμ§Έ, μ€νλ§ μ΄λμλΌμ΄μ (https://start.spring.io)λ₯Ό ν΅ν΄ μ€νλ§ λΆνΈ νλ‘μ νΈλ₯Ό μμ±νλ€.

```

```

#### Chapter 2

#### Chapter 3