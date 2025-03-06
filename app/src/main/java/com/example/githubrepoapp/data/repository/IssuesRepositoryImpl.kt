package com.example.githubrepoapp.data.repository


import com.example.githubrepoapp.data.dataSources.remote.GithubRemoteDataSource
import com.example.githubrepoapp.data.mapper.toIssuesDomainModel
import com.example.githubrepoapp.domain.model.IssuesDomainModel
import com.example.githubrepoapp.domain.repository.IssuesRepository
import javax.inject.Inject

class IssuesRepositoryImpl @Inject constructor(
    private val githubRemoteDataSource: GithubRemoteDataSource
) : IssuesRepository {

    override suspend fun getIssues(owner: String, name: String) : List<IssuesDomainModel> {

        return githubRemoteDataSource.fetchIssues(owner, name).toIssuesDomainModel()
    }

}
