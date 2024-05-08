# Docker build
docker build -t hexagonal:last .

# Docker run
docker run -p 8080:8080 hexagonal:last .

# Docker compose
docker compose up