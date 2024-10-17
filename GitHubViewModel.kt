package com.example.githubsearchapp.viewmodel

import androidx.lifecycle.*
import com.example.githubsearchapp.repository.GitHubRepository
import kotlinx.coroutines.launch

class GitHubViewModel(private val repository: GitHubRepository) : ViewModel() {
    private val _searchResults = MutableLiveData<List<RepositoryEntity>>()
    val searchResults: LiveData<List<RepositoryEntity>> get() = _searchResults

    private val _repoDetails = MutableLiveData<RepoDetails>()
    val repoDetails: LiveData<RepoDetails> get() = _repoDetails

    fun searchRepositories(query: String, page: Int) {
        viewModelScope.launch {
            val repos = repository.searchRepositories(query, page).items
            _searchResults.postValue(repos)
        }
    }

    fun getRepoDetails(owner: String, repo: String) {
        viewModelScope.launch {
            val details = repository.getRepoDetails(owner, repo)
            _repoDetails.postValue(details)
        }
    }
}
