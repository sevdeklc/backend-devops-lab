# Docker Image ve Container Arasındaki Fark Nedir?

## Problem Neydi?

Docker kullanmaya başlayanların en sık karıştırdığı kavramlardan biri:

```text
Image
ve
Container
```

arasındaki farktır.

Örneğin:

```bash
docker run nginx
```

komutunu çalıştırdığımızda:

* Docker image mı oluşturuyor?
* Container mı oluşturuyor?
* İkisi aynı şey mi?

soruları ortaya çıkar.

Bu kavramları doğru anlamak Docker'ın temelini oluşturur.

---

# Docker Image Nedir?

Docker Image, bir container oluşturmak için kullanılan şablondur.

İçerisinde:

* Uygulama kodu
* Runtime (Java, Node.js vb.)
* Kütüphaneler
* Konfigürasyonlar

bulunur.

Image değiştirilemez (immutable) bir yapıdır.

Bir image tek başına çalışmaz.

Container oluşturmak için kullanılır.

---

# Günlük Hayattan Benzetme

Bir kurabiye kalıbı düşün.

```text
Kurabiye Kalıbı
       ↓
Kurabiye
```

Burada:

```text
Kalıp = Image
Kurabiye = Container
```

olur.

Kalıptan istediğin kadar kurabiye çıkarabilirsin.

Aynı şekilde bir image'dan istediğin kadar container oluşturabilirsin.

---

# Container Nedir?

Container, image'ın çalışan örneğidir.

Örneğin:

```bash
docker run nginx
```

komutunu çalıştırdığında:

1. nginx image'ı bulunur.
2. Image'dan bir container oluşturulur.
3. Container çalıştırılır.

Yani:

```text
Image
   ↓
Container
```

ilişkisi vardır.

---

# Terminalden Yaptığım Örnek

Bugün şu komutu çalıştırdım:

```bash
docker run hello-world
```

Docker:

```text
hello-world image'ını buldu
        ↓
container oluşturdu
        ↓
çalıştırdı
        ↓
mesaj yazdı
        ↓
kapattı
```

Bu yüzden:

```bash
docker ps
```

çıktısında görünmedi.

Ancak:

```bash
docker ps -a
```

ile görülebildi.

Çünkü container çalışıp işini bitirmişti.

---

# Nginx Örneği

Şu komutu çalıştırdım:

```bash
docker run -d --name my-nginx -p 8080:80 nginx
```

Burada:

```text
Image
  ↓
nginx
```

Docker Hub'dan indirildi.

Sonra:

```text
Container
  ↓
my-nginx
```

oluşturuldu.

Container çalışmaya devam ettiği için:

```bash
docker ps
```

çıktısında görünüyordu.

---

# Bir Image'dan Birden Fazla Container

Örneğin:

```bash
docker run --name web1 nginx
docker run --name web2 nginx
docker run --name web3 nginx
```

Bu durumda:

```text
nginx image
     ↓
 ┌───┼───┐
 │   │   │
web1 web2 web3
```

oluşur.

Tek image'dan birden fazla container üretilebilir.

---

# Image Nasıl Görüntülenir?

Tüm image'ları listelemek için:

```bash
docker images
```

Örnek çıktı:

```text
REPOSITORY   TAG
nginx        latest
hello-world  latest
```

Bu liste bilgisayardaki image'ları gösterir.

---

# Container Nasıl Görüntülenir?

Çalışan container'lar:

```bash
docker ps
```

Tüm container'lar:

```bash
docker ps -a
```

ile görüntülenir.

---

# Container Silinirse Ne Olur?

Örneğin:

```bash
docker rm my-nginx
```

çalıştırırsak:

```text
Container silinir.
```

Ancak:

```text
Image silinmez.
```

Çünkü image ayrı bir yapıdır.

Bu yüzden:

```bash
docker images
```

çıktısında nginx image'ı hala görünür.

---

# Image Silinirse Ne Olur?

Örneğin:

```bash
docker rmi nginx
```

komutu image'ı siler.

Ancak image'ı kullanan container varsa Docker buna izin vermez.

Önce ilgili container'ların silinmesi gerekir.

---

# Avantajları

Image:

* Tekrar kullanılabilir.
* Versiyonlanabilir.
* Paylaşılabilir.

Container:

* Hızlı başlar.
* İzole çalışır.
* Kolay yönetilir.

---

# Mini Özet

* Image bir şablondur.
* Container image'ın çalışan halidir.
* Bir image'dan birden fazla container oluşturulabilir.
* Container silinince image silinmez.
* Kubernetes ve Docker dünyasının temel mantığı image → container ilişkisidir.
