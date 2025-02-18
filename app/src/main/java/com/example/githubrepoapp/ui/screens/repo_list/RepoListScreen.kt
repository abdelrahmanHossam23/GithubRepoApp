package com.example.githubrepoapp.ui.screens.repo_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.githubrepoapp.R
import com.example.githubrepoapp.ui.common_components.AppBar
import com.example.githubrepoapp.ui.common_components.ErrorSection
import com.example.githubrepoapp.ui.common_components.shimmer.trending.AnimateShimmerTrendingList
import com.example.githubrepoapp.ui.model.CustomExceptionUiModel
import com.example.githubrepoapp.ui.screens.repo_list.components.RepoItem
import com.example.githubrepoapp.ui.screens.repo_list.model.GithubRepoUiModel
import com.example.githubrepoapp.ui.screens.repo_list.viewmodel.RepoListViewModel
import com.example.githubrepoapp.ui.theme.GithubRepoAppTheme
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun RepoListScreen(
    modifier: Modifier = Modifier,
    onRepoItemClicked: (repoItem: GithubRepoUiModel) -> Unit,
) {
    val repoListViewModel: RepoListViewModel = hiltViewModel()
    val repoListUiState = repoListViewModel.repoListStatFlow.collectAsStateWithLifecycle()
    val coroutineScope = rememberCoroutineScope()
    RepoListContent(
        modifier = modifier,
        repoListUiState = repoListUiState.value,
        onRepoItemClicked = onRepoItemClicked,
        onRefreshButtonClicked = {
            coroutineScope.launch {
                repoListViewModel.requestGithubRepoList()
            }
        }
    )

}

@ExperimentalMaterial3Api
@Composable
fun RepoListContent(
    modifier: Modifier = Modifier,
    repoListUiState: RepoListUiState,
    onRepoItemClicked: (githubRepoUiModel: GithubRepoUiModel) -> Unit,
    onRefreshButtonClicked: () -> Unit
) {

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        topBar = {
            AppBar(
                title = R.string.repository_screen_title,
                showBackButton = false
            )
        }
    ) { innerPadding ->

        when {
            repoListUiState.isLoading -> {
                AnimateShimmerTrendingList()
            }

            repoListUiState.isError -> {
                repoListUiState.errorMessage?.let {
                    ErrorSection(
                        onRefreshButtonClicked = onRefreshButtonClicked,
                        customErrorExceptionUiModel = it
                    )
                }
            }

            else -> {
                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .padding(bottom = 8.dp)
                        .padding(innerPadding)
                ) {
                    items(repoListUiState.repoList) { repoItem ->
                        RepoItem(repoItem, onRepoItemClicked = {
                            onRepoItemClicked(it)
                        }
                        )
                    }
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
private fun PreviewRepoScreen() {
    GithubRepoAppTheme {
//        RepoListScreen(repoListUiModel = fakeRepoUiModelList) {
//
//        }
    }
}