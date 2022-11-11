# 20221117

npx create-nx-workspace@latest --style=scss --name=nx --appName=frontend --preset=angular

? Choose your style
Package-based: Craft your own setup. Nx makes it fast, but lets you run things your way.

# Integrated: Get a pre-configured setup. Nx configures your favorite frameworks and lets you focus on shipping features.

# angular [a workspace with a single Angular application]

✔ Choose your style · integrated
✔ What to create in the new workspace · angular
✔ Repository name › nx
✔ Application name › backend
✔ Default stylesheet format · scss

npm install -g nx

nx g @nrwl/angular:application frontend

npm i @nxrocks/nx-spring-boot -D --legacy-peer-deps
nx g @nxrocks/nx-spring-boot:new backend

✔ What kind of project are you generating? · application
✔ Which build system would you like to use? · maven-project
✔ Which packaging would you like to use? · jar
✔ Which version of Java would you like to use? · 17
✔ Which language would you like to use? · java
✔ What groupId would you like to use? › com.example

npm i tailwindcss -D --legacy-peer-deps

https://snippet-generator.app/

nx run-many --target=serve --projects=frontend,backend
