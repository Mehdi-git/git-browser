package dev.mehdibakhtiari.gitbrowser.data

import dev.mehdibakhtiari.gitbrowser.data.database.ProfileDao
import dev.mehdibakhtiari.gitbrowser.data.database.ReposDao
import dev.mehdibakhtiari.gitbrowser.data.models.ProfileEntity
import dev.mehdibakhtiari.gitbrowser.data.models.ProfileModel
import dev.mehdibakhtiari.gitbrowser.data.models.ReposEntity
import dev.mehdibakhtiari.gitbrowser.data.models.ReposModel
import dev.mehdibakhtiari.gitbrowser.data.network.GitReposService
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor (
    private val gitReposService: GitReposService,
    private val reposDatabase: ReposDao,
    private val profileDatabase: ProfileDao
    ): Repository {

    override suspend fun getGitProfileInfoFromNetwork(user: String): Response<ProfileModel> =
        gitReposService.getGitProfileInfo(user)

    override suspend fun getProfileReposFromNetwork(user: String): Response<ReposModel> =
        gitReposService.getGitRepos(user)

    override suspend fun getAllRepos(): Flow<List<ReposEntity>> = reposDatabase.getAllRepos()

    override suspend fun saveRepos(repos: ReposEntity) = reposDatabase.insert(repos)

    override suspend fun deleteRepos(repos: ReposEntity) = reposDatabase.delete(repos)

    override suspend fun getRepoById(id: Int): ReposEntity? = reposDatabase.get(id)

    override suspend fun updateRepos(repos: ReposEntity) = reposDatabase.updateRepo(repos)

    override suspend fun isRepoExist(repoId: Int): Boolean = reposDatabase.isRepoExist(repoId)

    override suspend fun getAllFavoriteRepos(): Flow<List<ReposEntity>> =
        reposDatabase.getAllFavoriteRepos()

    override suspend fun saveProfileInfo(profileEntity: ProfileEntity) =
        profileDatabase.insert(profileEntity)

    override suspend fun getProfileInfo(login: String): Flow<ProfileEntity?> =
        profileDatabase.getProfile(login)

    override suspend fun getAllProfiles(): Flow<List<ProfileEntity>>  =
        profileDatabase.getAllProfiles()


}