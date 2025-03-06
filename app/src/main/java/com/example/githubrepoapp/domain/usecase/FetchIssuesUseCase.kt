package com.example.githubrepoapp.domain.usecase


import com.example.githubrepoapp.domain.model.IssuesDomainModel
import com.example.githubrepoapp.domain.repository.IssuesRepository
import com.example.githubrepoapp.ui.screens.issues_screen.model.IssuesUiModel
import javax.inject.Inject

class FetchIssuesUseCase @Inject constructor(
    private val issuesRepository: IssuesRepository
) {
    suspend operator fun invoke(owner: String, name: String): List<IssuesDomainModel> {
        return issuesRepository.getIssues(owner, name)
    }
}