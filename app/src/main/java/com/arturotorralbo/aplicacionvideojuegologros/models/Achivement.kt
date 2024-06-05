package com.arturotorralbo.aplicacionvideojuegologros.models

import kotlinx.serialization.Serializable

@Serializable
data class Achivement(

    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val difficulty: String
)
