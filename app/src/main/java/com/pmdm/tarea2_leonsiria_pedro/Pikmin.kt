package com.pmdm.tarea2_leonsiria_pedro

/**
 * Modelo de datos que representa a un Pikmin.
 *
 * @property name Nombre del Pikmin (se obtendrá de strings.xml).
 * @property description Descripción detallada del Pikmin.
 * @property imageResId Identificador del recurso de imagen.
 */
data class Pikmin(
    val name: String,
    val description: String,
    val imageResId: Int
)