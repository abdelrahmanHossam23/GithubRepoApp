package com.example.githubrepoapp.data.dataSources.remote.retrofit.datamodel.repo_list

data class GithubReposDataModel(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)
