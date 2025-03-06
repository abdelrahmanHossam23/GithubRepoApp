package com.example.githubrepoapp.ui.screens.issues_screen.viewmodel


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubrepoapp.domain.model.CustomExceptionDomainModel
import com.example.githubrepoapp.domain.usecase.FetchIssuesUseCase
import com.example.githubrepoapp.ui.mapper.toCustomExceptionPresentationModel
import com.example.githubrepoapp.ui.screens.issues_screen.IssuesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


import com.example.githubrepoapp.ui.mapper.toCustomExceptionPresentationModel

import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.example.githubrepoapp.ui.mapper.toIssuesUiModel

@HiltViewModel
class IssueListViewModel @Inject constructor(
    private val fetchIssuesUseCase: FetchIssuesUseCase
) : ViewModel() {

    private val _issuesUiState = MutableStateFlow<IssuesUiState>(IssuesUiState.InitialState)
    val issuesUiState: StateFlow<IssuesUiState> = _issuesUiState.asStateFlow()

    fun fetchIssues(owner: String, name: String) {
        _issuesUiState.value = IssuesUiState.Loading(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val issues = fetchIssuesUseCase(owner, name)
                Log.d("IssueListViewModel", "Fetched issues: $issues")
                _issuesUiState.value = IssuesUiState.Loading(isLoading = false)
                _issuesUiState.value = IssuesUiState.IssuesUiModelData(issuesList = issues.toIssuesUiModel())
            } catch (e: Exception) {
                Log.e("IssueListViewModel", "Error fetching issues: ${e.message}")
                _issuesUiState.value = IssuesUiState.Loading(isLoading = false)
                _issuesUiState.value = IssuesUiState.Error(
                    errorMessage = if (e is CustomExceptionDomainModel) {
                        e.toCustomExceptionPresentationModel().toString()
                    } else {
                        "An unknown error occurred: ${e.localizedMessage}"
                    }
                )
            }
        }
    }
}