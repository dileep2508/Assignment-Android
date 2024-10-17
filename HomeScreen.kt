package com.example.githubsearchapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.githubsearchapp.viewmodel.GitHubViewModel

@Composable
fun HomeScreen(viewModel: GitHubViewModel) {
    val searchResults by viewModel.searchResults.observeAsState(emptyList())
    var query by remember { mutableStateOf("") }

    Column {
        TextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Search Repositories") },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        LazyColumn {
            items(searchResults.size) { index ->
                val repo = searchResults[index]
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .clickable { /* Navigate to RepoDetailsScreen */ }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(repo.name)
                        Text(repo.owner)
                        Text(repo.description ?: "No description")
                    }
                }
            }
        }
    }
}
