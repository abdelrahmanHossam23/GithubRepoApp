package com.example.githubrepoapp.ui.mapper

import com.example.githubrepoapp.domain.model.GithubRepoDomainModel
import com.example.githubrepoapp.ui.screens.repo_list.model.GithubRepoUiModel

fun GithubRepoDomainModel.toGithubRepoUiModel(): GithubRepoUiModel{
    return GithubRepoUiModel(
        id = this.id,
        name = this.name,
        avatar = this.avatar,
        description = this.description,
        stars = this.stars,
        owner = this.owner
    )
}