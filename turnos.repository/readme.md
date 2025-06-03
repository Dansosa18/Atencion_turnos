<h1 align="center">💾 Módulo Repository - Sistema de Turnos</h1>

<p align="center">
  <i>Capa de persistencia con arquitectura híbrida: MySQL + MongoDB</i>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?style=for-the-badge&logo=spring">
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
  <img src="https://img.shields.io/badge/MongoDB-47A248?style=for-the-badge&logo=mongodb">
</p>

---

## 🧭 Descripción General

Este módulo encapsula toda la lógica relacionada con la **persistencia de datos**, implementando una arquitectura híbrida que separa:

- 📊 **Datos estructurados y transaccionales** → almacenados en **MySQL**
- 🧾 **Eventos del sistema y logs** → almacenados en **MongoDB**

Todo está desacoplado mediante interfaces y repositorios, lo que permite mayor mantenibilidad y flexibilidad.

---

## 🗃️ Entidades Principales

### 🐬 MySQL (Datos Transaccionales)

| Entidad  | Descripción                         |
|----------|-------------------------------------|
| `Cliente` | Información de los clientes         |
| `Servicio` | Catálogo de servicios disponibles  |
| `Turno`    | Registro y control de turnos activos |

### 🍃 MongoDB (Eventos del Sistema)

| Entidad     | Descripción                          |
|-------------|--------------------------------------|
| `TurnoLog`  | Historial y trazabilidad de acciones |

---

## ⚙️ Configuración Técnica

Este módulo utiliza **Spring Data JPA** para MySQL y **Spring Data MongoDB** para el registro de eventos.

### Dependencias Clave

```xml
<!-- JPA para MySQL -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- MongoDB -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>

<!-- Driver MySQL -->
<dependency>
  <groupId>com.mysql</groupId>
  <artifactId>mysql-connector-j</artifactId>
</dependency>
```

---

## 🔐 Gestión de Repositorios

Los repositorios se agrupan según el motor de persistencia:

- **JPA Repositories**: Interfaces para entidades de MySQL (`ClienteRepository`, `ServicioRepository`, `TurnoRepository`).
- **Mongo Repositories**: Interfaces para documentos en MongoDB (`TurnoLogRepository`).

Ambos tipos implementan operaciones CRUD y queries personalizadas si es necesario.

---

## 📦 Arquitectura Simplificada

```
🧱 turnos.repository
├── entidad/
│   ├── Cliente.java
│   ├── Servicio.java
│   └── Turno.java
├── documento/
│   └── TurnoLog.java
└── repositorio/
    ├── ClienteRepository.java
    ├── ServicioRepository.java
    ├── TurnoRepository.java
    └── TurnoLogRepository.java
```

---

## 📌 Notas Técnicas

- 🗄️ Se utiliza `@Entity` para modelos JPA y `@Document` para MongoDB.
- ⚠️ Las configuraciones se externalizan en `application.properties` o `application.yml`.
- 💡 Se recomienda usar proyecciones o DTOs para evitar exponer directamente las entidades.

---

<p align="center"><i>“Persistir datos no es solo almacenarlos, es diseñar cómo deben ser recordados.”</i></p>
