package dev.mehdibakhtiari.gitbrowser.data.database

import androidx.room.*
import dev.mehdibakhtiari.gitbrowser.data.models.ProfileEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(profile: ProfileEntity)

    @Delete
    suspend fun delete(profile: ProfileEntity)

    @Update
    suspend fun updateProfile(profile: ProfileEntity)

    @Query("SELECT * FROM profile_table WHERE login = :login")
    fun getProfile(login: String): Flow<ProfileEntity?>

    @Query("SELECT * FROM profile_table")
    fun getAllProfiles(): Flow<List<ProfileEntity>>

    @Query("SELECT * FROM profile_table WHERE isFavorite = 1")
    fun getAllFavoriteProfiles(): Flow<List<ProfileEntity>>

    @Query("SELECT isFavorite FROM profile_table WHERE id = :id")
    fun isFavorite(id: Int): Flow<Boolean>

    @Query("SELECT EXISTS(SELECT 1 FROM profile_table WHERE id = :profileId)")
    fun isProfileExist(profileId: Int): Boolean
}