package com.example.githubrepoapp.domain.repository


import com.example.githubrepoapp.domain.model.IssueState
import com.example.githubrepoapp.domain.model.IssuesDomainModel
import com.example.githubrepoapp.ui.screens.issues_screen.model.IssuesUiModel

interface IssuesRepository {
    suspend fun getIssues(owner: String, name: String): List<IssuesDomainModel>
}