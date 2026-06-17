# Container Nedir? Sanal Makineden (VM) Farkı Nedir?

## Problem Neydi?

Yazılım geliştirirken en sık karşılaşılan problemlerden biri:

> "Benim bilgisayarımda çalışıyor ama sunucuda çalışmıyor."

Örneğin, Java sürümü farklıdır. | İşletim sistemi farklıdır. | Bir kütüphanenin sürümü farklıdır. | Ortam değişkenleri eksiktir.

Bu durum uygulamanın farklı ortamlarda farklı davranmasına neden olur.

Bu problemi çözmek için önce **Virtual Machine (VM)** teknolojileri ortaya çıktı, daha sonra ise **Container** teknolojileri geliştirildi.

---

# Virtual Machine (VM) Nedir?

Virtual Machine (Sanal Makine), fiziksel bir bilgisayar üzerinde çalışan bağımsız bir bilgisayar gibidir.

Her VM:

* Kendi işletim sistemine sahiptir.
* Kendi RAM kullanımına sahiptir.
* Kendi disk alanına sahiptir.
* Diğer VM'lerden izole çalışır.

Örnek:

Fiziksel bilgisayar:

```text
MacBook
```

Üzerinde çalışan VM'ler:

```text
VM-1
└── Ubuntu

VM-2
└── Windows Server

VM-3
└── CentOS
```

Her biri ayrı bir bilgisayar gibi davranır.

---

# VM Nasıl Çalışır?

VM'lerin çalışmasını sağlayan yazılıma:

```text
Hypervisor
```

denir.

Örnek Hypervisor'lar:

* VMware
* VirtualBox
* Hyper-V

Mimari:

```text
Fiziksel Donanım
        │
Hypervisor
        │
 ┌──────┼──────┐
 │      │      │
VM1    VM2    VM3
 │      │      │
OS     OS     OS
 │      │      │
APP    APP    APP
```
Fiziksel bilgisayar üzerine bir hypervisor (VirtualBox, VMware vb.) kurulur. Hypervisor sayesinde birden fazla sanal makine (VM) oluşturulur. Her VM kendi işletim sistemine sahiptir ve uygulamalar bu işletim sistemlerinin üzerine kurulur. Böylece tek bir fiziksel bilgisayar üzerinde birden fazla bağımsız bilgisayar çalıştırılmış olur.

Her VM kendi işletim sistemini taşır.

Bu yüzden ağırdır.

---

# Container Nedir?

Container, uygulamayı ve ihtiyaç duyduğu bağımlılıkları birlikte paketleyen hafif bir çalışma ortamıdır.

Container içerisinde:

* Uygulama kodu
* Java Runtime
* Gerekli kütüphaneler
* Konfigürasyonlar

bulunur.

Ancak tam bir işletim sistemi bulunmaz.

Container'lar host işletim sisteminin çekirdeğini (kernel) paylaşırlar.

---

# Container Nasıl Çalışır?

```text
Fiziksel Donanım
       │
Host İşletim Sistemi
       │
Docker Engine
       │
 ┌─────┼─────┐
 │     │     │
C1    C2    C3
 │     │     │
APP   APP   APP
```
Fiziksel bilgisayar üzerinde bir işletim sistemi çalışır. Bu işletim sistemine Docker Engine kurulur ve Docker Engine birden fazla container oluşturur. Uygulamalar bu container'ların içinde çalışır. Container'lar ayrı işletim sistemi taşımadıkları için VM'lere göre daha hafif ve daha hızlıdır.

Burada:

* Ayrı işletim sistemi yoktur.
* Kernel paylaşılır.
* Kaynak kullanımı daha düşüktür.

Bu nedenle container'lar çok hızlı başlar.

---

# VM ve Container Karşılaştırması

| Özellik              | VM         | Container   |
| -------------------- | ---------- | ----------- |
| Ayrı işletim sistemi | ✅          | ❌           |
| Başlangıç süresi     | Dakikalar  | Saniyeler   |
| RAM kullanımı        | Yüksek     | Düşük       |
| Disk kullanımı       | Yüksek     | Düşük       |
| Performans           | Daha düşük | Daha yüksek |
| Taşınabilirlik       | Orta       | Çok yüksek  |
| Günümüzde kullanım   | Var        | Çok yaygın  |

---

# Backend Geliştirici Olarak Ben Nerede Kullanacağım?

Örneğin bir Spring Boot uygulaması geliştirdik.

Uygulama:

```text
Java 21
Spring Boot 3
Maven
PostgreSQL Driver
```

kullanıyor.

Container sayesinde:

```bash
docker run my-app
```

komutu verilen her makinede aynı şekilde çalışır.

Sunucuda:

* Java kurulu mu?
* Maven kurulu mu?
* Doğru sürüm mü?

gibi sorular ortadan kalkar.

---

# Docker Bu İşin Neresinde?

Container bir teknolojidir.

Docker ise container oluşturmayı ve çalıştırmayı kolaylaştıran platformdur.

Yani:

```text
Container = Konsept

Docker = Bu konsepti uygulayan araç
```

Docker günümüzde container dünyasının en yaygın aracıdır.

---

# Avantajları

* Ortam bağımsızlığı sağlar.
* Hızlı çalışır.
* Daha az kaynak tüketir.
* Taşınabilirlik sağlar.
* CI/CD süreçlerini kolaylaştırır.
* Kubernetes gibi sistemlerin temelini oluşturur.

---

# Dezavantajları

* Öğrenme eğrisi vardır.
* Ağ (network) yapıları başlangıçta karmaşık gelebilir.
* Veri saklama konusu dikkat gerektirir.
* Güvenlik yanlış yapılandırılırsa risk oluşturabilir.

---

# Mini Özet

* VM kendi işletim sistemini taşır.
* Container işletim sistemi taşımaz, kernel paylaşır.
* Container daha hafif ve hızlıdır.
* Docker container teknolojisini kullanmayı kolaylaştırır.
* Modern backend ve DevOps dünyasının temel yapı taşlarından biridir.
