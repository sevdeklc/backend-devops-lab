# Spring Boot Nedir? Normal Java'dan Farkı Nedir?

## Problem Neydi?

Java ile web uygulaması geliştirmek geçmişte oldukça zahmetliydi.

Örneğin basit bir REST API geliştirmek istediğimizi düşünelim.

Yapılması gerekenler:

* Servlet Container kurulumu
* Tomcat kurulumu
* XML konfigürasyonları
* Dependency yönetimi
* Bean tanımlamaları
* Uygulamanın deploy edilmesi

Bu süreç hem zaman alıyor hem de geliştirici yükünü artırıyordu.

Bu problemleri çözmek için Spring Framework ortaya çıktı.

Daha sonra Spring kullanımını daha da kolaylaştırmak amacıyla Spring Boot geliştirildi.

---

# Spring Framework Nedir?

Spring Framework, Java uygulamaları geliştirmeyi kolaylaştıran bir framework'tür.

Başlıca özellikleri:

* Dependency Injection (DI): Nesnelerin bağımlılıklarının framework tarafından otomatik olarak sağlanmasıdır.
* Inversion of Control (IoC): Nesnelerin oluşturulması ve yönetimi kontrolünün geliştiriciden alınıp Spring'e verilmesidir.
* AOP (Aspect Oriented Programming): Loglama, güvenlik ve performans takibi gibi ortak işlemlerin merkezi olarak yönetilmesini sağlar.
* Transaction Management: Veritabanı işlemlerinin başarılı veya hatasız şekilde bir bütün olarak yürütülmesini sağlar.
* Security: Kimlik doğrulama (Authentication) ve yetkilendirme (Authorization) mekanizmaları sunar.
* Web Development: REST API ve web uygulamalarının hızlı şekilde geliştirilmesini sağlar.

Ancak Spring Framework tek başına kullanıldığında oldukça fazla konfigürasyon gerektirir.

---

# Spring Boot Nedir?

Spring Boot, Spring Framework üzerine kurulmuş ve geliştirme sürecini hızlandıran bir araçtır.

Amaç:

```text
Daha az konfigürasyon
Daha hızlı geliştirme
Daha kolay deployment
```

sağlamaktır.

---

# Spring Boot Olmasaydı

Basit bir web uygulaması için:

```text
Tomcat Kur
↓
WAR Oluştur
↓
Deploy Et
↓
Konfigürasyon Yap
```

gibi işlemler gerekebilirdi.

---

# Spring Boot ile

Sadece:

```bash
mvn spring-boot:run
```

veya

```bash
java -jar app.jar
```

ile uygulama ayağa kaldırılabilir.

---

# Embedded Server Nedir?

Spring Boot'un en önemli özelliklerinden biri:

```text
Embedded Server
```

kullanmasıdır.

Örneğin:

* Tomcat
* Jetty
* Undertow

uygulamanın içine gömülü gelir.

Bu yüzden ayrıca sunucu kurmamıza gerek kalmaz.

---

# Mimari

Spring Boot:

```text
Application
     ↓
Embedded Tomcat
     ↓
JVM
     ↓
İşletim Sistemi
```

şeklinde çalışır.

---

# Dependency Management

Spring Boot'un sağladığı en büyük avantajlardan biri dependency yönetimidir.

Örneğin:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

eklediğimizde:

* Spring MVC
* Jackson
* Validation
* Embedded Tomcat

gibi birçok kütüphane otomatik olarak gelir.

---

# Starter Kavramı

Spring Boot içerisinde:

```text
Starter
```

adı verilen paketler bulunur.

Örnekler:

```text
spring-boot-starter-web
spring-boot-starter-data-jpa
spring-boot-starter-security
spring-boot-starter-test
```

Starter'lar gerekli bağımlılıkları otomatik olarak getirir.

---

# Spring Boot ile REST API

Basit bir örnek:

```java
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String hello() {
        return "Hello World";
    }
}
```

Uygulama çalıştırıldığında:

```text
GET /hello
```

isteği:

```text
Hello World
```

cevabı döner.

Gerçek projelerde bu yapı sayesinde /users, /products, /orders gibi endpoint'ler geliştirerek frontend uygulamalarına veya mobil uygulamalara veri sağlarız.

---

# Neden Bu Kadar Yaygın?

Çünkü:

* Öğrenmesi kolaydır.
* Hızlı geliştirme sağlar.
* Büyük ekosisteme sahiptir.
* Cloud ve Microservice mimarileriyle uyumludur.
* Docker ve Kubernetes ile çok iyi çalışır.

---

# Docker ile İlişkisi

Önceki .md dosyalarında öğrendiğimiz:

```text
Image
Container
Registry
```

kavramları aslında çoğunlukla Spring Boot uygulamalarını taşımak için kullanılır.

Örneğin:

```text
Spring Boot App
      ↓
Docker Image
      ↓
Container
      ↓
Kubernetes
```

şeklinde bir süreç izlenir.

---

# Avantajları

* Hızlı geliştirme sağlar.
* Embedded server içerir.
* Geniş ekosisteme sahiptir.
* Docker ve Kubernetes ile uyumludur.
* Microservice mimarisine uygundur.

---

# Dezavantajları

* Başlangıç seviyesinde sihirli gibi gelebilir.
* Büyük projelerde öğrenme eğrisi vardır.
* Fazla bağımlılık kullanımı performans maliyeti oluşturabilir.

---

# Mini Özet

* Spring Boot, Spring Framework üzerine kurulmuştur.
* Daha az konfigürasyon gerektirir.
* Embedded Tomcat içerir.
* REST API geliştirmeyi kolaylaştırır.
* Docker ve Kubernetes ile çok iyi çalışır.
* Günümüzde Java backend projelerinin büyük kısmında kullanılmaktadır.
