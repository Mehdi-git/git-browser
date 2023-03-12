package dev.mehdibakhtiari.gitbrowser.presentation.features.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.mehdibakhtiari.gitbrowser.data.database.Repository
import dev.mehdibakhtiari.gitbrowser.data.models.ReposItem
import dev.mehdibakhtiari.gitbrowser.data.models.ReposModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ReposViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _reposLiveData = MutableLiveData<ReposModel>()
    val reposLiveData: LiveData<ReposModel>
        get() = _reposLiveData

    init {
        getGitRepos(GIT_ID)
    }

    private fun getGitRepos(user: String) {
        viewModelScope.launch {
            val result = repository.getProfileRepos(user)
            result.body()?.let {
                _reposLiveData.value = it
            }
        }
    }

    fun onFavoriteClick(reposItem: ReposItem) {

    }

    companion object {
        const val GIT_ID = "mehdi-git"
    }


}