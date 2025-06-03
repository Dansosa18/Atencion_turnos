<h1 align="center">⚙️ Módulo Service - Sistema de Turnos</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Spring-Service-6DB33F?style=flat-square&logo=spring">
  <img src="https://img.shields.io/badge/RabbitMQ-FF6600?style=flat-square&logo=rabbitmq">
  <img src="https://img.shields.io/badge/Java-21-red?style=flat-square&logo=java">
</p>

---

## 📖 Descripción

Este módulo corresponde a la capa de **servicio** del sistema de gestión de turnos. Se encarga de aplicar la lógica de negocio, orquestar la interacción entre la API (controladores) y la capa de persistencia (repositorios), y administrar la mensajería asíncrona mediante **RabbitMQ**.

---

## 🔑 Características Principales

- 🧠 Implementación de la lógica de negocio central
- 🐇 Comunicación asíncrona con RabbitMQ
- 🔄 Procesamiento y actualización de turnos en tiempo real
- 📈 Manejo de estados, reglas y transiciones
- ✅ Validación de reglas de negocio y datos

---

## 🛠️ Tecnologías Utilizadas

- **Java 21**: Lenguaje base del proyecto
- **Spring Boot**: Framework para el desarrollo de microservicios
- **RabbitMQ**: Sistema de colas de mensajería asíncrona
- **MySQL**: Motor de base de datos relacional (interactuando a través del módulo `Repository`)
- **Lombok**: Para reducir el código repetitivo (boilerplate)

---

## ⚙️ Configuración

### 🔧 application.properties / application.yml

Asegúrate de tener configuradas las siguientes propiedades para el funcionamiento del módulo:

```properties
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
```

También puedes configurar colas, exchanges y bindings directamente desde los beans en tu clase de configuración.

---

## 🚀 Ejecución

Este módulo no es independiente, forma parte de un sistema distribuido. Para probarlo correctamente:

1. Ejecuta el módulo `Repository` (persistencia).
2. Asegúrate de que RabbitMQ esté corriendo.
3. Ejecuta este módulo (`Service`) y verifica el consumo y publicación de mensajes.

---
