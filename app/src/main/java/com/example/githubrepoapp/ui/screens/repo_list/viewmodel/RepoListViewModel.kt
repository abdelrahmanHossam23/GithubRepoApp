package com.example.githubrepoapp.ui.screens.repo_list.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubrepoapp.domain.model.CustomExceptionDomainModel
import com.example.githubrepoapp.domain.usecase.FetchGithubReposListUseCase
import com.example.githubrepoapp.ui.mapper.toCustomExceptionPresentationModel
import com.example.githubrepoapp.ui.mapper.toGithubRepoUiModel
import com.example.githubrepoapp.ui.screens.repo_list.RepoListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepoListViewModel @Inject constructor(
    private val fetchGithubReposUseCase: FetchGithubReposListUseCase
): ViewModel() {
    private val _repoListStateFlow: MutableStateFlow<RepoListUiState> = MutableStateFlow(RepoListUiState(isLoading = true))
    val repoListStatFlow: StateFlow<RepoListUiState> = _repoListStateFlow.asStateFlow()

    init {
        requestGithubRepoList()
    }
    fun requestGithubRepoList() {
        _repoListStateFlow.value = RepoListUiState(isLoading = true)
        // result
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val githubRepoListDomainModel = fetchGithubReposUseCase.invoke()
                _repoListStateFlow.value = RepoListUiState(
                    isLoading = false,
                    repoList = githubRepoListDomainModel.map { it.toGithubRepoUiModel() }
                )
            } catch (e:Exception) {
                _repoListStateFlow.value = RepoListUiState(
                    isLoading = false,
                    isError = true,
                    errorMessage = (e as CustomExceptionDomainModel).toCustomExceptionPresentationModel()
                )
            }
        }
    }
}