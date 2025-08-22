# Microservices Project

Це приклад мікросервісного проєкту на Java + Spring Boot.  
Проєкт складається з двох сервісів: **auth-api** і **data-api**, та бази даних PostgreSQL.

---

## Структура проекту

- `auth-api/` – сервіс авторизації, який зберігає результати обробки тексту.
- `data-api/` – сервіс для трансформації тексту.
- `docker-compose.yml` – підйом всіх сервісів і бази даних у Docker.

---

## Налаштування `.env`

Для запуску потрібно створити і заповнити три файли `.env`:

- `.env`
- `auth-api/.env`
- `data-api/.env`

За зразком використовуйте `env.sample`.

---

## Білд

Кожен сервіс збирається окремо:

# У корені кожного сервісу
./mvnw clean package

## Запуск проекту

Переконайтесь, що Docker встановлений і працює.

У корені проекту запустіть Docker Compose:

docker-compose up --build


Це підніме три контейнери:

PostgreSQL

auth-api

data-api

## Тестування API

Auth API доступний на http://localhost:8081.

Data API доступний на http://localhost:8082.

Для запитів використовуйте Postman або curl, передаючи X-Internal-Token у заголовку.