package com.example.githubrepoapp.ui.screens.issues_screen

import com.example.githubrepoapp.ui.model.CustomExceptionUiModel
import com.example.githubrepoapp.ui.screens.issues_screen.model.IssuesUiModel


data class IssuesUiState(
    val issuesList: List<IssuesUiModel>? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val customErrorExceptionUiModel: CustomExceptionUiModel = CustomExceptionUiModel.Unknown
)