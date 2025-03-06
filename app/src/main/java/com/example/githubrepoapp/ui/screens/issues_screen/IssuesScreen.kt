package com.example.githubrepoapp.ui.screens.issues_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import com.example.githubrepoapp.R
import com.example.githubrepoapp.ui.common_components.AppBar
import com.example.githubrepoapp.ui.common_components.ErrorSection
import com.example.githubrepoapp.ui.common_components.shimmer.issues.AnimateShimmerIssuesList
import com.example.githubrepoapp.ui.screens.issues_screen.model.IssuesUiModel
import com.example.githubrepoapp.ui.screens.issues_screen.preview.issuesUiModelPreviewData
import com.example.githubrepoapp.ui.theme.GithubRepoAppTheme
import com.example.githubrepoapp.ui.theme.LightGreen

//
//@ExperimentalMaterial3Api
//@Composable
//fun IssuesScreen(
//    issuesUiState: IssuesUiState,
//    onRefreshList: () -> Unit,
//    onBackArrowClicked: () -> Unit
//) {
//    Column(modifier = Modifier
//        .fillMaxSize()
//        .background(color = MaterialTheme.colorScheme.background)) {
//        AppBar(
//            title = R.string.issues_app_bar_title,
//            onBackButtonClicked = { onBackArrowClicked() }
//        )
//        when {
//            issuesUiState.isLoading -> {
//                AnimateShimmerIssuesList()
//            }
//            issuesUiState.issuesList != null -> {
//                val isRefreshing by remember { // in viewmodel and before calling api make on refreshing = true then after getting data from api make onrefreshing = false
//                    mutableStateOf(false)
//                }
//                IssuesContent(issuesUiState.issuesList,isRefreshing = isRefreshing, onPulledToRefresh = onRefreshList)
//            }
//            else ->{
//                ErrorSection(
//                    onRefreshButtonClicked = onRefreshList,
//                    customErrorExceptionUiModel = issuesUiState.customErrorExceptionUiModel
//                )
//            }
//        }
//    }
//}
//
//@ExperimentalMaterial3Api
//@Composable
//fun IssuesContent(
//    issuesList: List<IssuesUiModel>,
//    isRefreshing:Boolean,
//    onPulledToRefresh: () -> Unit
//) {
//    val pullToRefreshState = rememberPullToRefreshState()
//    Box(
//        Modifier
//            .fillMaxSize()
//            .nestedScroll(pullToRefreshState.nestedScrollConnection)
//    ) {
//        IssuesLazyColumn(
//            issuesList = issuesList
//        )
//
//        if (pullToRefreshState.isRefreshing){
//            LaunchedEffect(key1 = true) {
//                onPulledToRefresh()
//            }
//        }
//
//        LaunchedEffect(key1 = isRefreshing) {
//            if (isRefreshing)
//                pullToRefreshState.startRefresh()
//            else
//                pullToRefreshState.endRefresh()
//        }
//
//        PullToRefreshContainer(
//            state = pullToRefreshState,
//            modifier = Modifier.align(Alignment.TopCenter),
//            contentColor = LightGreen
//        )
//    }
//
//}
//
//@ExperimentalMaterial3Api
//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun PreviewTrendingGithubScreen() {
//    GithubRepoAppTheme(darkTheme = false) {
//        IssuesScreen(
//            issuesUiState = IssuesUiState(
//                issuesList  = listOf(issuesUiModelPreviewData)
//            ),
//            onRefreshList = {},
//            onBackArrowClicked = {}
//        )
//    }
//}




import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.githubrepoapp.ui.common_components.AppBar
import com.example.githubrepoapp.ui.common_components.ErrorSection
import com.example.githubrepoapp.ui.common_components.shimmer.issues.AnimateShimmerIssuesList
import com.example.githubrepoapp.ui.model.CustomExceptionUiModel
import com.example.githubrepoapp.ui.screens.issues_screen.viewmodel.IssueListViewModel
import com.example.githubrepoapp.ui.screens.repo_details_screen.model.RepoDetailsUiState
import com.example.githubrepoapp.ui.theme.GithubRepoAppTheme
import com.example.githubrepoapp.ui.theme.LightGreen

@ExperimentalMaterial3Api
@Composable
fun IssuesScreen(
    owner: String,
    name: String,
    onBackArrowClicked: () -> Unit
) {
    val issueListViewModel: IssueListViewModel = hiltViewModel()
    val issuesUiState by issueListViewModel.issuesUiState.collectAsStateWithLifecycle()
    val isRefreshing by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        issueListViewModel.fetchIssues(owner, name)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        AppBar(
            title = R.string.issues_app_bar_title,
            onBackButtonClicked = onBackArrowClicked
        )
        when(issuesUiState) {

            IssuesUiState.InitialState -> {}

            is IssuesUiState.Loading -> {
                AnimateShimmerIssuesList()
            }
            is IssuesUiState.IssuesUiModelData  -> {
                IssuesContent(
                    issuesList = (issuesUiState as IssuesUiState.IssuesUiModelData).issuesList,
                    isRefreshing = isRefreshing,
                    onPulledToRefresh = { issueListViewModel.fetchIssues(owner, name) }
                )
            }
            else -> {
                ErrorSection(
                    onRefreshButtonClicked = { issueListViewModel.fetchIssues(owner, name) },
                    customErrorExceptionUiModel = CustomExceptionUiModel.Network
                )
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun IssuesContent(
    issuesList: List<IssuesUiModel>,
    isRefreshing: Boolean,
    onPulledToRefresh: () -> Unit
) {
    val pullToRefreshState = rememberPullToRefreshState()
    Box(
        Modifier
            .fillMaxSize()
            .nestedScroll(pullToRefreshState.nestedScrollConnection)
    ) {
        IssuesLazyColumn(issuesList = issuesList)

        if (pullToRefreshState.isRefreshing) {
            LaunchedEffect(key1 = true) {
                onPulledToRefresh()
            }
        }

        LaunchedEffect(key1 = isRefreshing) {
            if (isRefreshing) {
                pullToRefreshState.startRefresh()
            } else {
                pullToRefreshState.endRefresh()
            }
        }

//        PullToRefreshContainer(
//            state = pullToRefreshState,
//            modifier = Modifier.align(Alignment.TopCenter),
//            contentColor = LightGreen
//        )
    }
}

@ExperimentalMaterial3Api
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewTrendingGithubScreen() {
    GithubRepoAppTheme(darkTheme = false) {
        IssuesScreen(
            owner = "owner",
            name = "name",
            onBackArrowClicked = {}
        )
    }
}