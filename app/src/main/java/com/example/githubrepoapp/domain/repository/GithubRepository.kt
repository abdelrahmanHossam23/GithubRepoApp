package com.example.githubrepoapp.domain.repository

import com.example.githubrepoapp.domain.model.GithubRepoDomainModel
import com.example.githubrepoapp.domain.model.RepositoryDetailsDomainModel

interface GithubRepository {
    suspend fun fetchGithubRepos(): List<GithubRepoDomainModel>
    suspend fun fetchGithubRepoDetails(owner:String, name:String): RepositoryDetailsDomainModel
}