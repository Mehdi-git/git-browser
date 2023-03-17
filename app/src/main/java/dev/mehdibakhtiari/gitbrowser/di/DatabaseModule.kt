package dev.mehdibakhtiari.gitbrowser.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.mehdibakhtiari.gitbrowser.data.database.GitBrowserDatabase
import dev.mehdibakhtiari.gitbrowser.data.database.ProfileDao
import dev.mehdibakhtiari.gitbrowser.data.database.ReposDao
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): GitBrowserDatabase {
        return Room.databaseBuilder(
            context,
            GitBrowserDatabase::class.java,
            GitBrowserDatabase.DB_NAME
        ).build()
    }

    @Provides
    fun provideRepoDao(database: GitBrowserDatabase): ReposDao {
        return database.reposDao()
    }

    @Provides
    fun provideProfileDao(database: GitBrowserDatabase): ProfileDao {
        return database.profileDao()
    }
}