package com.example.githubrepoapp.domain.usecase

import javax.inject.Inject

import com.example.githubrepoapp.domain.model.GithubRepoDomainModel
import com.example.githubrepoapp.domain.repository.GithubRepository

class FetchGithubReposListUseCase @Inject constructor(
    private val githubRepository: GithubRepository
) {
    suspend operator fun invoke() :List<GithubRepoDomainModel> {
        return githubRepository.fetchGithubRepos()
    }
}