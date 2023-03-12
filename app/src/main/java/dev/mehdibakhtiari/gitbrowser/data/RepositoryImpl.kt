package dev.mehdibakhtiari.gitbrowser.data

import dev.mehdibakhtiari.gitbrowser.data.database.Repository
import dev.mehdibakhtiari.gitbrowser.data.models.ProfileModel
import dev.mehdibakhtiari.gitbrowser.data.models.ReposModel
import dev.mehdibakhtiari.gitbrowser.data.network.GitReposService
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor (
    private val gitReposService: GitReposService
    ): Repository {

    override suspend fun getGitProfileInfo(user: String): Response<ProfileModel> {
       return gitReposService.getGitProfileInfo(user)
    }

    override suspend fun getProfileRepos(user: String): Response<ReposModel> {
        return gitReposService.getGitRepos(user)
    }

}