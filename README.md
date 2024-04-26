# Microservicio de Productos por Cliente (ms-customer-products)

Este microservicio se encarga de gestionar productos asociados a clientes específicos. Permite obtener productos activos por cliente, así como agregar, actualizar o eliminar productos.

## Requisitos Previos
Para ejecutar el microservicio, necesitas:
- **Java 17** o superior
- **Apache Maven** para compilación y ejecución

## Collection Postman
- [PROJECT02.postman_collection.json](PROJECT02.postman_collection.json)
- [Desarrollo.postman_environment.json](Desarrollo.postman_environment.json)

## Instrucciones de Ejecución
Para ejecutar el microservicio localmente:
1. **Clona el repositorio**:
```
mvn clean package
```

2. **Ejecuta el microservicio**:
```
mvn spring-boot:run
```
