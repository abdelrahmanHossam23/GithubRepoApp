package com.example.githubrepoapp.ui.screens.issues_screen

import com.example.githubrepoapp.ui.model.CustomExceptionUiModel
import com.example.githubrepoapp.ui.screens.issues_screen.model.IssuesUiModel
import com.example.githubrepoapp.ui.screens.repo_details_screen.model.RepoDetailsUiModel


//data class IssuesUiState(
//    val issuesList: List<IssuesUiModel>? = null,
//    val isLoading: Boolean = false,
//    val isError: Boolean = false,
//    val customErrorExceptionUiModel: CustomExceptionUiModel = CustomExceptionUiModel.Unknown
//)



sealed class IssuesUiState {
    object InitialState : IssuesUiState()
    data class Loading(val isLoading: Boolean = true) : IssuesUiState()
    data class IssuesUiModelData(val issuesList: List<IssuesUiModel>) : IssuesUiState()
    data class Error(val errorMessage: String) : IssuesUiState()
}