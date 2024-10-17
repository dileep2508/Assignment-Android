package com.example.githubsearchapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.githubsearchapp.ui.HomeScreen
import com.example.githubsearchapp.ui.RepoDetailsScreen
import com.example.githubsearchapp.viewmodel.GitHubViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: GitHubViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Switch between HomeScreen and RepoDetailsScreen based on navigation
            HomeScreen(viewModel)
        }
    }
}
