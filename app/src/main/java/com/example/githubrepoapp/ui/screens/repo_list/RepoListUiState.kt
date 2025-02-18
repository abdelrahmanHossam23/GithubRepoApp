package com.example.githubrepoapp.ui.screens.repo_list

import com.example.githubrepoapp.ui.model.CustomExceptionUiModel
import com.example.githubrepoapp.ui.screens.repo_list.model.GithubRepoUiModel

data class RepoListUiState(
    val isLoading:Boolean = false,
    val isError:Boolean = false,
    val errorMessage: CustomExceptionUiModel? = null,
    val repoList: List<GithubRepoUiModel> = emptyList()
)