# CI/CD Nedir? Neden Vardır?

## Problem Neydi?

Bir uygulama geliştirdiğimizi düşünelim.

Örneğin bir Spring Boot projesi geliştiriyoruz.

Yeni bir özellik ekledik ve kodu GitHub'a gönderdik.

Peki sonra ne olacak?

Eskiden süreç genellikle şöyleydi:

1. Geliştirici kodu sunucuya gönderir.
2. Sunucuya SSH ile bağlanır.
3. Projeyi build eder.
4. Testleri çalıştırır.
5. Uygulamayı yeniden başlatır.

Bu süreç:

* Yavaştır.
* İnsan hatasına açıktır.
* Her seferinde aynı işlemler tekrar edilir.

Bu problemi çözmek için CI/CD yaklaşımı ortaya çıkmıştır.

---

# CI/CD Nedir?

CI/CD iki kavramdan oluşur:

```text
CI = Continuous Integration
CD = Continuous Delivery / Continuous Deployment
```

Amaç:

Kodun geliştirilmesinden canlı ortama çıkmasına kadar olan süreci otomatik hale getirmektir.

---

# Continuous Integration (CI) Nedir?

Continuous Integration (Sürekli Entegrasyon), geliştiricilerin yaptıkları değişiklikleri sık sık ana kodla birleştirmesi ve bu değişikliklerin otomatik olarak doğrulanması sürecidir.

Örneğin:

Bir geliştirici GitHub'a kod gönderdiğinde:

```text
Git Push
   ↓
Build
   ↓
Unit Test
   ↓
Sonuç
```

işlemleri otomatik çalışır.

Böylece:

* Kod derleniyor mu?
* Testler geçiyor mu?
* Yeni değişiklik sistemi bozdu mu?

sorularının cevabı hemen alınır.

---

# CI Sürecine Örnek

Bir Spring Boot projesinde:

```text
GitHub'a Push
        ↓
Jenkins
        ↓
mvn clean install
        ↓
JUnit Testleri
        ↓
Başarılı / Başarısız
```

Eğer testlerden biri başarısız olursa:

```text
Pipeline Durur
```

ve uygulama sonraki aşamalara geçmez.

---

# Continuous Delivery (CD) Nedir?

Continuous Delivery, başarılı şekilde doğrulanan uygulamanın dağıtıma hazır hale getirilmesidir.

Örneğin:

```text
Git Push
    ↓
Build
    ↓
Test
    ↓
Docker Image Oluştur
    ↓
Docker Hub'a Gönder
```

Bu noktada uygulama deploy edilmeye hazırdır.

Ancak canlı ortama geçmek için hâlâ bir onay gerekebilir.

---

# Continuous Deployment Nedir?

Continuous Deployment, doğrulanan uygulamanın otomatik olarak canlı ortama gönderilmesidir.

Örneğin:

```text
Git Push
    ↓
Build
    ↓
Test
    ↓
Docker Image
    ↓
Deploy
```

Hiçbir insan müdahalesi olmadan süreç tamamlanır.

---

# Continuous Delivery ve Continuous Deployment Farkı

## Continuous Delivery

```text
Build
 ↓
Test
 ↓
Deploy Hazır
 ↓
İnsan Onayı
 ↓
Canlı Ortam
```

---

## Continuous Deployment

```text
Build
 ↓
Test
 ↓
Canlı Ortam
```

İnsan onayı yoktur.

---

# Pipeline Nedir?

Pipeline, uygulamanın geçtiği otomatik adımların tamamıdır.

Örneğin:

```text
Kod Pushlandı
      ↓
Build
      ↓
Test
      ↓
Docker Build
      ↓
Docker Hub Push
      ↓
Deploy
```

Bu akışın tamamına Pipeline denir.

---

# Jenkins Bu İşin Neresinde?

Jenkins bir CI/CD aracıdır.

Görevi:

* Build çalıştırmak
* Test çalıştırmak
* Docker image oluşturmak
* Registry'e göndermek
* Deploy işlemlerini başlatmak

gibi süreçleri otomatik hale getirmektir.

---

# Avantajları

* İnsan hatalarını azaltır.
* Deployment süresini kısaltır.
* Testleri otomatikleştirir.
* Ekip çalışmasını kolaylaştırır.
* Daha güvenli sürüm geçişleri sağlar.

---

# Dezavantajları

* İlk kurulum maliyeti vardır.
* Pipeline yönetimi öğrenilmelidir.
* Yanlış yapılandırılırsa tüm süreci etkileyebilir.

---

# Mini Özet

* CI, kodun otomatik build ve test edilmesidir.
* CD, uygulamanın dağıtıma hazır hale getirilmesi veya dağıtılmasıdır.
* Pipeline, tüm otomatik adımların akışıdır.
* Jenkins en yaygın CI/CD araçlarından biridir.
* Modern backend ve DevOps süreçlerinin temel parçalarından biridir.
