package com.example.githubrepoapp.domain.model

import com.example.githubrepoapp.data.dataSources.remote.retrofit.datamodel.issues.Assignee
import com.example.githubrepoapp.data.dataSources.remote.retrofit.datamodel.issues.Label
import com.example.githubrepoapp.data.dataSources.remote.retrofit.datamodel.issues.PullRequest
import com.example.githubrepoapp.data.dataSources.remote.retrofit.datamodel.issues.Reactions
import com.example.githubrepoapp.data.dataSources.remote.retrofit.datamodel.issues.User

data class IssuesDomainModel(
    val created_at: String,
    val id: Long,
    val title: String,
    val user: User,
    val state: IssueState,
)
