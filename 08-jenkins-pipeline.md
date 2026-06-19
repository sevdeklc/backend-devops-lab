# Jenkins Nedir? Pipeline Nedir?

## Problem Neydi?

Bir Spring Boot uygulaması geliştirdiğimizi düşünelim.

Yeni bir özellik ekledik ve kodu GitHub'a gönderdik.

```bash
git push origin main/master
```

Peki sonra ne olacak?

Bir kişinin:

* Sunucuya bağlanması
* Kodu çekmesi
* Build etmesi
* Testleri çalıştırması
* Docker image oluşturması
* Docker Hub'a göndermesi

gerekebilir.

Bu süreç:

* Zaman kaybettirir.
* İnsan hatasına açıktır.
* Her seferinde tekrar edilir.

Bu yüzden bu işlemleri otomatik yapan araçlara ihtiyaç duyulur.

---

# Jenkins Nedir?

Jenkins, açık kaynaklı bir CI/CD aracıdır.

Görevi:

```text
Kod değiştiğinde
otomatik işlemler yapmak
```

tır.

Örneğin:

```text
GitHub
   ↓
Jenkins
   ↓
Build
   ↓
Test
   ↓
Docker Build
   ↓
Deploy
```

akışını yönetebilir.

---

# Jenkins Ne İşe Yarar?

Jenkins;

* Kod çekebilir
* Build çalıştırabilir
* Test çalıştırabilir
* Docker image oluşturabilir
* Docker Hub'a gönderebilir
* Kubernetes deploy işlemi başlatabilir

---

# Pipeline Nedir?

Pipeline, uygulamanın geçtiği otomatik adımların tamamıdır.

Örneğin:

```text
Git Push
    ↓
Build
    ↓
Test
    ↓
Docker Build
    ↓
Docker Push
    ↓
Deploy
```

Bu akışın tamamına:

```text
Pipeline
```

denir.

---

# Bizim Final Projedeki Pipeline

İleride kuracağımız yapı:

```text
GitHub
   ↓
Jenkins
   ↓
Maven Build
   ↓
JUnit Tests
   ↓
Docker Build
   ↓
Docker Hub Push
   ↓
Kubernetes Deploy
```

şeklinde olacak.

---

# Jenkins Pipeline Türleri

## Freestyle Job

Eski yöntemdir.

Adımlar arayüz üzerinden tanımlanır.

Örnek:

```text
Build
Test
Deploy
```

işlemleri tek tek eklenir.

---

## Pipeline

Modern yöntemdir.

Tüm süreç kod olarak yazılır.

Örneğin:

```text
Jenkinsfile
```

isimli dosyada tutulur.

Günümüzde en yaygın kullanılan yöntem budur.

---

# Jenkinsfile Nedir?

Jenkins pipeline'ını tanımlayan dosyadır.

Örnek:

```groovy
pipeline {

    agent any

    stages {

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

    }
}
```

Bu dosya Jenkins'e:

```text
Önce build yap
Sonra test çalıştır
```

talimatı verir.

---

# Stage Nedir?

Pipeline içerisindeki her adım:

```text
Stage
```

olarak adlandırılır.

Örnek:

```text
Build Stage
Test Stage
Docker Stage
Deploy Stage
```

---

# Jenkins Nasıl Çalışır?

Tipik akış:

```text
Developer
     ↓
Git Push
     ↓
GitHub
     ↓
Webhook
     ↓
Jenkins
     ↓
Pipeline
```

GitHub'daki değişiklik Jenkins'i tetikler.

Jenkins gerekli işlemleri başlatır.

---

# Docker ile İlişkisi

Örneğin:

```text
Spring Boot App
```

geliştirdik.

Jenkins:

```text
Build
   ↓
Docker Image
   ↓
Docker Hub
```

işlemlerini otomatik yapabilir.

---

# Kubernetes ile İlişkisi

Jenkins:

```text
Docker Hub
      ↓
Kubernetes Deploy
```

işlemini de başlatabilir.

Böylece kodun canlı ortama çıkması tamamen otomatik hale gelir.

---

# Avantajları

* CI/CD süreçlerini otomatikleştirir.
* İnsan hatalarını azaltır.
* Testleri otomatik çalıştırır.
* Deployment sürecini hızlandırır.
* Çok sayıda eklenti desteği vardır.

---

# Dezavantajları

* İlk kurulumu zaman alabilir.
* Yönetimi öğrenmek gerekir.
* Modern alternatiflere göre bakım ihtiyacı daha fazladır.

---

# Mini Özet

* Jenkins bir CI/CD aracıdır.
* Pipeline, otomatik iş akışıdır.
* Jenkinsfile pipeline'ın kod halidir.
* Stage, pipeline içindeki adımlardır.
* Jenkins build, test, Docker ve deployment süreçlerini otomatikleştirebilir.
