package com.example.githubrepoapp.data.dataSources.remote.retrofit.datamodel.issues

data class Label(
    val color: String,
    val default: Boolean,
    val description: String,
    val id: Long,
    val name: String,
    val node_id: String,
    val url: String
)
