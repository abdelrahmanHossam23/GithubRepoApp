package com.example.githubrepoapp.ui.screens.issues_screen.preview

import com.example.githubrepoapp.domain.model.IssueState
import com.example.githubrepoapp.ui.screens.issues_screen.model.IssuesUiModel

val issuesUiModelPreviewData = IssuesUiModel(
    id = 12345,
    title = "Issue Title",
    author = "Seif",
    date = "Created At: 2023-01-01, 14:00 PM",
    state = IssueState.Open
)