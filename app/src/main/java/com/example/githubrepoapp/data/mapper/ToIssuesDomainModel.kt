package com.example.githubrepoapp.data.mapper

import com.example.githubrepoapp.data.dataSources.remote.retrofit.datamodel.issues.IssuesDataModel
import com.example.githubrepoapp.data.dataSources.remote.retrofit.datamodel.repo_details.RepositoryDetailsDataModel
import com.example.githubrepoapp.data.dataSources.remote.retrofit.datamodel.repo_list.GithubReposDataModel
import com.example.githubrepoapp.domain.model.GithubRepoDomainModel
import com.example.githubrepoapp.domain.model.IssueState
import com.example.githubrepoapp.domain.model.IssuesDomainModel
import com.example.githubrepoapp.domain.model.RepositoryDetailsDomainModel



fun IssuesDataModel.toIssuesDomainModel(): List<IssuesDomainModel>{
    return this.map { item ->
        IssuesDomainModel(
            id = item.id,
            created_at = item.created_at,
            title = item.title,
            user = item.user,
            state = when (item.state) { // Convert String to IssueState
                "open" -> IssueState.Open
                "closed" -> IssueState.Closed
                else -> throw IllegalArgumentException("Unknown issue state: ${item.state}")
            }
        )
    }
}
