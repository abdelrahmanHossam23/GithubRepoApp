package com.example.githubrepoapp.data.mapper

import com.example.githubrepoapp.data.dataSources.remote.retrofit.datamodel.repo_list.GithubReposDataModel
import com.example.githubrepoapp.domain.model.GithubRepoDomainModel

fun GithubReposDataModel.toGithubRepoDomainModel(): List<GithubRepoDomainModel> {
    return this.items.map { item ->
        GithubRepoDomainModel(
            id = item.id,
            name = item.name,
            avatar = item.owner.avatar_url,
            description = item.description,
            stars = item.stargazers_count,
            owner = item.owner.login
        )
    }
}