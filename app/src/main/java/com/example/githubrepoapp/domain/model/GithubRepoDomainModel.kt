package com.example.githubrepoapp.domain.model

data class GithubRepoDomainModel(
    val id: Int,
    val name: String,
    val avatar: String,
    val description: String,
    val stars: Int,
    val owner: String
)
