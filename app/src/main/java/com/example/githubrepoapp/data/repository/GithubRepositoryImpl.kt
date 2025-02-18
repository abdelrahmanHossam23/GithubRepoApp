package com.example.githubrepoapp.data.repository

import com.example.githubrepoapp.data.dataSources.remote.GithubRemoteDataSource
import com.example.githubrepoapp.data.mapper.toGithubRepoDomainModel
import com.example.githubrepoapp.domain.model.GithubRepoDomainModel
import com.example.githubrepoapp.domain.model.RepositoryDetailsDomainModel
import com.example.githubrepoapp.domain.repository.GithubRepository
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val githubRemoteDataSource: GithubRemoteDataSource
): GithubRepository {
    override suspend fun fetchGithubRepos(): List<GithubRepoDomainModel> {
        return githubRemoteDataSource.fetchGithubRepos().toGithubRepoDomainModel()
    }

    override suspend fun fetchGithubRepoDetails(owner:String, name: String): RepositoryDetailsDomainModel {
        return githubRemoteDataSource.fetchGithubRepoDetails(owner, name).toGithubRepoDomainModel()
    }
}