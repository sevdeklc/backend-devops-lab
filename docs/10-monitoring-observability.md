# Monitoring ve Observability Nedir? Prometheus ve Grafana Ne İşe Yarar?

## Problem Neydi?

Bir Spring Boot uygulaması geliştirdik.

Docker ile çalıştırdık.

Jenkins ile deploy ettik.

Kubernetes üzerinde yayına aldık.

Peki şimdi ne olacak?

Uygulama gerçekten çalışıyor mu?

Örneğin:

* CPU kullanımı %95 olmuş olabilir.
* Bellek (RAM) tükeniyor olabilir.
* API cevap süreleri artmış olabilir.
* Veritabanı bağlantıları tükenmiş olabilir.
* Bazı endpoint'ler hata veriyor olabilir.

Eğer bunları takip etmezsek problemi ancak kullanıcılar şikayet ettiğinde fark ederiz.

Bu yüzden Monitoring ve Observability kavramları ortaya çıkmıştır.

---

# Monitoring Nedir?

Monitoring, sistemin durumunu sürekli olarak takip etme işlemidir.

Örneğin:

* CPU kullanımı
* RAM kullanımı
* Disk kullanımı
* İstek sayısı
* Hata sayısı

gibi metrikler izlenir.

Amaç:

```text
Sistemde problem oluşmadan
problemi fark etmek
```

---

# Observability Nedir?

Observability, sistemin iç durumunu dışarıdan anlayabilme yeteneğidir.

Monitoring:

```text
Ne oldu?
```

sorusuna cevap verir.

Observability ise:

```text
Neden oldu?
```

sorusuna cevap verir.

---

# Monitoring Neden Önemlidir?

Örneğin:

```text
CPU Kullanımı = %98
```

oldu.

Bu durumda:

```text
Uygulama yavaşlayabilir.
```

Monitoring sayesinde bunu kullanıcılar şikayet etmeden önce görebiliriz.

---

# Temel Monitoring Verileri (Metrics)

En yaygın metrikler:

```text
CPU Kullanımı
RAM Kullanımı
Disk Kullanımı
Network Trafiği
Request Sayısı
Error Sayısı
Response Time
```

---

# Log Nedir?

Uygulamanın ürettiği kayıtlar:

```text
INFO
WARN
ERROR
```

seviyelerinde tutulur.

Örnek:

```text
User created successfully

Database connection failed

Order saved
```

Loglar problemlerin nedenini anlamada kullanılır.

---

# Metric, Log ve Trace

Observability genellikle üç temel bileşenden oluşur.

## Metrics

Sayısal veriler.

Örnek:

```text
CPU %40
RAM 2 GB
Response Time 120 ms
```

---

## Logs

Olay kayıtları.

Örnek:

```text
User login success

Database timeout
```

---

## Traces

Bir isteğin sistem içerisindeki yolculuğunu gösterir.

Örnek:

```text
API
 ↓
User Service
 ↓
Order Service
 ↓
Database
```

---

# Prometheus Nedir?

Prometheus açık kaynaklı bir monitoring aracıdır.

Görevi:

```text
Metrikleri toplamak
```

tır.

Örneğin:

* CPU
* RAM
* HTTP Request Sayısı
* Response Time

gibi bilgileri toplar.

---

# Prometheus Nasıl Çalışır?

Prometheus belirli aralıklarla uygulamaya gider.

Örneğin:

```text
Spring Boot
      ↓
/actuator/prometheus
```

endpoint'ini okur.

Metrikleri toplar ve saklar.

---

# Grafana Nedir?

Grafana bir veri görselleştirme aracıdır.

Görevi:

```text
Verileri grafik haline getirmek
```

tir.

Prometheus veriyi toplar.

Grafana veriyi gösterir.

---

# Prometheus ve Grafana Birlikte Nasıl Çalışır?

```text
Spring Boot
      ↓
Prometheus
      ↓
Grafana
      ↓
Dashboard
```

---

# Dashboard Nedir?

Grafana'da oluşturulan ekranlardır.

Örneğin:

```text
CPU Kullanımı
RAM Kullanımı
Request Sayısı
Error Rate
Response Time
```

aynı ekranda görüntülenebilir.

---

# Spring Boot ile Kullanımı

Spring Boot uygulamalarında genellikle:

```xml
spring-boot-starter-actuator
```

bağımlılığı kullanılır.

Bu sayede:

```text
/actuator/health

/actuator/metrics

/actuator/prometheus
```

gibi endpoint'ler açılır.

Prometheus bu endpoint'lerden veri toplar.

---

# Kubernetes ile İlişkisi

Production ortamında genellikle:

```text
Kubernetes
     ↓
Spring Boot
     ↓
Prometheus
     ↓
Grafana
```

mimarisi kullanılır.

Bu sayede tüm pod'lar izlenebilir.

---

# Avantajları

* Problemleri erken fark etmeyi sağlar.
* Sistem performansını takip etmeyi sağlar.
* Hata analizini kolaylaştırır.
* Production ortamlarının vazgeçilmezidir.

---

# Dezavantajları

* Ek kurulum ve bakım gerektirir.
* Çok fazla veri üretilebilir.
* Yanlış yapılandırılırsa maliyet oluşturabilir.

---

# Mini Özet

* Monitoring sistemin durumunu takip etmektir.
* Observability sistemin neden o durumda olduğunu anlamaktır.
* Prometheus metrik toplar.
* Grafana metrikleri görselleştirir.
* Production ortamlarında birlikte kullanılırlar.
* Modern DevOps süreçlerinin temel bileşenleridir.
