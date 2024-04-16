# Proyecto API banco 

## Requisitos

- JDK (versión X.X o superior)
- Maven (versión X.X o superior)
- PostgreSQL (opcional, si se utiliza como base de datos)

## Configuración del Proyecto

1. Clona este repositorio en tu máquina local.

```bash
git clone https://github.com/tu-usuario/tu-proyecto.git
```

2. Abre el proyecto en tu IDE preferido (Eclipse, IntelliJ, etc.).

3. Configura la conexión a la base de datos en el archivo `application.properties` o `application.yml`.

```yaml
spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_basedatos
spring.datasource.username=usuario
spring.datasource.password=contraseña
```

4. Ejecuta la aplicación Spring Boot desde tu IDE o utilizando Maven.

```bash
mvn spring-boot:run
```

## Uso

# API de Clientes

Esta API proporciona endpoints para administrar clientes.

## Obtener todos los clientes

- **Endpoint:** `GET /api/clientes`
- **Descripción:** Retorna todos los clientes almacenados en la base de datos.
- **Respuesta exitosa:** Código de estado HTTP 200 OK junto con la lista de clientes.
- **Ejemplo de respuesta:**
  ```json
  [
    {
      "id": 1,
      "nombre": "John Doe",
      "direccion": "123 Main Street",
      "telefono": "123-456-7890"
    },
    {
      "id": 2,
      "nombre": "Jane Smith",
      "direccion": "456 Elm Street",
      "telefono": "987-654-3210"
    }
  ]
## 

## Autor

- Nombre: [Diego]
- Email: [diego_19996.c.c@hotmail.com]

## Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE.md](LICENSE.md) para más detalles.
