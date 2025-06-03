<h1 align="center">🎫 Sistema de Gestión de Turnos</h1>

<p align="center">
  <b>Arquitectura modular con Java, Spring MVC y Jakarta EE</b><br>
  Gestión eficiente de turnos con persistencia híbrida (MySQL + MongoDB)
</p>

<p align="center">
  <img src="https://img.shields.io/badge/java-21-red?style=flat-square&logo=java">
  <img src="https://img.shields.io/badge/spring-mvc-6DB33F?style=flat-square&logo=spring">
  <img src="https://img.shields.io/badge/maven-3.9+-blue?style=flat-square&logo=apachemaven">
<img src="https://img.shields.io/badge/RabbitMQ-FF6600?style=flat-square&logo=rabbitmq&logoColor=white">
</p>

---

## 🌟 Descripción

Este sistema modular permite la **gestión dinámica de turnos** para servicios administrativos o comerciales. Utiliza una **arquitectura desacoplada** con tres módulos principales y una solución de almacenamiento híbrida:

- 💽 **MySQL**: Datos transaccionales.
- 📚 **MongoDB**: Registro de eventos del sistema (logs).

---

## 🧱 Arquitectura del Proyecto

```
📦 ProyectoFinalProgra3
├── 🔹 turnos.api        → API RESTful con Swagger
├── 🔹 turnos.service    → Reglas y lógica del negocio
└── 🔹 turnos.repository → Persistencia con MySQL y MongoDB
```

### 🧩 Módulos

#### 🔹 `turnos.api`
> Encargado de exponer los endpoints y manejar la comunicación HTTP.

- Exposición de endpoints REST
- Validación de datos
- Documentación Swagger

#### 🔹 `turnos.service`
> Núcleo de lógica y transacciones.

- Reglas de negocio
- Gestión de eventos
- Coordinación de flujo entre capas

#### 🔹 `turnos.repository`
> Capa de acceso a datos.

- CRUD en **MySQL**
- Registro de eventos en **MongoDB**
- Mapeo de entidades

---

## 🚀 Tecnologías

| Tecnología    | Uso principal               |
|---------------|-----------------------------|
| ☕ Java 21     | Lenguaje base               |
| 🌱 Spring MVC | Controladores y servicios   |
| 🐬 MySQL      | Base de datos principal     |
| 🍃 MongoDB    | Logs y eventos              |
| 📦 Maven      | Gestión de dependencias     |
| 🧾 Swagger    | Documentación interactiva   |
| ✨ Lombok      | Reducción de boilerplate    |

---

## 📦 Requisitos del Sistema

- ✅ **Java 21**
- ✅ **Maven 3.9+**
- ✅ **MySQL Server**
- ✅ **MongoDB Server**

---

## 🛠️ Instalación y Ejecución

```bash
# 1. Clona el repositorio
git clone https://github.com/Dansosa18/Atencion_turnos.git

# 2. Accede al directorio
cd Atencion_turnos

# 3. Compila el proyecto
mvn clean install

# 4. Ejecuta la aplicación
mvn spring-boot:run
```

---

## 📚 Acceso a Documentación

Una vez ejecutado el sistema, accede a la documentación Swagger en:

👉 `http://localhost:8080/swagger-ui/index.html`

---

<div align="center">
  <h2>👨‍💻 Autor</h2>
  <img src="https://img.shields.io/badge/Desarrollado%20por-%20Victor Daniel Sosa Lopez-blue?style=for-the-badge">
  <br><br>
  <table align="center">
    <tr>
      <td align="center">
  </table>
</div>

---


<p align="center"><i>“La mejor forma de predecir el futuro... es programarlo.”</i></p>
