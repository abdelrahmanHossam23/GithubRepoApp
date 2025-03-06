package com.example.githubrepoapp.data.dataSources.remote

import com.example.githubrepoapp.data.dataSources.remote.retrofit.api.GithubApi
import com.example.githubrepoapp.data.dataSources.remote.retrofit.api.IssuesApi
import com.example.githubrepoapp.data.dataSources.remote.retrofit.api.RepoDetailsApi
import com.example.githubrepoapp.data.dataSources.remote.retrofit.datamodel.issues.IssuesDataModel
import com.example.githubrepoapp.data.dataSources.remote.retrofit.datamodel.issues.IssuesDataModelItem
import com.example.githubrepoapp.data.dataSources.remote.retrofit.datamodel.repo_details.RepositoryDetailsDataModel
import com.example.githubrepoapp.data.dataSources.remote.retrofit.datamodel.repo_list.GithubReposDataModel
import com.example.githubrepoapp.data.mapper.toCustomExceptionDomainModel
import com.example.githubrepoapp.domain.model.CustomExceptionDomainModel
import java.io.IOException
import javax.inject.Inject

class GithubRemoteDataSource @Inject constructor(
    private val githubApi: GithubApi,
    private val repoDetailsApi: RepoDetailsApi,
    private val issuesApi: IssuesApi
) {
    suspend fun fetchGithubRepos(): GithubReposDataModel {
        return try {
//            throw IOException()
            githubApi.fetchGithubRepos().body() as GithubReposDataModel
        } catch (e: Exception){
            throw e.toCustomExceptionDomainModel()
        }
    }
    suspend fun fetchGithubRepoDetails(
        owner: String,
        name:String
    ):RepositoryDetailsDataModel  {
        return repoDetailsApi.fetchRepoDetails(
            owner, name
        ).body() as RepositoryDetailsDataModel
    }

    suspend fun fetchIssues(
        owner: String,
        name:String
    ): IssuesDataModel {
        return issuesApi.fetchIssues(
            owner, name
        ).body() as IssuesDataModel
    }
}