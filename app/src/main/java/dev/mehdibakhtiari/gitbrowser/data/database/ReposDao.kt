package dev.mehdibakhtiari.gitbrowser.data.database

import androidx.room.*
import dev.mehdibakhtiari.gitbrowser.data.models.ReposEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface ReposDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repos: ReposEntity)

    @Delete
    suspend fun delete(repos: ReposEntity)

    @Update
    suspend fun updateRepo(repo: ReposEntity)

    @Query("SELECT * FROM repos_table WHERE id = :id")
    suspend fun get(id: Int): ReposEntity?

    @Query("SELECT * FROM repos_table")
    fun getAllRepos(): Flow<List<ReposEntity>>

    @Query("SELECT * FROM repos_table WHERE isFavorite = 1")
    fun getAllFavoriteRepos(): Flow<List<ReposEntity>>

    @Query("SELECT isFavorite FROM repos_table WHERE id = :id")
    fun isFavorite(id: Int): Flow<Boolean>

    @Query("SELECT EXISTS(SELECT 1 FROM repos_table WHERE id = :repoId)")
    fun isRepoExist(repoId: Int): Boolean

}