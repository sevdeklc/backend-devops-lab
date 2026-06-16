# Backend DevOps Lab

Bu repo, backend geliştirme ve DevOps süreçlerini adım adım öğrenmek için oluşturulmuştur.

Amaç; Spring Boot, Docker, docker-compose, Jenkins, Docker Registry, Kubernetes, Prometheus ve Grafana gibi araçları sadece teorik olarak öğrenmek değil, gerçek bir backend projesi üzerinde uygulayarak anlamaktır.

## Hedef

Bu yolculuğun sonunda bir Spring Boot REST API geliştirilecek ve bu uygulama modern backend/DevOps araçlarıyla uçtan uca çalıştırılabilir hale getirilecektir.

Final hedef:

* Spring Boot REST API geliştirmek
* Uygulamayı Dockerize etmek
* docker-compose ile veritabanına bağlamak
* Jenkins ile build/test pipeline kurmak
* Docker image'ı registry'e push etmek
* Opsiyonel olarak Kubernetes/Minikube ortamına deploy etmek
* Prometheus ve Grafana ile uygulamayı izlemek

## Öğrenilecek Konular

1. Container nedir, sanal makineden yani VM'den farkı nedir?
2. CI/CD nedir, neden vardır?
3. Docker image ile container arasındaki fark nedir?
4. Registry ne demektir? Docker Hub neden vardır?
5. Spring Boot nedir, normal Java'dan farkı nedir, neden bu kadar yaygındır?
6. Veritabanı container içinde çalışınca veriler nerede saklanır? Volume nedir?
7. docker-compose ne işe yarar? Tek bir Docker kullanımından farkı nedir?
8. Jenkins ne yapar? Pipeline derken ne kastedilir?
9. Kubernetes neden vardır? docker-compose varken neden Kubernetes'e ihtiyaç duyulmuştur?
10. Monitoring / observability ne demektir? Prometheus ve Grafana ne işe yarar?

## Dosya Yapısı

```text
backend-devops-lab/
│
├── README.md
├── 01-container-vs-vm.md
├── 02-ci-cd.md
├── 03-docker-image-vs-container.md
├── 04-registry-dockerhub.md
├── 05-spring-boot.md
├── 06-database-volume.md
├── 07-docker-compose.md
├── 08-jenkins-pipeline.md
├── 09-kubernetes.md
├── 10-monitoring-observability.md
│
├── app/
│   └── Spring Boot REST API projesi
│
├── docker/
│   ├── Dockerfile
│   └── docker-compose.yml
│
├── jenkins/
│   └── Jenkinsfile
│
├── k8s/
│   ├── deployment.yaml
│   └── service.yaml
│
└── monitoring/
    ├── prometheus.yml
    └── grafana-notes.md
```

## Final Proje

Final proje olarak basit ama gerçek hayatta karşılığı olan bir REST API geliştirilecektir.

Örnek proje: **Task Manager API**

Bu API ile:

* Task oluşturulabilecek
* Task listelenebilecek
* Task güncellenebilecek
* Task silinebilecek
* Veriler PostgreSQL veya MySQL veritabanında saklanacak
* Uygulama Docker ile çalıştırılacak
* Veritabanı docker-compose ile ayağa kaldırılacak
* Jenkins ile otomatik build ve test süreci kurulacak
* Docker image registry'e gönderilecek
* Opsiyonel olarak Kubernetes/Minikube ortamına deploy edilecek
* Prometheus ve Grafana ile uygulama izlenecek

## Öğrenme Yaklaşımı

Her konu ayrı bir markdown dosyasında sade ve anlaşılır şekilde ele alınacaktır.

Her dosyada şu yapı kullanılacaktır:

* Kısa tanım
* Neden ihtiyaç duyulur?
* Günlük hayattan benzetme
* Backend geliştirici için önemi
* Basit örnek
* Mini özet

## Not

Bu repo bir öğrenme reposudur. Amaç ezber yapmak değil, kullanılan araçların neden ortaya çıktığını ve gerçek projelerde ne işe yaradığını anlamaktır.
