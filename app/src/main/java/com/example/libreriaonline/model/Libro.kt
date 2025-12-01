package com.example.libreriaonline.model

import com.google.gson.annotations.SerializedName

data class Libro(
    val id: Int,
    val titulo: String,
    @SerializedName("autor_id") val autorId: Int,
    @SerializedName("categoria_id") val categoriaId: Int,
    val isbn: String,
    val editorial: String,
    val precio: Double,
    val stock: Int,
    @SerializedName("fecha_publicacion") val fechaPublicacion: String,
    val descripcion: String?,
    val imagen: String?
)