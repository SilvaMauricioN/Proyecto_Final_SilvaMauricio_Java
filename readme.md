# Museo Arte API
API REST para la gestión de obras de arte y artistas de un museo.

# Tecnologías Utilizadas
Desarrollada con Spring Boot 3, Java 17 y PostgreSQL.

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
# Configuración

Base de datos
Edita application.properties:
''' 
spring.datasource.url=jdbc:postgresql://localhost:5432/artmuseum
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
'''