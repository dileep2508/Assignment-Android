package com.example.githubsearchapp.repository

import com.example.githubsearchapp.data.api.GitHubApiService
import com.example.githubsearchapp.data.local.RepositoryDao
import com.example.githubsearchapp.data.local.RepositoryEntity

class GitHubRepository(
    private val apiService: GitHubApiService,
    private val dao: RepositoryDao
) {
    fun getCachedRepositories() = dao.getCachedRepositories()

    suspend fun searchRepositories(query: String, page: Int) = apiService.searchRepositories(query, page)

    suspend fun saveRepositoriesOffline(repos: List<RepositoryEntity>) {
        dao.insertAll(repos)
    }

    suspend fun getRepoDetails(owner: String, repo: String) = apiService.getRepoDetails(owner, repo)

    suspend fun getContributors(owner: String, repo: String) = apiService.getContributors(owner, repo)
}
