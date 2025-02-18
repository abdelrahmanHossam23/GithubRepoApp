package com.example.githubrepoapp.data.dataSources.remote.retrofit.datamodel.issues

data class PullRequest(
    val diff_url: String,
    val html_url: String,
    val merged_at: Any,
    val patch_url: String,
    val url: String
)
