package com.example.githubsearchapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.githubsearchapp.viewmodel.GitHubViewModel

@Composable
fun RepoDetailsScreen(viewModel: GitHubViewModel, owner: String, repo: String) {
    val repoDetails by viewModel.repoDetails.observeAsState()

    repoDetails?.let { details ->
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberImagePainter(data = details.owner.avatar_url),
                contentDescription = null,
                modifier = Modifier.size(64.dp)
            )
            Text(details.name)
            Text(details.description ?: "No description")
            Text(
                text = "Project Link",
                color = Color.Blue,
                modifier = Modifier.clickable {
                    // Handle web view navigation
                }
            )
        }
    }
}
