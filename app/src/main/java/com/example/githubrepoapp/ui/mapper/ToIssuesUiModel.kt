package com.example.githubrepoapp.ui.mapper


import com.example.githubrepoapp.data.dataSources.remote.retrofit.datamodel.issues.IssuesDataModelItem
import com.example.githubrepoapp.domain.model.IssueState
import com.example.githubrepoapp.domain.model.IssuesDomainModel
import com.example.githubrepoapp.ui.screens.issues_screen.model.IssuesUiModel

fun List<IssuesDomainModel>.toIssuesUiModel(): List<IssuesUiModel> {
    return this.map { item ->
        IssuesUiModel(
            id = item.id.toInt(),
            title = item.title,
            author = item.user.login,
            date = item.created_at,
            state = IssueState.valueOf(item.state.toString())
        )
    }
}