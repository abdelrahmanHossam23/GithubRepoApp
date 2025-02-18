package com.example.githubrepoapp.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.githubrepoapp.ui.screens.repo_details_screen.RepoDetailsScreen
import com.example.githubrepoapp.ui.screens.repo_list.RepoListScreen
import com.example.githubrepoapp.ui.utils.Constants.Companion.NAME_ARGUMENT_KEY
import com.example.githubrepoapp.ui.utils.Constants.Companion.OWNER_ARGUMENT_KEY

@ExperimentalMaterial3Api
@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    // var githubRepoUiModel: GithubRepoUiModel? = null
    NavHost(
        navController = navController,
        startDestination = Screens.RepoListScreen.route
    ) {
        composable(route = Screens.RepoListScreen.route) {
            RepoListScreen {
                navController.navigate(Screens.RepoDetailsScreen.passOwnerAndName(name = it.name, owner = it.owner))
            }
        }

        composable(
            route = Screens.RepoDetailsScreen.route,
            arguments = listOf(
                navArgument(OWNER_ARGUMENT_KEY) {
                    type = NavType.StringType
                },
                navArgument(NAME_ARGUMENT_KEY) {
                    type = NavType.StringType
                },
            )
        ) {
            val owner = it.arguments?.getString(OWNER_ARGUMENT_KEY)
            val name = it.arguments?.getString(NAME_ARGUMENT_KEY)
            if (owner != null && name != null) {
                RepoDetailsScreen(
                    owner = owner,
                    name = name,
                    onClickBack = { navController.navigateUp() },
                    onClickViewIssues = {

                    }) {
                }
            }
        }
    }
}