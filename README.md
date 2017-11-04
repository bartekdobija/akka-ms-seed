# SBT Akka Microservice Project Template

### About

Akka Service Project Template for SBT

#### Use Case

```bash
sbt new bartekdobija/akka-ms-seed.g8
```

### Docker image creation

```bash
sbt docker:publishLocal
```

### Docker run

```bash
docker run -p 8080:8080 <image_id>
```
