package com.example.githubrepoapp.data.dataSources.remote.retrofit.api

import com.example.githubrepoapp.data.Constants.Companion.GITHUB_REPOS_ENDPOINT
import com.example.githubrepoapp.data.dataSources.remote.retrofit.datamodel.repo_list.GithubReposDataModel
import retrofit2.Response
import retrofit2.http.GET

interface GithubApi {
    @GET(GITHUB_REPOS_ENDPOINT)
    suspend fun fetchGithubRepos(): Response<GithubReposDataModel>
}