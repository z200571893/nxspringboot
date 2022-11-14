# Project Title

SpringBoot learning.

## Getting Started

學習 SpringBoot 微服務架構.

### Prerequisites

開發環境

- JDK v17
- Node.js v16
- Git
- Visual Studio Code or Eclipse

### 環境建置

- 建置 nx 專案
  - npx create-nx-workspace@latest --style=scss --name=nx --appName=frontend --preset=angular
  - npm install -g nx
- 建置 backend springboot 專案
  - npm i @nxrocks/nx-spring-boot -D --legacy-peer-deps
  - nx g @nxrocks/nx-spring-boot:new backend
- 加入 tailwindcss
  - npm i tailwindcss -D --legacy-peer-deps
- 啟動
  - 多專案：nx run-many --target=serve --projects=frontend,backend
  - 前端：nx serve frontend （cd apps/frontend/ && ng serve)
  - 後段：nx serve backend（cd apps/backend/ && ./mvnw spring-boot:run)

### 課程大綱

https://snippet-generator.app/
