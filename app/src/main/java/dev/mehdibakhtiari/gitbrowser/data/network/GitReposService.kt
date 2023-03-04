package dev.mehdibakhtiari.gitbrowser.data.network

import dev.mehdibakhtiari.gitbrowser.data.models.ProfileModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitReposService {
    @GET("users/{user}")
    suspend fun getGitProfileInfo(@Path("user") user: String): Response<ProfileModel>
}