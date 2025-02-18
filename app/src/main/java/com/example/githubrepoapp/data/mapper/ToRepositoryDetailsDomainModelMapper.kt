package com.example.githubrepoapp.data.mapper

import com.example.githubrepoapp.data.dataSources.remote.retrofit.datamodel.repo_details.RepositoryDetailsDataModel

import com.example.githubrepoapp.domain.model.RepositoryDetailsDomainModel

fun RepositoryDetailsDataModel.toGithubRepoDomainModel(): RepositoryDetailsDomainModel {
    return RepositoryDetailsDomainModel(
        id = this.id,
        name = this.name,
        avatar = this.owner.avatar_url,
        description = this.description,
        stars = this.stargazersCount,
        owner = this.owner.login,
        forks = this.forks,
        language = this.language ?: "",
        fullName = this.fullName,
        url = this.url,
        createdAt = this.createdAt
    )
}