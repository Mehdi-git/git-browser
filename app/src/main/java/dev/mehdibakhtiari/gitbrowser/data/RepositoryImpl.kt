package dev.mehdibakhtiari.gitbrowser.data

import dev.mehdibakhtiari.gitbrowser.data.database.ReposDao
import dev.mehdibakhtiari.gitbrowser.data.models.ProfileModel
import dev.mehdibakhtiari.gitbrowser.data.models.ReposEntity
import dev.mehdibakhtiari.gitbrowser.data.models.ReposModel
import dev.mehdibakhtiari.gitbrowser.data.network.GitReposService
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor (
    private val gitReposService: GitReposService,
    private val database: ReposDao,
    ): Repository {

    override suspend fun getGitProfileInfo(user: String): Response<ProfileModel> =
        gitReposService.getGitProfileInfo(user)

    override suspend fun getProfileRepos(user: String): Response<ReposModel> =
        gitReposService.getGitRepos(user)

    override suspend fun getAllRepos(): Flow<List<ReposEntity>> = database.getAllRepos()

    override suspend fun saveRepos(repos: ReposEntity) = database.insert(repos)

    override suspend fun deleteRepos(repos: ReposEntity) = database.delete(repos)

    override suspend fun getRepoById(id: Int): ReposEntity? = database.get(id)

    override suspend fun updateRepos(repos: ReposEntity) = database.updateRepo(repos)

    override suspend fun isRepoExist(repoId: Int): Boolean = database.isRepoExist(repoId)

    override suspend fun getAllFavoriteItems(): Flow<List<ReposEntity>> =
        database.getAllFavoriteRepos()
}