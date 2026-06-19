# Kubernetes Nedir? Docker Compose Varken Neden Kubernetes'e İhtiyaç Duyuldu?

## Problem Neydi?

Şimdiye kadar öğrendiğimiz yapıyı düşünelim:

```text
Spring Boot
     ↓
Docker Image
     ↓
Container
     ↓
Docker Compose
```

Docker Compose ile:

```bash
docker compose up -d
```

komutu sayesinde:

* Spring Boot
* PostgreSQL
* Redis

gibi servisleri kolayca ayağa kaldırabiliyoruz.

Peki o zaman neden Kubernetes diye ayrı bir teknoloji ortaya çıktı?

Çünkü Docker Compose küçük ve orta ölçekli sistemler için oldukça başarılı olsa da büyük sistemlerde yetersiz kalır.

---

# Docker Compose'un Sınırları

Örneğin bir e-ticaret sistemi düşünelim.

Servisler:

```text
User Service
Order Service
Product Service
Payment Service
Notification Service
```

Her servisten:

```text
10 adet container
```

çalıştırmak istiyoruz.

Toplam:

```text
50+ container
```

oluşuyor.

Bu noktada Docker Compose yönetimi zorlaşır.

---

# Örnek Problem 1: Container Çökerse

Örneğin:

```text
Order Service
```

container'ı çöktü.

Docker Compose:

```text
Container neden çöktü?
Yeni container açmalı mıyım?
```

gibi kararları vermez.

Çoğu durumda manuel müdahale gerekir.

---

# Örnek Problem 2: Trafik Arttı

Örneğin:

```text
100 kullanıcı
```

yerine:

```text
10.000 kullanıcı
```

geldi.

Yeni container açmak gerekir.

Docker Compose:

```text
Order Service
↓
1 Container
```

yapısını otomatik olarak:

```text
Order Service
↓
5 Container
```

haline getiremez.

---

# Örnek Problem 3: Birden Fazla Sunucu

Örneğin:

```text
Sunucu 1
Sunucu 2
Sunucu 3
```

olsun.

Docker Compose tek bir makine üzerinde çalışmak için tasarlanmıştır.

Birden fazla sunucuyu merkezi olarak yönetemez.

---

# Kubernetes Nedir?

Kubernetes (K8s), container tabanlı uygulamaları büyük ölçekte yönetmek için geliştirilmiş bir orkestrasyon platformudur.

Amaç:

```text
Container'ları
otomatik yönetmek
```

---

# Orkestrasyon Nedir?

Orkestrasyon:

```text
Container oluşturma
Container silme
Container yeniden başlatma
Yük dağıtımı
Ölçekleme
```

işlemlerinin otomatik yapılmasıdır.

Kubernetes'in temel görevi budur.

---

# Kubernetes Ne İşe Yarar?

Kubernetes:

* Container çalıştırır
* Container yeniden başlatır
* Trafiği dağıtır
* Ölçekleme yapar
* Güncelleme yönetir
* Sunucular arasında dağıtım yapar

---

# Kubernetes Nasıl Çalışır?

Basitleştirilmiş mimari:

```text
Kubernetes Cluster
       │
 ┌─────┼─────┐
 │     │     │
Node1 Node2 Node3
```

Node:

```text
Container çalıştıran makine
```

demektir.

---

# Pod Nedir?

Kubernetes'in en küçük çalışma birimi:

```text
Pod
```

olarak adlandırılır.

Çoğu durumda:

```text
1 Pod
↓
1 Container
```

ilişkisi vardır.

---

# Deployment Nedir?

Deployment:

```text
Kaç pod çalışacak?
Hangi image kullanılacak?
```

sorularının cevabını veren Kubernetes nesnesidir.

Örnek:

```text
Order Service
↓
3 Pod
```

---

# Service Nedir?

Pod'ların IP adresleri değişebilir.

Bu yüzden Kubernetes:

```text
Service
```

isimli bir katman sunar.

Service sayesinde uygulamalar sabit bir adres üzerinden erişilebilir hale gelir.

---

# Otomatik Ölçekleme

Örneğin:

```text
Order Service
↓
2 Pod
```

çalışıyor.

Trafik arttığında:

```text
Order Service
↓
5 Pod
```

olabilir.

Bu işleme:

```text
Scaling
```

denir.

---

# Self-Healing

Örneğin:

```text
Pod çöktü
```

Kubernetes bunu algılar.

Otomatik olarak yeni pod oluşturur.

Bu özelliğe:

```text
Self-Healing
```

denir.

---

# Jenkins ile İlişkisi

İleride kuracağımız yapı:

```text
GitHub
   ↓
Jenkins
   ↓
Docker Build
   ↓
Docker Hub
   ↓
Kubernetes
```

şeklinde olacak.

Jenkins image oluşturur.

Kubernetes bu image'ı çalıştırır.

---

# Docker Compose ve Kubernetes Karşılaştırması

| Özellik              | Docker Compose | Kubernetes |
| -------------------- | -------------- | ---------- |
| Öğrenme Kolaylığı    | Kolay          | Zor        |
| Kurulum              | Basit          | Karmaşık   |
| Çoklu Sunucu Desteği | ❌              | ✅          |
| Otomatik Ölçekleme   | ❌              | ✅          |
| Self-Healing         | ❌              | ✅          |
| Production Kullanımı | Sınırlı        | Çok Yaygın |
| Büyük Sistemler      | ❌              | ✅          |

---

# Avantajları

* Otomatik ölçekleme sağlar.
* Self-healing özelliği sunar.
* Büyük sistemleri yönetebilir.
* Çoklu sunucu desteği sağlar.
* Production ortamları için idealdir.

---

# Dezavantajları

* Öğrenmesi zordur.
* Kurulumu karmaşıktır.
* Küçük projeler için gereksiz olabilir.

---

# Mini Özet

* Kubernetes bir container orkestrasyon platformudur.
* Docker Compose'un ölçeklenemediği noktalarda devreye girer.
* Pod, Deployment ve Service temel kavramlardır.
* Otomatik ölçekleme ve self-healing sağlar.
* Modern production sistemlerinde yaygın olarak kullanılır.
