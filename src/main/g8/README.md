# Akka Actor Microservice

### Docker image creation

```bash
sbt docker:publishLocal
```

### Docker run

```bash
docker run -p 8080:8080 <image_id>
```
or
```bash
docker-compose up
```

