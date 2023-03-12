package dev.mehdibakhtiari.gitbrowser.presentation.features.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.mehdibakhtiari.gitbrowser.data.database.Repository
import dev.mehdibakhtiari.gitbrowser.data.models.ProfileModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _profileInfo = MutableLiveData<ProfileModel>()
    val profileInfo : LiveData<ProfileModel>
    get() = _profileInfo

    init {
        fetchProfileInfo()
    }

    fun fetchProfileInfo() {
        viewModelScope.launch {
            val result = repository.getGitProfileInfo("mehdi-git")
            result.body()?.let {
                _profileInfo.value = it
            }
        }
    }
}