package dev.mehdibakhtiari.gitbrowser.presentation.features.repos

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.mehdibakhtiari.gitbrowser.data.Repository
import dev.mehdibakhtiari.gitbrowser.data.models.ReposEntity
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ReposViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _reposLiveData = MutableLiveData<List<ReposEntity>>()
    val reposLiveData: MutableLiveData<List<ReposEntity>>
        get() = _reposLiveData

    init {
        handleFavoriteItems()

    }

    private fun toggleFavorite(repoId: Int, isFavorite: Boolean) {
        viewModelScope.launch {
            repository.getRepoById(repoId)?.apply {
                this.isFavorite = isFavorite
            }?.let {
                repository.updateRepos(it)
            }
        }
    }

    private fun handleFavoriteItems () {
        viewModelScope.launch {
            repository.getAllRepos().collect{
                _reposLiveData.value = it
            }
        }
    }

    fun onFavoriteClick(reposEntity: ReposEntity) {
       toggleFavorite(reposEntity.id, reposEntity.isFavorite.not())
    }

}