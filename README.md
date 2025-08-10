# poem_app

# 📜 Poem App

A simple Spring Boot application with Nginx reverse proxy for managing and viewing poems.

---

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
