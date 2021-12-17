# 상품 카테고리 구현

---
### SPEC
Java, SpringBoot, Gradle, Sprint Data JPA

---
### 1. JDK 1.8 필요
### 2. QueryDSL 클래스 파일 생성
* Gradle reload 후 
  Tasks > other > compileQuerydsl 생성확인
* compileQuerydsl 더블클릭 하여 실행
* 프로젝트 > build > generated > querydsl > Q클래스파일명 (파일 생성 확인)

### 3. Gradle > Jar 파일 빌드
### 4. Jar 파일 생성 방법
    * Tasks > build > bootJar
    * 프로젝트 > build > libs > 생성된 jar 파일 위치
### 5. Jar 실행
* java -jar category-0.0.1-SNAPSHOT.jar
> 빌드가 안될경우 대비해 프로젝트 내 jar 디렉터리에 빌드한 jar 파일 첨부
---
### 호출 API
#### GET
* /category/list 
  * parameter : categoryId
#### POST
* /category/save
* /category/edit/{id}
  * id : categoryId
#### DELETE
* /category/delete/{id}
  * id : categoryId
---

