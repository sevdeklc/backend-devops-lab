# Registry Nedir? Docker Hub Neden Vardır?

## Problem Neydi?

Bir Spring Boot uygulaması geliştirdiğimizi düşünelim.

Bu uygulama için bir Docker image oluşturduk:

```text
my-spring-app:1.0
```

Image artık bilgisayarımızda mevcut.

Peki:

* Takım arkadaşlarımız bu image'ı nasıl kullanacak?
* Test ortamındaki sunucu bu image'a nasıl ulaşacak?
* Production ortamı bu image'ı nereden indirecek?

Image'ları paylaşabileceğimiz merkezi bir depoya ihtiyaç vardır.

Bu ihtiyacı Registry çözer.

---

# Registry Nedir?

Registry, Docker image'larının saklandığı ve dağıtıldığı merkezi depodur.

Kısaca:

```text
GitHub kodları saklar.

Registry image'ları saklar.
```

şeklinde düşünebiliriz.

---

# Docker Hub Nedir?

Docker Hub, Docker'ın resmi registry hizmetidir.

En yaygın kullanılan registry'dir.

Adres:

```text
https://hub.docker.com
```

Burada milyonlarca hazır image bulunur.

Örneğin:

* nginx
* redis
* mysql
* postgres
* mongo
* rabbitmq

gibi image'lar Docker Hub üzerinden dağıtılır.

---

# Docker Hub Olmasaydı Ne Olurdu?

Örneğin bir nginx container çalıştırdık:

```bash
docker run nginx
```

Docker aslında şunu yaptı:

```text
Docker Hub'a git
      ↓
nginx image'ını bul
      ↓
indir
      ↓
container oluştur
```

Eğer Docker Hub olmasaydı Docker nginx image'ını bulamazdı.

---

# Registry Nasıl Çalışır?

Örneğin bir image oluşturduk:

```text
my-spring-app:1.0
```

Akış:

```text
Developer
     ↓
Docker Build
     ↓
Docker Image
     ↓
Registry
     ↓
Sunucu
```

şeklindedir.

---

# Push ve Pull Nedir?

## Push

Image'ı registry'e göndermek.

Örneğin:

```bash
docker push myrepo/my-spring-app:1.0
```

---

## Pull

Image'ı registry'den indirmek.

Örneğin:

```bash
docker pull nginx
```

veya

```bash
docker pull myrepo/my-spring-app:1.0
```

---

# Public ve Private Registry

## Public Registry

Herkes erişebilir.

Örnek:

```text
Docker Hub Public Repository
```

---

## Private Registry

Sadece yetkili kullanıcılar erişebilir.

Örnek:

```text
Şirket içi image deposu
```

---

# Docker Hub Dışında Registry Var Mı?

Evet.

Yaygın örnekler:

* GitHub Container Registry (GHCR)
* Amazon ECR
* Google Artifact Registry
* Azure Container Registry

---

# CI/CD Sürecindeki Yeri

Tipik akış:

```text
Git Push
    ↓
Jenkins
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

Burada Docker Hub, Jenkins ile Kubernetes arasında köprü görevi görür.

---

# Avantajları

* Image paylaşımını kolaylaştırır.
* Versiyon yönetimi sağlar.
* Merkezi depolama sunar.
* CI/CD süreçlerini destekler.
* Takım çalışmasını kolaylaştırır.

---

# Mini Özet

* Registry, Docker image'larının saklandığı depodur.
* Docker Hub en yaygın registry'dir.
* Push image gönderir.
* Pull image indirir.
* CI/CD süreçlerinde image paylaşımının temel bileşenidir.
