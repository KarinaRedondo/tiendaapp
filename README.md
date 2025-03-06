# UNIVERSIDAD DE CARTAGENA
## INGENIERÍA DE SOFTWARE - ANÁLISIS Y DISEÑO DE SOFTWARE
### TRABAJO COLABORATIVO CONTEXTUALIZADO

## Sistema de Comercio Local

## Descripción

El sistema es una plataforma de comercio local desarrollada con Spring Boot y basada en microservicios para asegurar escalabilidad y mantenimiento. Facilita la interacción entre clientes, tenderos y repartidores mediante una arquitectura segura que utiliza Spring Security y autenticación JWT. Permite gestionar usuarios, tiendas, vehículos, pedidos, calificaciones, ganancias y ventas, mejorando la comunicación y la eficiencia en la entrega de productos a domicilio.

## Tecnologías
- Spring Boot
- MongoDB

## Dependencias
- ### Spring Boot
    - **Spring Data MongoDB** → Permite interactuar con MongoDB de forma sencilla.
    - **Spring Data Reactive MongoDB** → Soporta procesamiento reactivo para MongoDB.
    - **Spring Web** → Permite construir APIs REST con Spring MVC.
    - **Spring Security** → Proporciona autenticación y autorización.
    - **Spring Boot DevTools** → Facilita el desarrollo con recarga automática.

- ### Desarrollo
    - **Lombok** → Reduce código repetitivo en entidades y DTOs.
    - **JJWT** → Maneja autenticación con JSON Web Tokens (JWT).

- ### Pruebas
    - **Spring Boot Starter Test** → Proporciona herramientas para pruebas con JUnit.
    - **Reactor Test** → Permite pruebas en aplicaciones reactivas.
    - **Spring Security Test** → Facilita la prueba de seguridad en la aplicación.

- ### Build y Compilación
    - **Maven Compiler Plugin** → Compila el código con soporte para Java 17.
    - **Spring Boot Maven Plugin** → Empaqueta y ejecuta la aplicación con Maven.

## Requisitos
-   Node
-   Java 17

## Cómo empezar
1. Clona este repositorio git@github.com:KarinaRedondo/tiendaapp.git
2. Configura la conexión a la base de datos en el archivo de configuración `application.properties`.
3. Ejecuta la aplicación.

## Información adicional

Este proyecto utiliza el plugin `spring-boot-maven-plugin` para compilar y empaquetar la aplicación.

## Principios de Diseño y Flujo de Trabajo en el Backend
En este proyecto, hemos utilizado uno de los principios SOLID, específicamente el principio de responsabilidad única (SRP). Este principio establece que cada módulo o clase debe tener una única responsabilidad, es decir, debe encargarse de una sola cosa. Esto se traduce en un código más limpio, mantenible y fácil de entender. Dividimos el proyecto en varias capas para asegurar que cada una funcione de la manera más independiente posible de las otras: 
- **Controladores**: Manejan las solicitudes HTTP y responden con los datos necesarios. 
-  **DTOs (Data Transfer Objects)**: Encapsulan los datos que se envían entre las distintas capas de la aplicación. 
- **Entidades**: Representan las estructuras de datos persistentes en la base de datos. 
- **Repositorios**: Encargados de la interacción con la base de datos. 
- **Servicios**: Contienen la lógica de negocio de la aplicación.

## Arquitectura por Capas 
El sistema de Comercio Local sigue una arquitectura por capas, lo que proporciona una estructura organizada y modular para el desarrollo de la aplicación. Cada capa tiene una responsabilidad específica y se comunica con las capas adyacentes de manera controlada, lo que promueve la escalabilidad, el mantenimiento y la reutilización del código. 
### Capas Principales: 
1. **Controladores (Controllers)**: - Responsabilidad: Manejar las solicitudes HTTP y las respuestas asociadas. - Interacción: Se comunican con los servicios para realizar operaciones de negocio y devolver los resultados adecuados a los clientes. 
2. **Servicios (Services)**: - Responsabilidad: Contener la lógica de negocio de la aplicación. - Interacción: Utilizan los repositorios para acceder a los datos persistentes y aplicar las reglas de negocio requeridas. 
3. **Repositorios (Repositories)**: - Responsabilidad: Encargarse de la interacción con la base de datos. - Interacción: Realizan operaciones de lectura y escritura en la base de datos para almacenar y recuperar la información requerida por la aplicación. 
4. **Entidades (Entities)**: - Responsabilidad: Representar las estructuras de datos persistentes en la base de datos. - Interacción: Definen los objetos de datos que se almacenan y recuperan de la base de datos, reflejando la estructura del dominio de la aplicación. 
5. **DTOs (Data Transfer Objects)**: - Responsabilidad: Encapsular los datos que se transfieren entre las distintas capas de la aplicación. - Interacción: Facilitan la comunicación entre los controladores, servicios y repositorios al transportar datos de un lugar a otro de manera eficiente y estructurada. 

### Beneficios: 
- **Separación de Responsabilidades**: Cada capa tiene una función específica, lo que facilita la comprensión y el mantenimiento del código. 
- **Escalabilidad**: La arquitectura por capas permite agregar nuevas funcionalidades de manera modular sin afectar otras partes del sistema. 
- **Reutilización del Código**: Los componentes están diseñados para ser independientes y pueden ser reutilizados en diferentes partes de la aplicación o en proyectos futuros. 
- **Facilita el Testing**: Las capas separadas permiten una mejor organización de las pruebas unitarias y de integración, lo que facilita la identificación y corrección de errores. Esta arquitectura proporciona una base sólida para el desarrollo del sistema de gestión de eventos, promoviendo la robustez, la flexibilidad y la mantenibilidad del código.
