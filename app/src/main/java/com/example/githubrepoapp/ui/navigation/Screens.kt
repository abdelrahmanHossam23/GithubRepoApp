package com.example.githubrepoapp.ui.navigation

import com.example.githubrepoapp.ui.utils.Constants.Companion.NAME_ARGUMENT_KEY
import com.example.githubrepoapp.ui.utils.Constants.Companion.NAME_KEY
import com.example.githubrepoapp.ui.utils.Constants.Companion.OWNER_ARGUMENT_KEY
import com.example.githubrepoapp.ui.utils.Constants.Companion.REPO_DETAILS

sealed class Screens(val route: String) {
    data object RepoListScreen: Screens("repo_list_screen")
    data object RepoDetailsScreen: Screens("$REPO_DETAILS/{$OWNER_ARGUMENT_KEY}/{$NAME_ARGUMENT_KEY}"){
        fun passOwnerAndName(owner: String, name:String): String {
            return "$REPO_DETAILS/$owner/$name"
        }
    }
}