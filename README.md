# Pikmin Guide

Una aplicación Android nativa desarrollada en **Kotlin** que presenta una guía interactiva de los diferentes tipos de Pikmin del universo de Nintendo. La aplicación utiliza **Jetpack Navigation** para la navegación entre fragmentos y un **RecyclerView** para mostrar la lista de Pikmin en una cuadrícula.

## 📋 Descripción

Pikmin Guide es una aplicación educativa que permite a los usuarios explorar y aprender sobre los diferentes tipos de Pikmin. La aplicación incluye:

- **Lista interactiva** de Pikmin en formato de cuadrícula.
- **Detalles completos** de cada Pikmin con descripción e imagen.
- **Interfaz intuitiva** con navegación fluida.
- **Soporte multiidioma** (español e inglés).
- **Modo oscuro** disponible.
- **Splash screen** personalizado (Nativo API 31+).

## ✨ Características

### Pantalla Principal (`ListaFragment`)
- Muestra un listado de 9 tipos de Pikmin en una cuadrícula de 2 columnas.
- Tipos incluidos: Red, Yellow, Blue, White, Purple, Rock, Winged, Ice y Glow.
- **Snackbar** de bienvenida al cargar la pantalla.
- Navegación al detalle al seleccionar un Pikmin.

### Pantalla de Detalles (`PaginapikFragment`)
- Información completa de cada Pikmin.
- Imagen característica en gran tamaño.
- Descripción detallada de características y habilidades.

### Pantalla de Ajustes (`AjustesFragment`)
- Interruptor para configuración de idioma (Español/Inglés).
- Interruptor para opción de modo oscuro (Dark Mode).

### Menú Superior
- Opción "Acerca de" con información del desarrollador (`AlertDialog`).
- Acceso directo a la pantalla de configuración.

## 🛠️ Tecnologías Utilizadas

- **Lenguaje:** Kotlin
- **Compilador:** Android Gradle Plugin
- **Versión mínima de Android:** API 24
- **Versión objetivo de Android:** API 34 (o superior)
- **Arquitectura:** Single Activity + Fragments
