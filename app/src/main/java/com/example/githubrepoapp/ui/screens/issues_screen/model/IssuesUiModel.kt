package com.example.githubrepoapp.ui.screens.issues_screen.model

import com.example.githubrepoapp.domain.model.IssueState

data class IssuesUiModel(
    val id:Int,
    val title: String,
    val author: String,
    val date: String,
    val state: IssueState,
)
