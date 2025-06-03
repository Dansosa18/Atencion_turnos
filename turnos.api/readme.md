<h1 align="center">📡 Módulo API de Turnos</h1>

<p align="center">
  <i>Microservicio de presentación para la gestión de turnos</i><br>
  <i>Basado en Spring Boot, documentado con OpenAPI y conectado mediante RabbitMQ</i>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
  <img src="https://img.shields.io/badge/OpenAPI%2FSwagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black">
  <img src="https://img.shields.io/badge/RabbitMQ-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white">
</p>

---

## 🧭 Descripción

Este módulo actúa como **puerta de entrada** al sistema de turnos, exponiendo endpoints RESTful para el consumo externo. Está diseñado para manejar la **capa de presentación** y facilitar la comunicación entre el usuario y la lógica de negocio mediante un esquema desacoplado y moderno.

---

## ⚙️ Tecnologías Utilizadas

| Tecnología        | Funcionalidad                               |
|-------------------|----------------------------------------------|
| ☕ Spring Boot     | Framework principal del módulo               |
| 🧾 Swagger / OpenAPI | Documentación interactiva de la API REST |
| 📬 RabbitMQ        | Comunicación asíncrona entre microservicios |

---

## 🚀 Características Destacadas

- ✅ Exposición de endpoints RESTful
- ✅ Documentación automática con Swagger
- ✅ Validación robusta de solicitudes
- ✅ Manejo centralizado de errores
- ✅ Comunicación asíncrona vía RabbitMQ
- ✅ Modularidad y mantenibilidad

---

## 🔗 Endpoints Documentados

Una vez en ejecución, puedes acceder a la documentación Swagger en:

> 📍 `http://localhost:8080/swagger-ui/index.html`

Allí encontrarás ejemplos, formatos de entrada/salida y métodos disponibles para cada recurso.

---

## 📦 Integraciones

Este módulo se conecta y colabora con los siguientes componentes del sistema:

- 🔄 **turnos.service** → Para ejecutar la lógica de negocio.
- 💾 **turnos.repository** → A través de la capa de servicios.
- 📡 **RabbitMQ** → Para propagar eventos del sistema (como turnos generados, atendidos o cancelados).

---

## 🧪 Buenas Prácticas Implementadas

- Separación clara entre controlador, servicio y DTOs.
- Uso de anotaciones `@Valid`, `@ControllerAdvice` y `@RestController`.
- Configuración desacoplada en `application.properties`.
- Uso de DTOs para evitar exponer entidades directamente.

---


<p align="center"><i>“Un buen diseño de API es invisible para el usuario, pero poderoso para el sistema.”</i></p>
