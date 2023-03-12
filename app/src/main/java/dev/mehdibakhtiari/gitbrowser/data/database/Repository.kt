package dev.mehdibakhtiari.gitbrowser.data.database

import dev.mehdibakhtiari.gitbrowser.data.models.ProfileModel
import retrofit2.Response

interface Repository {
    suspend fun getGitProfileInfo(user: String): Response<ProfileModel>
}