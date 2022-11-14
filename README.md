# Project Title

SpringBoot learning.

## Getting Started

學習 SpringBoot 微服務架構.

## Prerequisites

開發環境

- JDK v17
- Node.js v16
- Git
- Visual Studio Code or Eclipse

## 環境建置

- 建置 nx 專案
  - npx create-nx-workspace@latest --style=scss --name=nx --appName=frontend --preset=angular
  - npm install -g nx
- 建置 backend springboot 專案
  - npm i @nxrocks/nx-spring-boot -D --legacy-peer-deps
  - nx g @nxrocks/nx-spring-boot:new backend
- 前端加入 tailwindcss
  - npm i tailwindcss -D --legacy-peer-deps
- 啟動
  - 多專案：nx run-many --target=serve --projects=frontend,backend
  - 前端：nx serve frontend （cd apps/frontend/ && ng serve)
  - 後段：nx serve backend（cd apps/backend/ && ./mvnw spring-boot:run)

## 課程大綱

### ch1

建立一支 API

- 增加 HelloWorldController，呼叫顯示'Hello World'

- Run BackendApplication and open http://localhost:8080/ch01

```java
@CrossOrigin
@RestController
public class Ch01Controller {

  @GetMapping("/ch01")
  String hello() {
    return "Hello World";
  }
}
```

### ch2

學習建立各環境設定檔並印出

- 增加 HelloWorldController，呼叫取得各環境的變數

- resources 目錄增加 application-ut.properties、application-uat.properties、application-prod.properties

- application-ut.properties 設定檔增加 env.name 變數

- application.properties 設定 spring.profiles.active 變數來決定環境

- Run BackendApplication and open http://localhost:8080/ch02

```java
@RestController
public class Ch02Controller {

	@Value("${env.name}")
	private String envName;

	@GetMapping("/ch02")
	public String hello() {
		return envName;
	}
}
```

https://snippet-generator.app/
