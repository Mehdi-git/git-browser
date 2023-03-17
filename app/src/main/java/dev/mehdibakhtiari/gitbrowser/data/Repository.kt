package dev.mehdibakhtiari.gitbrowser.data

import dev.mehdibakhtiari.gitbrowser.data.models.ProfileEntity
import dev.mehdibakhtiari.gitbrowser.data.models.ProfileModel
import dev.mehdibakhtiari.gitbrowser.data.models.ReposEntity
import dev.mehdibakhtiari.gitbrowser.data.models.ReposModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface Repository {

    suspend fun getGitProfileInfoFromNetwork(user: String): Response<ProfileModel>

    suspend fun getProfileReposFromNetwork(user: String): Response<ReposModel>

    suspend fun getAllRepos(): Flow<List<ReposEntity>>

    suspend fun saveRepos(repos: ReposEntity)

    suspend fun deleteRepos(repos: ReposEntity)

    suspend fun getRepoById(id: Int): ReposEntity?

    suspend fun updateRepos(repos: ReposEntity)

    suspend fun isRepoExist(repoId: Int): Boolean

    suspend fun getAllFavoriteRepos(): Flow<List<ReposEntity>>

    suspend fun saveProfileInfo(profileEntity: ProfileEntity)

    suspend fun getProfileInfo(login: String): Flow<ProfileEntity?>

    suspend fun getAllProfiles(): Flow<List<ProfileEntity>>


}