package dev.mehdibakhtiari.gitbrowser.presentation.features.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.mehdibakhtiari.gitbrowser.data.Repository
import dev.mehdibakhtiari.gitbrowser.data.models.ProfileEntity
import dev.mehdibakhtiari.gitbrowser.data.models.toProfileEntity
import dev.mehdibakhtiari.gitbrowser.data.models.toReposEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _profileInfo = MutableLiveData<ProfileEntity>()
    val profileInfo : LiveData<ProfileEntity>
    get() = _profileInfo

    init {
        fetchProfileInfo(USER_NAME)
        getGitRepos(USER_NAME)
        observeToProfileInfo()
    }

    private fun fetchProfileInfo(user: String) {
        viewModelScope.launch {
            val result = repository.getGitProfileInfoFromNetwork(user)
            result.body()?.let {
                repository.saveProfileInfo(it.toProfileEntity())
            }
        }
    }

    private fun observeToProfileInfo(){
        viewModelScope.launch {
            repository.getAllProfiles().collect{
                _profileInfo.value = it.firstOrNull()
            }
        }
    }

    private fun getGitRepos(user: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getProfileReposFromNetwork(user)
            result.body()?.let { repos ->
                repos.forEach { repo ->
                    if(repository.isRepoExist(repo.id).not()) {
                        repository.saveRepos(repo.toReposEntity())
                    }
                }
            }
        }
    }

    companion object {
        const val USER_NAME = "mehdi-git"
    }
}