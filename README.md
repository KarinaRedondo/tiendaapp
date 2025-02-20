# UNIVERSIDAD DE CARTAGENA
## INGENIERÍA DE SOFTWARE - ANÁLISIS Y DISEÑO DE SOFTWARE
### TRABAJO COLABORATIVO CONTEXTUALIZADO

## Sistema de Comercio Local

## Descripción

Se desarrollará un sistema que permitirá gestionar  y que conecte a tenderos, clientes y domiciliarios. Está desarrollado en Spring Boot y utiliza MongoDB como base de datos en el backend y React con typescripts en el frontend. Los tenderos pueden gestionar pedidos en tiempo real. Los clientes navegan, compran, llevan un seguimiento de pedidos fácilmente y califican productos. Por otro lado,  los domiciliarios gestionan y entregan pedidos de forma eficiente.

## Tecnologias
- React
- Typescripts
- Spring Boot
- MongoDB

## Requisitos
-   Node

## Cómo empezar
1. Clona este repositorio.
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
El sistema de gestión de eventos sigue una arquitectura por capas, lo que proporciona una estructura organizada y modular para el desarrollo de la aplicación. Cada capa tiene una responsabilidad específica y se comunica con las capas adyacentes de manera controlada, lo que promueve la escalabilidad, el mantenimiento y la reutilización del código. 
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


# React + TypeScript + Vite

This template provides a minimal setup to get React working in Vite with HMR and some ESLint rules.

Currently, two official plugins are available:

- [@vitejs/plugin-react](https://github.com/vitejs/vite-plugin-react/blob/main/packages/plugin-react/README.md) uses [Babel](https://babeljs.io/) for Fast Refresh
- [@vitejs/plugin-react-swc](https://github.com/vitejs/vite-plugin-react-swc) uses [SWC](https://swc.rs/) for Fast Refresh

## Expanding the ESLint configuration

If you are developing a production application, we recommend updating the configuration to enable type aware lint rules:

- Configure the top-level `parserOptions` property like this:

```js
export default {
  // other rules...
  parserOptions: {
    ecmaVersion: 'latest',
    sourceType: 'module',
    project: ['./tsconfig.json', './tsconfig.node.json', './tsconfig.app.json'],
    tsconfigRootDir: __dirname,
  },
}
```

- Replace `plugin:@typescript-eslint/recommended` to `plugin:@typescript-eslint/recommended-type-checked` or `plugin:@typescript-eslint/strict-type-checked`
- Optionally add `plugin:@typescript-eslint/stylistic-type-checked`
- Install [eslint-plugin-react](https://github.com/jsx-eslint/eslint-plugin-react) and add `plugin:react/recommended` & `plugin:react/jsx-runtime` to the `extends` list
