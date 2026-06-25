# Veritabanı Container İçinde Çalışınca Veriler Nerede Saklanır? Volume Nedir?

## Problem Neydi?

Docker container'ları geçici yapılardır.

Örneğin bir PostgreSQL container çalıştırdığımızı düşünelim.

```bash
docker run postgres
```

İçine veri ekledik:

```text
Users
Products
Orders
```

Daha sonra container'ı sildik:

```bash
docker rm postgres-container
```

Peki veriler ne olacak?

Eğer herhangi bir önlem almadıysak:

```text
Veriler de silinir.
```

Bu büyük bir problemdir.

Çünkü gerçek hayatta veritabanı verilerinin kalıcı olması gerekir.

---

# Container İçindeki Veriler Nerede Saklanır?

Normalde container'ın kendi dosya sistemi vardır.

Örneğin:

```text
Container
    │
    ├── Application Files
    ├── Logs
    └── Database Files
```

Bu dosyalar container'ın yaşam döngüsüne bağlıdır.

Container silinirse:

```text
Dosyalar da silinir.
```

---

# Çözüm: Volume

Docker'ın bu problem için sunduğu çözüm:

```text
Volume
```

kavramıdır.

Volume, container'ın dışında bulunan kalıcı depolama alanıdır.

---

# Volume Nedir?

Volume, verilerin container silinse bile korunmasını sağlayan depolama alanıdır.

Mimari:

```text
Container
     │
     ▼
 Volume
     │
     ▼
 Disk
```

Burada veri:

```text
Container içinde değil,
Host makinede saklanır.
```

---

# Volume Olmadan

```text
PostgreSQL Container
        │
        ▼
Database Files
```

Container silinirse:

```text
Veriler silinir.
```

---

# Volume ile

```text
PostgreSQL Container
         │
         ▼
      Volume
         │
         ▼
       Disk
```

Container silinse bile:

```text
Veriler korunur.
```

---

# Örnek

Volume oluşturmak:

```bash
docker volume create postgres-data
```

Listelemek:

```bash
docker volume ls
```

---

# Container ile Kullanımı

Örnek:

```bash
docker run \
-d \
--name postgres-db \
-v postgres-data:/var/lib/postgresql/data \
postgres
```

Burada:

```text
postgres-data
```

isimli volume,

```text
/var/lib/postgresql/data
```

dizinine bağlanır.

PostgreSQL verilerini artık volume içinde saklar.

---

# Container Silinirse Ne Olur?

Örneğin:

```bash
docker rm postgres-db
```

çalıştırdık.

Sonuç:

```text
Container gider.
```

Ancak:

```text
Volume durur.
```

Veriler kaybolmaz.

Yeni container oluşturduğumuzda aynı volume'u bağlayabiliriz.

---

# Docker Compose ile İlişkisi

```yaml
volumes:
  postgres-data:
```

tanımı aslında Docker volume oluşturur.

Bu sayede:

```text
docker-compose down
docker-compose up
```

yapsak bile veriler korunabilir.

---

# Avantajları

* Veriler kalıcı olur.
* Container silinse bile veri korunur.
* Yedekleme kolaylaşır.
* Veritabanları için idealdir.

---

# Dezavantajları

* Yönetimi öğrenmek gerekir.
* Gereksiz volume'lar disk alanı tüketebilir.

---

# Mini Özet

* Container'lar geçicidir.
* Container içindeki veriler silinebilir.
* Volume kalıcı depolama sağlar.
* Veritabanları için volume kullanmak kritik öneme sahiptir.
* Docker Compose projelerinde volume sıkça kullanılır.
