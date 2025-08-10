# poem_app

# 📜 Poem App

A simple Spring Boot application with Nginx reverse proxy for managing and viewing poems.

---

# 📋 Requirements for Poem App

This document lists the prerequisites and dependencies needed to run the **Poem App** locally or on a server.

---

## 1️⃣ System Requirements
- **OS**: Ubuntu 20.04+ (tested on Ubuntu 24.04)
- **CPU**: Dual-core or better
- **RAM**: 2 GB minimum (4 GB recommended)
- **Disk Space**: 500 MB free

---

## 2️⃣ Software Requirements
- **Java 17+**
  ```bash
  sudo apt install openjdk-17-jdk -y
  ```
Maven

sudo apt install maven -y
Nginx


sudo apt install nginx -y
MySQL / MariaDB


sudo apt install mariadb-server -y
Git (to clone the repository)


sudo apt install git -y
3️⃣ Database Setup
Create a database:

mysql -u root -p
CREATE DATABASE poemdb;
Update database credentials in:

src/main/resources/application.properties

## 1️⃣ Start the Application

Run Spring Boot:
```bash
mvn spring-boot:run
```
Open your browser and go to:
    http://localhost/8081
    
Enable HTTPS with Let's Encrypt

  sudo apt install certbot python3-certbot-nginx -y
  sudo certbot --nginx -d your-domain.com
Restart Spring Boot (manual run):


mvn spring-boot:run
Restart Nginx:

sudo systemctl restart nginx
View Nginx logs:

sudo tail -f /var/log/nginx/error.log

Get all poems:

curl http://localhost/poems
Health check:

curl http://localhost/health
Add a new poem (example):

curl -X POST -H "Content-Type: application/json" \
-d '{"title":"My Poem","content":"Roses are red, violets are blue..."}' \
http://localhost/poems


Build JAR

mvn clean package
java -jar target/poem-application-0.0.1-SNAPSHOT.jar
