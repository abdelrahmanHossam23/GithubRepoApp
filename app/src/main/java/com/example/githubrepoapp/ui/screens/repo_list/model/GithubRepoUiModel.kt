package com.example.githubrepoapp.ui.screens.repo_list.model

data class GithubRepoUiModel(
    val id: Int,
    val name: String,
    val avatar: String,
    val description: String,
    val owner: String,
    val stars: Int
)
