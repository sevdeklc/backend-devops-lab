# Docker Compose Nedir? Neden Kullanılır?

## Problem Neydi?

Tek bir container çalıştırdığımızda;

örneğin:

```bash
docker run nginx
```

Bu oldukça basittir.

Ancak gerçek projelerde genellikle birden fazla servis bulunur.

Örneğin:

```text
Spring Boot API
PostgreSQL
Redis
Kafka
```

Bu durumda her servis için ayrı ayrı:

```bash
docker run ...
docker run ...
docker run ...
docker run ...
```

komutları çalıştırmak gerekir.

Ayrıca:

* Port ayarları
* Environment değişkenleri
* Volume tanımları
* Network ayarları

tek tek yönetilmelidir.

Bu süreç karmaşık hale gelir.

---

# Docker Compose Nedir?

Docker Compose, birden fazla container'ı tek bir dosya ile yönetmemizi sağlayan araçtır.

Amaç:

```text
Birden fazla servisi
tek komutla
ayağa kaldırmak
```

---

# Docker Compose Olmasaydı

Örneğin:

```text
Spring Boot
PostgreSQL
```

çalıştıracağız.

Şunları yapmamız gerekir:

```bash
docker network create app-network

docker volume create postgres-data

docker run postgres ...

docker run spring-app ...
```

Birden fazla komut gerekir.

---

# Docker Compose ile

Sadece:

```bash
docker-compose up
```

veya

```bash
docker compose up
```

çalıştırılır.

Tüm servisler ayağa kalkar.

---

# Nasıl Çalışır?

Docker Compose yapılandırmaları:

```text
docker-compose.yml
```

dosyasında tutulur.

Örnek:

```yaml
services:

  app:
    image: my-spring-app

  postgres:
    image: postgres
```

Burada:

* app container'ı
* postgres container'ı

aynı anda yönetilir.

---

# Örnek Mimari

```text
┌──────────────────┐
│ Spring Boot API  │
└────────┬─────────┘
         │
         ▼
┌──────────────────┐
│ PostgreSQL       │
└──────────────────┘
```

Bu iki servis tek compose dosyasında tanımlanabilir.

---

# Basit Bir Compose Dosyası

```yaml
version: '3.8'

services:

  postgres:
    image: postgres
    container_name: postgres-db

  app:
    image: my-spring-app
    container_name: spring-app
```

Bu dosya:

* PostgreSQL container'ını
* Spring Boot container'ını

birlikte yönetir.

---

# Service Nedir?

Compose içerisindeki her container:

```text
Service
```

olarak tanımlanır.

Örneğin:

```yaml
services:

  postgres:
    ...

  app:
    ...
```

Burada:

```text
postgres = Service
app = Service
```

olur.

---

# Network Yönetimi

Docker Compose otomatik olarak network oluşturur.

Örneğin:

```yaml
services:

  app:
    ...

  postgres:
    ...
```

Bu durumda:

```text
app
 ↓
postgres
```

birbirini servis adıyla bulabilir.

Örneğin:

```properties
spring.datasource.url=
jdbc:postgresql://postgres:5432/mydb
```

şeklinde bağlantı kurulabilir.

Buradaki:

```text
postgres
```

container adı değil,

service adıdır.

---

# Volume Yönetimi

Compose volume yönetimini de kolaylaştırır.

Örnek:

```yaml
volumes:
  postgres-data:
```

Bu sayede PostgreSQL verileri kalıcı hale gelir.

---

# Temel Komutlar

## Servisleri Başlatmak

```bash
docker compose up
```

---

## Arka Planda Başlatmak

```bash
docker compose up -d
```

---

## Servisleri Durdurmak

```bash
docker compose stop
```

---

## Servisleri Kapatmak

```bash
docker compose down
```

---

## Logları Görmek

```bash
docker compose logs
```

---

# Docker Compose ve Kubernetes Farkı

Docker Compose:

* Lokal geliştirme için idealdir.
* Küçük projelerde kullanılır.

Kubernetes:

* Büyük sistemler için geliştirilmiştir.
* Otomatik ölçekleme sağlar.
* Yüksek erişilebilirlik sunar.

---

# Avantajları

* Birden fazla container'ı yönetir.
* Network oluşturur.
* Volume oluşturur.
* Tek komutla sistemi ayağa kaldırır.
* Lokal geliştirme süreçlerini kolaylaştırır.

---

# Dezavantajları

* Büyük ölçekli sistemler için uygun değildir.
* Otomatik ölçekleme sunmaz.
* Kubernetes kadar gelişmiş değildir.

---

# Mini Özet

* Docker Compose birden fazla container'ı yönetir.
* Yapılandırmalar docker-compose.yml dosyasında tutulur.
* Network ve volume yönetimini kolaylaştırır.
* Lokal geliştirme ortamlarında çok yaygın kullanılır.
