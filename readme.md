# Artistas CRUD API

Este es un proyecto de ejemplo que implementa una API RESTful básica utilizando Spring Boot para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre la entidad Artistas.

# Tecnologías Utilizadas

Spring Boot: Framework principal para crear aplicaciones de grado de producción.

Spring Data JPA: Para la interacción con la base de datos (CRUD).

Hibernate: Implementación de JPA por defecto.

Base de Datos: Configurada en application.properties (PostgreSQL).

Java: Lenguaje de programación.

Maven: Gestor de dependencias.

# Endpoints de la API (CRUD)

|   Método   | URL                         | Descripción                                             | Cuerpo de la Petición (Body)                      |
| :--------: | :-------------------------- | :------------------------------------------------------ | :------------------------------------------------ |
|  **POST**  | `/api/principalmakers`      | **Crear** un nuevo `PrincipalMaker`.                    | **Requerido** (Objeto JSON con los datos).        |
|  **GET**   | `/api/principalmakers`      | **Leer** (obtener) todos los `PrincipalMakers`.         | Ninguno.                                          |
|  **GET**   | `/api/principalmakers/{id}` | **Leer** (obtener) un `PrincipalMaker` por su ID.       | Ninguno.                                          |
|  **PUT**   | `/api/principalmakers/{id}` | **Actualizar** un `PrincipalMaker` existente por su ID. | **Requerido** (Objeto JSON con los nuevos datos). |
| **DELETE** | `/api/principalmakers/{id}` | **Eliminar** un `PrincipalMaker` por su ID.             | Ninguno.                                          |
