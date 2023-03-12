package dev.mehdibakhtiari.gitbrowser.data.database

import dev.mehdibakhtiari.gitbrowser.data.models.ProfileModel
import dev.mehdibakhtiari.gitbrowser.data.models.ReposModel
import retrofit2.Response

interface Repository {

    suspend fun getGitProfileInfo(user: String): Response<ProfileModel>

    suspend fun getProfileRepos(user: String): Response<ReposModel>
}