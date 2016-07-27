Gradle
======

Gradle
------

[Gradle.org](gradel.org)

> 앤트의 유연함과 메이븐 규약의 특성을 모두 지원하는 그루비 기반의 빌드 플랫폼

---

### 설치 및 환경설정 

Gradle을 사용하기 위해서 다음 파일을 다운로드 받고 압축을 푼다.

```
$ https://services.gradle.org/distributions/gradle-2.14-bin.zip  
$ unzip gradle-2.14-bin.zip 
```

환경변수를 설정한다.

```
GRADLE_HOME=C:\dev\gradle-2.14
PATH=%GRADLE_HOME%\bin
```

설치 및 환경 설정이 완료되면 다음 명령으로 그래들의 버전을 확인한다.
```
$ gradle --version 
```

---

### Gradle 기본

  * Plugin 

    `build.gradle`
    ```gradle
    apply plugin: 'java'
    ```

    ```
    $ gradle build
    ```

  * Task
    ```
    $ gradle tasks   
    ```

    * compile
    * package
    * install
    * deploy
    * clean

  * Dependency
    * group
    * name
    * version

    ```gradle
    dependencies {
        compile group: 'commons-collections', name: 'commons-collections', version: '3.2'
        testCompile group: 'junit', name: 'junit', version: '4.11'
        testCompile group: "junit:junit:4.11'
    }
    ```

### Gradle 명령어

* 프로젝트 생성 
```
$ gradle init --type java-library
```

* 프로젝트 빌드 
```
$ gradle build 
```

* 빌드 실행 결과 삭제 
```
$ gradle clean 
```

* 프로젝트 테스트 
```
$ gradle test 
```

---

메이븐에서 그래들로 전환
----------------------

그래들에서 제공하는 메이븐 플러그인을 이용해서 메이븐 프로젝트를 그래들로 변환한다.

```
$ gradle init --type pom
```

추가적으로 `build.gradle` 파일에 다음을 내용들을 추가한다.

* 플러그인 추가 

```gradle
apply plugin: 'war'
apply plugin: 'eclipse-wtp'
```

* Encoding 설정 추가

```gradle
compileJava.options.encoding = 'UTF-8'
compileTestJava.options.encoding = 'UTF-8'
```

* Eclipse 설정 추가 
```gradle
eclipse {
    wtp {
        component {
            contextPath = project.name 
        }
        facet {
            facet name: 'jst.web', version: '3.0'
            facet name: 'jst.java', version: '1.8'
        }
    }
}
```

기존의 메이븐 프로젝트에서 생성된 Eclipse 설정 파일들을 모두 삭제한다.
```
$ gradle cleanEclipse
```

다음 명령을 수행하여 Eclipse 프로젝트 설정파일들을 새로 생성한다.
```
$ gradle eclipse
```

