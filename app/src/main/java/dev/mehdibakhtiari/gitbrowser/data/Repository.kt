package dev.mehdibakhtiari.gitbrowser.data

import dev.mehdibakhtiari.gitbrowser.data.models.ProfileModel
import dev.mehdibakhtiari.gitbrowser.data.models.ReposEntity
import dev.mehdibakhtiari.gitbrowser.data.models.ReposModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface Repository {

    suspend fun getGitProfileInfo(user: String): Response<ProfileModel>

    suspend fun getProfileRepos(user: String): Response<ReposModel>

    suspend fun getAllRepos(): Flow<List<ReposEntity>>

    suspend fun saveRepos(repos: ReposEntity)

    suspend fun deleteRepos(repos: ReposEntity)

    suspend fun getRepoById(id: Int): ReposEntity?

    suspend fun updateRepos(repos: ReposEntity)

    suspend fun isRepoExist(repoId: Int): Boolean

    suspend fun getAllFavoriteItems(): Flow<List<ReposEntity>>
}