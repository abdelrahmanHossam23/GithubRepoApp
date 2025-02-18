package com.example.githubrepoapp.data.dataSources.remote.retrofit.api

import com.example.githubrepoapp.data.Constants.Companion.OWNER_KEY
import com.example.githubrepoapp.data.Constants.Companion.REPO_NAME_KEY
import com.example.githubrepoapp.data.dataSources.remote.retrofit.datamodel.issues.IssuesDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IssuesApi {
    @GET("repos/{$OWNER_KEY}/{$REPO_NAME_KEY}/issues")
    suspend fun fetchIssues(
        @Path(OWNER_KEY) owner: String,
        @Path(REPO_NAME_KEY) name: String
    ): Response<IssuesDataModel>
}