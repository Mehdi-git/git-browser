package dev.mehdibakhtiari.gitbrowser.presentation.features.favorites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.mehdibakhtiari.gitbrowser.data.Repository
import dev.mehdibakhtiari.gitbrowser.data.models.ReposEntity
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(private val repository: Repository) : ViewModel(){

    private val _favoriteReposLiveData = MutableLiveData<List<ReposEntity>>()
    val favoriteReposLiveData: MutableLiveData<List<ReposEntity>>
        get() = _favoriteReposLiveData

    init {
        handleFavoriteItems()
    }

    private fun handleFavoriteItems () {
        viewModelScope.launch {
            repository.getAllFavoriteRepos().collect{
                _favoriteReposLiveData.value = it
            }
        }
    }

    fun removeFavoriteRepo(reposEntity: ReposEntity) {
        viewModelScope.launch {
            repository.updateRepos(reposEntity.copy(isFavorite = false))
        }
    }
}