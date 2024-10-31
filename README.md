
# Prueba Amaris

Este proyecto está compuesto de un backend (API REST) y un frontend, diseñado para una prueba técnica en Amaris. El backend utiliza Spring Boot, mientras que el frontend está construido con React y Bootstrap. A continuación, encontrarás la documentación completa para configurar y ejecutar ambos proyectos.

## Tabla de Contenidos

- [Descripción](#descripción)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Instalación y Ejecución](#instalación-y-ejecución)
  - [Backend](#backend)
  - [Frontend](#frontend)
- [Endpoints del Backend](#endpoints-del-backend)
- [Generación del `.jar` y `.war`](#generación-del-jar-y-war)
- [Pruebas Unitarias](#pruebas-unitarias)

---

## Descripción

Este proyecto incluye dos componentes principales:
1. **Backend**: Una API REST desarrollada en Spring Boot, que permite realizar operaciones CRUD en los empleados.
2. **Frontend**: Una interfaz de usuario construida en React con Bootstrap, diseñada para consumir y mostrar los datos proporcionados por el backend.

## Estructura del Proyecto

```plaintext
PruebaAmaris/
├── back-end/               # Código fuente del backend (API REST)
└── front-end/              # Código fuente del frontend (React)
```
## Instalación y Ejecución

### Backend

#### Requisitos:
- **Java JDK** 17 o superior
- **Apache Maven**

#### Instalación:
Clona el repositorio y navega al directorio del backend:

```bash
git clone https://github.com/BlueWings98/PruebaAmaris.git
cd PruebaAmaris/back-end
```
## Ejecutar el Backend:

Ejecución en modo desarrollo:
```bash
mvn spring-boot:run
Ejecución del .jar: Si deseas generar el archivo .jar y ejecutarlo directamente:
```
```bash
mvn clean package
java -jar target/back-end-0.0.1-SNAPSHOT.jar
```
Configuración del application.properties: Asegúrate de que el archivo application.properties esté configurado correctamente, especialmente los parámetros de conexión a base de datos si los usas.

## Frontend
Requisitos:

Node.js (v16 o superior)
npm o yarn
Instalación: Navega al directorio del frontend y luego instala las dependencias:

```bash
cd ../front-end
npm install
```

## Ejecutar el Frontend:

```bash
npm run dev
```
El frontend estará disponible en http://localhost:3000.

## Endpoints del Backend
Obtener todos los empleados
```bash
GET /employee
```
Devuelve la lista completa de empleados.

Obtener un empleado por ID
```bash
GET /employee/id?id={id}
```
Devuelve la información de un empleado específico con el ID proporcionado.

## Generación del .jar y .war
Generar un .jar
Para generar un archivo .jar ejecutable del backend:

Navega a la carpeta back-end del proyecto:
```bash
cd back-end
```
Ejecuta el siguiente comando:

```bash
mvn clean package -Pspring-boot-auto-container
```
Esto generará un archivo .jar en el directorio target/, que puedes ejecutar con:

```bash
java -jar target/back-end-0.0.1-SNAPSHOT.jar
```
# Generar un .war
Para generar un archivo .war, puedes agregar un perfil en el archivo pom.xml y luego ejecutarlo de la siguiente manera:
```bash
mvn clean package -Pwildfly
```
El archivo .war se generará en el directorio target/ y podrá ser desplegado en un servidor de aplicaciones compatible como Tomcat o WildFly.

## Pruebas Unitarias
Para ejecutar las pruebas unitarias del backend (ApiClientTest), utiliza el siguiente comando en la carpeta del backend:
```bash
mvn test
```
Las pruebas unitarias están diseñadas para validar los endpoints de la API y la funcionalidad del ApiClient. Las pruebas incluyen la simulación de respuestas HTTP usando RestTemplate y MockRestServiceServer, y cubren casos exitosos y de manejo de excepciones para asegurar la robustez del sistema.

# Notas Finales
Este README documenta cómo configurar, ejecutar y probar el proyecto completo, incluyendo el backend y el frontend, así como los endpoints disponibles y las instrucciones para generar archivos ejecutables .jar y .war.

Para más información sobre cada módulo o cualquier consulta adicional, no dudes en revisar el código o abrir un issue en el repositorio de GitHub.
Este `README.md` proporciona una guía clara y completa para configurar y ejecutar el proyecto desde cero. Incluye instrucciones específicas para cada paso, desde la clonación y la ejecución hasta la generación de archivos ejecutables y la ejecución de pruebas.
