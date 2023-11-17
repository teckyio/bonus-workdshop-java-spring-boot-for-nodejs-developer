Bonus Workshop - Getting Started to Build Web Server with Java Spring Boot for Node.js Developer

Youtube: https://youtu.be/Z0K3uEbf64M

Github: https://github.com/teckyio/bonus-workdshop-java-spring-boot-for-nodejs-developer

## Key Steps

- design database
  - design erd.txt
  - generate and run migration
  - generate DAO (Entity, Repository)
- define API
  - design api.txt
  - generate DTO, Controller, Service
  - define fields in DTO
- implement API (controller, service)
- try in API client (Insomnia)

## Cli Tools

- [quick-erd](https://www.npmjs.com/package/quick-erd)
  - `erd-to-spring pg < erd.txt`
  - `auto-migrate pg < erd.txt`
- [gen-spring](https://www.npmjs.com/package/gen-spring)
  - `gen-api < api.txt`
